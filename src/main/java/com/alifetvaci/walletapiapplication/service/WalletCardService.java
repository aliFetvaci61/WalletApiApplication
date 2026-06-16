package com.alifetvaci.walletapiapplication.service;

import com.alifetvaci.walletapiapplication.delegate.CampaignClient;
import com.alifetvaci.walletapiapplication.delegate.CampaignResponse;
import com.alifetvaci.walletapiapplication.dto.CreateWalletCardRequest;
import com.alifetvaci.walletapiapplication.dto.WalletCardCacheDto;
import com.alifetvaci.walletapiapplication.dto.WalletCardResponse;
import com.alifetvaci.walletapiapplication.dto.*;
import com.alifetvaci.walletapiapplication.entity.WalletCard;
import com.alifetvaci.walletapiapplication.exception.ResourceNotFoundException;
import com.alifetvaci.walletapiapplication.repository.WalletCardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
// Bu sınıfın Service katmanı olduğunu belirtir.
// Business logic (iş kuralları) burada yazılır.

@RequiredArgsConstructor
// final olan field'lar için constructor oluşturur.
// Dependency Injection (DI) otomatik yapılır.

public class WalletCardService {

    private final WalletCardRepository repository;
    // PostgreSQL ile iletişim kuran katman (CRUD işlemleri)

    private final RedisService redisService;
    // Redis cache işlemlerini yöneten servis

    private final CampaignClient campaignClient;
    // Feign Client ile dış servis çağrısı yapar

    public WalletCardResponse create(CreateWalletCardRequest request) {

        // Request → Entity dönüşümü yapıyoruz
        WalletCard card = WalletCard.builder()
                .ownerName(request.getOwnerName())
                .cardNumber(request.getCardNumber())
                .balance(request.getBalance())
                .build();

        // Entity database'e kaydedilir
        return map(repository.save(card));
    }

    public List<WalletCardResponse> getAll() {

        // Tüm kayıtları DB'den alıp Response'a çeviriyoruz
        return repository.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    public WalletCardResponse getById(Long id) {

        String cacheKey = "wallet-card:" + id;
        // Redis için unique key oluşturuyoruz

        WalletCardCacheDto cached =
                (WalletCardCacheDto) redisService.get(cacheKey);
        // Önce Redis kontrol edilir (cache hit)

        if (cached != null) {

            System.out.println("Redis'ten döndü");

            // Redis'ten geldiyse DB'ye gitmeden response dönülür
            return WalletCardResponse.builder()
                    .id(cached.getId())
                    .ownerName(cached.getOwnerName())
                    .cardNumber(cached.getCardNumber())
                    .balance(cached.getBalance())
                    .build();
        }

        // Cache miss → DB'ye git
        WalletCard card = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Kart bulunamadı: " + id
                        ));

        // DB'den gelen veri Redis'e yazılır (cache populate)
        redisService.save(
                cacheKey,
                WalletCardCacheDto.builder()
                        .id(card.getId())
                        .ownerName(card.getOwnerName())
                        .cardNumber(card.getCardNumber())
                        .balance(card.getBalance())
                        .build(),
                Duration.ofMinutes(10)
        );

        return map(card);
    }

    public CampaignResponse getCampaign(Long id) {

        // Feign Client ile dış servise HTTP request atılır
        return campaignClient.getCampaign(id);
    }

    private WalletCardResponse map(WalletCard card) {

        // Entity → Response DTO dönüşümü
        return WalletCardResponse.builder()
                .id(card.getId())
                .ownerName(card.getOwnerName())
                .cardNumber(card.getCardNumber())
                .balance(card.getBalance())
                .build();
    }
}
package com.alifetvaci.walletapiapplication.controller;

import com.alifetvaci.walletapiapplication.delegate.CampaignResponse;
import com.alifetvaci.walletapiapplication.dto.CreateWalletCardRequest;
import com.alifetvaci.walletapiapplication.dto.WalletCardResponse;
import com.alifetvaci.walletapiapplication.dto.*;
import com.alifetvaci.walletapiapplication.service.WalletCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * CONTROLLER KATMANI
 *
 * Bu sınıf:
 * - Mobile / frontend uygulamadan gelen HTTP isteklerini karşılar
 * - Business logic içermez (sadece yönlendirir)
 * - Service katmanını çağırır
 */

@RestController
/**
 * Bu sınıfın REST API controller olduğunu belirtir.
 * Yani:
 * - HTTP request alır
 * - JSON response döner
 */

@RequestMapping("/api/v1/wallet-cards")
/**
 * Base URL tanımıdır.
 * Bu controller içindeki tüm endpointler:
 * /api/v1/wallet-cards ile başlar.
 */

@RequiredArgsConstructor
/**
 * Lombok annotation:
 * final olan field'lar için constructor üretir.
 * Yani şu otomatik oluşur:
 * public WalletCardController(WalletCardService service)
 * Bu sayede Dependency Injection yapılır.
 */
public class WalletCardController {


    /**
     * İş mantığını içeren Service katmanının referansıdır.
     *
     * Controller, gelen HTTP isteklerini doğrudan işlemez.
     * Gerekli operasyonları gerçekleştirmesi için Service katmanını çağırır.
     *
     * 'final' olarak tanımlandığı için nesne oluşturulduktan sonra değiştirilemez.
     * @RequiredArgsConstructor sayesinde constructor üzerinden Dependency Injection yapılır.
     */
    private final WalletCardService service;

    @PostMapping
    /**
     * HTTP POST isteğini karşılar.
     */
    public WalletCardResponse create(
            @RequestBody CreateWalletCardRequest request) {
        /**
         * @RequestBody:
         * JSON request body → Java object'e çevirir.
         */
        return service.create(request);
    }

    @GetMapping
    /**
     * HTTP GET isteği karşılar
     */
    public List<WalletCardResponse> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    /**
     * PathVariable kullanımı
     *
     * URL'den gelen id değerini alır:
     * /wallet-cards/1
     */
    public WalletCardResponse getById(
            @PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/{cardNumber}/balance")
    /**
     * PathVariable kullanımı
     *
     * URL'den gelen id değerini alır:
     * /wallet-cards/{card-number}/balance
     */
    public WalletCardResponse getByCardNumber(
            @PathVariable String cardNumber ) {
        return service.getByCardNumber(cardNumber);
    }

    @PostMapping("/{cardNumber}/balance/{balance}")
    /**
     * PathVariable kullanımı
     *
     * URL'den gelen id değerini alır:
     * /wallet-cards/{card-number}/balance/{balance}
     */
    public WalletCardResponse updateBalanceByCardNumber(
            @PathVariable String cardNumber,
            @PathVariable Double balance) {
        return service.updateByCardNumber(cardNumber, balance);
    }

    @GetMapping("/{id}/campaign")
    public CampaignResponse getCampaign(
            @PathVariable Long id) {

        return service.getCampaign(id);
    }
}
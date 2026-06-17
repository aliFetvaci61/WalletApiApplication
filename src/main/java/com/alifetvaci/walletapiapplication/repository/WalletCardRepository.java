package com.alifetvaci.walletapiapplication.repository;

import com.alifetvaci.walletapiapplication.entity.WalletCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * PostgreSQL işlemleri
 */
public interface WalletCardRepository
        extends JpaRepository<WalletCard, Long> {

    Optional<WalletCard> findByCardNumber(String cardNumber);
}
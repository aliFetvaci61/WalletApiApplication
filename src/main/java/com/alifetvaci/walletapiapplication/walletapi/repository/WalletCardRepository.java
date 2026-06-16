package com.alifetvaci.walletapiapplication.walletapi.repository;

import com.alifetvaci.walletapiapplication.walletapi.entity.WalletCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostgreSQL işlemleri
 */
public interface WalletCardRepository
        extends JpaRepository<WalletCard, Long> {
}
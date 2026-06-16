package com.alifetvaci.walletapiapplication.repository;

import com.alifetvaci.walletapiapplication.entity.WalletCard;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostgreSQL işlemleri
 */
public interface WalletCardRepository
        extends JpaRepository<WalletCard, Long> {
}
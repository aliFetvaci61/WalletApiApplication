package com.alifetvaci.walletapiapplication.repository;

import com.alifetvaci.walletapiapplication.entity.WalletCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * PostgreSQL üzerinde WalletCard verisine erişim işlemleri.
 */
public interface WalletCardRepository extends JpaRepository<WalletCard, Long> {

    /**
     * Kart numarasına göre kart bilgisini getirir.
     *
     * SQL karşılığı:
     * SELECT * FROM wallet_cards WHERE card_number = ?;
     */
    Optional<WalletCard> findByCardNumber(String cardNumber);
}
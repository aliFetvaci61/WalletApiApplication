package com.alifetvaci.walletapiapplication.walletapi.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Bu sınıf veritabanındaki wallet_cards tablosunu temsil eder.
 * JPA tarafından database entity olarak yönetilir.
 */
@Entity
// Bu sınıfın bir veritabanı tablosu olduğunu belirtir.

@Table(name = "wallet_cards")
// Bu entity'nin hangi tabloya karşılık geldiğini tanımlar.

@Getter
// Tüm alanlar için getter metodlarını otomatik oluşturur.

@Setter
// Tüm alanlar için setter metodlarını otomatik oluşturur.

@Builder
// Nesneyi daha okunabilir şekilde oluşturmayı sağlar (Builder pattern).

@NoArgsConstructor
// Parametresiz constructor üretir (JPA için zorunludur).

@AllArgsConstructor
// Tüm alanları içeren constructor üretir.
public class WalletCard {

    /**
     * Kartın benzersiz id'si
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Kart sahibi
     */
    private String ownerName;

    /**
     * Kart numarası
     */
    private String cardNumber;

    /**
     * Kart bakiyesi
     */
    private Double balance;
}
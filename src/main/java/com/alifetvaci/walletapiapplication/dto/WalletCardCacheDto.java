package com.alifetvaci.walletapiapplication.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Redis içerisinde tutulacak model
 */
@Getter
// Sınıf içindeki tüm alanlar için getter metodlarını otomatik oluşturur.

@Setter
// Sınıf içindeki tüm alanlar için setter metodlarını otomatik oluşturur.

@Builder
// Nesneyi daha okunabilir şekilde (fluent style) oluşturmayı sağlar.

@NoArgsConstructor
// Parametresiz constructor üretir, Redis ve framework işlemleri için gereklidir.

@AllArgsConstructor
// Tüm alanları içeren constructor üretir.
public class WalletCardCacheDto
        implements Serializable {

    // Redis'e yazılacak kartın benzersiz ID bilgisi
    private Long id;

    // Kart sahibinin adı
    private String ownerName;

    // Kart numarası
    private String cardNumber;

    // Kart bakiyesi
    private Double balance;
}
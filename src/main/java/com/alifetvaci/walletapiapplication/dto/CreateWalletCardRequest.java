package com.alifetvaci.walletapiapplication.dto;

import lombok.Data;

/**
 * Yeni kart oluşturma isteği
 */
@Data
public class CreateWalletCardRequest {

    private String ownerName;

    private String cardNumber;

    private Double balance;
}
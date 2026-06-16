package com.alifetvaci.walletapiapplication.walletapi.dto;

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
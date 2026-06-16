package com.alifetvaci.walletapiapplication.walletapi.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Mobile uygulamaya döneceğimiz model
 */
@Data
@Builder
public class WalletCardResponse {

    private Long id;

    private String ownerName;

    private String cardNumber;

    private Double balance;
}
package com.alifetvaci.walletapiapplication.delegate;

import lombok.Data;

/**
 * Dış servisten gelen kampanya bilgisi
 */
@Data
public class CampaignResponse {

    private Long userId;

    private Long id;

    private String title;

    private Boolean completed;
}
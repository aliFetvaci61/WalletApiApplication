package com.alifetvaci.walletapiapplication.delegate;

import lombok.Data;

/**
 * Dış servisten gelen kampanya bilgisi
 */
@Data
public class CampaignResponse {

    private Long id;

    private String title;

    private String description;

    private String category;

    private Double price;

    private Double rating;

    private Integer stock;

    private String brand;

    private String availabilityStatus;

    private String thumbnail;
}
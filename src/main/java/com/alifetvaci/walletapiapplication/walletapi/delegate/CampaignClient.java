package com.alifetvaci.walletapiapplication.walletapi.delegate;

import com.alifetvaci.walletapiapplication.walletapi.delegate.CampaignResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * FEIGN CLIENT (DIŞ SERVİS İLETİŞİMİ)
 *
 * Bu interface:
 * - Başka bir HTTP servisine request atmak için kullanılır
 * - Manual RestTemplate / WebClient yazmaya gerek bırakmaz
 *
 * Yani:
 * Java interface → otomatik HTTP client'a dönüşür
 */
@FeignClient(
        name = "campaign-client",
        url = "${external.campaign.url}"
)
public interface CampaignClient {

    @GetMapping("/todos/{id}")
    /**
     * Bu metod aslında bir HTTP GET request'tir.
     *
     * Feign bunu şu şekilde çalıştırır:
     *
     * GET https://jsonplaceholder.typicode.com/todos/{id}
     */
    CampaignResponse getCampaign(
            @PathVariable("id") Long id);
}
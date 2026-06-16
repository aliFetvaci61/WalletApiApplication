package com.alifetvaci.walletapiapplication.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * API hata cevaplarının standart formatı.
 *
 * Tüm hatalar aynı yapıda döner.
 */
@Getter
@Builder
public class ErrorResponse {

    /**
     * Hata oluşma zamanı
     */
    private LocalDateTime timestamp;

    /**
     * HTTP status kodu
     */
    private Integer status;

    /**
     * Hata tipi
     */
    private String error;

    /**
     * Kullanıcıya gösterilecek mesaj
     */
    private String message;
}
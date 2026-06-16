package com.alifetvaci.walletapiapplication.walletapi.exception;

import com.alifetvaci.walletapiapplication.walletapi.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * Uygulama genelindeki hataları merkezi olarak yönetir.
 *
 * Avantajları:
 *
 * - Tek noktadan hata yönetimi
 * - Controller içinde try-catch yazmamak
 * - Standart response dönmek
 *
 * @RestControllerAdvice
 * Tüm controller'ları kapsar.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Resource bulunamadığında çalışır.
     *
     * Örnek:
     *
     * WalletCard bulunamadı
     * User bulunamadı
     *
     * HTTP 404 döner.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ResourceNotFoundException ex) {

        ErrorResponse response =
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .error("Resource Not Found")
                        .message(ex.getMessage())
                        .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    /**
     * Beklenmeyen tüm hataları yakalar.
     *
     * Örnek:
     *
     * NullPointerException
     * IllegalArgumentException
     * Database bağlantı hatası
     *
     * HTTP 500 döner.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(
            Exception ex) {

        ErrorResponse response =
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .error("Internal Server Error")
                        .message(ex.getMessage())
                        .build();

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}
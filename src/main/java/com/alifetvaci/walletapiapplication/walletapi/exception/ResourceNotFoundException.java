package com.alifetvaci.walletapiapplication.walletapi.exception;

/**
 * İstenen kaynak (resource) sistemde bulunamadığında fırlatılır.
 *
 * Örnek:
 * - Kullanıcı bulunamadı
 * - Kart bulunamadı
 * - Kampanya bulunamadı
 *
 * RuntimeException'dan türetilmiştir.
 * Bu sayede metod imzasına throws eklemek zorunda kalmayız.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Hata mesajını üst sınıfa aktarır.
     *
     * Örnek:
     * throw new ResourceNotFoundException("Kart bulunamadı");
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
package com.alifetvaci.walletapiapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
// Feign Client interface’lerini aktif eder.
// Yani @FeignClient ile tanımladığın tüm client’ları Spring runtime’da otomatik oluşturur.

@SpringBootApplication
// Spring Boot uygulamasının giriş noktasıdır.
// @Configuration + @EnableAutoConfiguration + @ComponentScan birleşimidir.
// Yani Spring’in tüm otomatik konfigürasyonlarını ve component taramasını açar.

public class WalletApiApplication {

    public static void main(String[] args) {
        // Uygulamayı başlatan ana methoddur.
        // Spring container burada ayağa kalkar ve tüm bean’ler oluşturulur.
        SpringApplication.run(WalletApiApplication.class, args);
    }

}

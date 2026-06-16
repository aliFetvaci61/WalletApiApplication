package com.alifetvaci.walletapiapplication.walletapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * Redis bağlantısı için gerekli bean
 */
@Configuration
public class RedisConfig {

    /**
     * RedisTemplate:
     * Redis ile veri okuma/yazma işlemlerini yapmamızı sağlar.
     *
     * @Bean:
     * Bu metodun döndürdüğü nesne Spring tarafından yönetilir (Bean olur).
     *
     * Neden burada tanımlıyoruz?
     * Spring default RedisTemplate vermez, biz configure ediyoruz.
     */

    @Bean
    public RedisTemplate<String,Object> redisTemplate(
            RedisConnectionFactory connectionFactory) {

        RedisTemplate<String,Object> template =
                new RedisTemplate<>();

        /**
         * Redis bağlantısını Spring tarafından sağlanan factory ile kuruyoruz.
         */

        template.setConnectionFactory(connectionFactory);

        return template;
    }
}
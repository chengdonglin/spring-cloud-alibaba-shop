package com.dmai.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *
 * </p>
 *
 * @author linchengdong
 * @since 2022-08-17 14:26:51
 */
@Configuration
public class LoadBalanceConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

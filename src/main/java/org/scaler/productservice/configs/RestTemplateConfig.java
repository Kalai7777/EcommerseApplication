package org.scaler.productservice.configs;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean
    //It will give the onj of resttemplate and store it in a bean
    public RestTemplate getRestTemplate(){
        return new RestTemplateBuilder().build();
    }
}

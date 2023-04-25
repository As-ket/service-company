package com.marketplace.companyservice.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Конфигурация маппинга ДТО и сущностей */

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}

package com.kauacorreaarruda.springfood;

import com.kauacorreaarruda.springfood.di.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public AtivacaoClienteService atividacaoClienteService() {
        return new AtivacaoClienteService();
    }
}

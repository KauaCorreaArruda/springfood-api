package com.kauacorreaarruda.springfood;

import com.kauacorreaarruda.springfood.di.notificacao.Notificador;
import com.kauacorreaarruda.springfood.di.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
        return new AtivacaoClienteService();
    }
}

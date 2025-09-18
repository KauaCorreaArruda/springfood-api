package com.kauacorreaarruda.springfood;

import com.kauacorreaarruda.springfood.di.notificacao.NotificadorEmail;
import com.kauacorreaarruda.springfood.di.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SpringFoodConfig {

    @Bean
    public NotificadorEmail notificadorEmail() {
        NotificadorEmail notificador = new NotificadorEmail();

        return notificador;
    }
    @Bean
    public AtivacaoClienteService getAtivacaoClienteService() {
        return new AtivacaoClienteService();
    }
}

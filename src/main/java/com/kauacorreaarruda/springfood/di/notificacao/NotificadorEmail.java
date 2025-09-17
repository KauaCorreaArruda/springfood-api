package com.kauacorreaarruda.springfood.di.notificacao;

import com.kauacorreaarruda.springfood.di.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorEmail {

    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}
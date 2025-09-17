package com.kauacorreaarruda.springfood.di.service;

import com.kauacorreaarruda.springfood.di.modelo.Cliente;
import com.kauacorreaarruda.springfood.di.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private NotificadorEmail notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
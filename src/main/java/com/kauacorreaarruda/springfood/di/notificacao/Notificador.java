package com.kauacorreaarruda.springfood.di.notificacao;

import com.kauacorreaarruda.springfood.di.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
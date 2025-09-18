package com.kauacorreaarruda.springfood.listener;

import com.kauacorreaarruda.springfood.di.notificacao.NivelUrgencia;
import com.kauacorreaarruda.springfood.di.notificacao.Notificador;
import com.kauacorreaarruda.springfood.di.notificacao.TipoDoNotificador;
import com.kauacorreaarruda.springfood.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event){
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
    }
}

package com.kauacorreaarruda.springfood;

import com.kauacorreaarruda.springfood.di.modelo.Cliente;
import com.kauacorreaarruda.springfood.di.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {

    private AtivacaoClienteService atividacaoClienteService;

    public MeuPrimeiroController(AtivacaoClienteService atividacaoClienteService) {
        this.atividacaoClienteService = atividacaoClienteService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888");

        atividacaoClienteService.ativar(joao);

        return "Hello World!";
    }
}

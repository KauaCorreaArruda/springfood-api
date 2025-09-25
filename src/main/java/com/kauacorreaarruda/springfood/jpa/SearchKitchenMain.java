package com.kauacorreaarruda.springfood.jpa;

import com.kauacorreaarruda.springfood.SpringfoodApiApplication;
import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;


public class SearchKitchenMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(SpringfoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRegistration kitchenRegistration = applicationContext.getBean(KitchenRegistration.class);

        Kitchen kitchen = kitchenRegistration.searchKitchen(1L);

        System.out.println(kitchen.getName());
    }
}

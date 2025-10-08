package com.kauacorreaarruda.springfood.jpa;

import com.kauacorreaarruda.springfood.SpringfoodApiApplication;
import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import com.kauacorreaarruda.springfood.domain.repository.KitchenRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class IncludeKitchenMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(SpringfoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        KitchenRepository kitchenRepository = applicationContext.getBean(KitchenRepository.class);

        Kitchen kitchen1 = new Kitchen();
        kitchen1.setName("Brazilian");

        Kitchen kitchen2 = new Kitchen();
        kitchen2.setName("Japanese");

        kitchen1 = kitchenRepository.save(kitchen1);
        kitchen2 = kitchenRepository.save(kitchen2);

        System.out.println(kitchen1.getId() + " - " + kitchen1.getName());
        System.out.println(kitchen2.getId() + " - " + kitchen2.getName());
    }
}

package com.kauacorreaarruda.springfood.jpa;

import com.kauacorreaarruda.springfood.SpringfoodApiApplication;
import com.kauacorreaarruda.springfood.domain.model.Restaurant;
import com.kauacorreaarruda.springfood.domain.repository.RestaurantRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

public class IncludeRestaurantMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(SpringfoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestaurantRepository restaurantRepository = applicationContext.getBean(RestaurantRepository.class);

        Restaurant restaurant1 = new Restaurant();
        restaurant1.setName("KFC");
        restaurant1.setFreightRate(BigDecimal.valueOf(5.50));

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setName("TacoBell");
        restaurant2.setFreightRate(BigDecimal.valueOf(6.30));

        restaurant1 = restaurantRepository.save(restaurant1);
        restaurant2 = restaurantRepository.save(restaurant2);

        System.out.println(restaurant1.getId() + " - " + restaurant1.getName());
        System.out.println(restaurant2.getId() + " - " + restaurant2.getName());
    }
}

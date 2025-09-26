package com.kauacorreaarruda.springfood.domain.repository;

import com.kauacorreaarruda.springfood.domain.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> findAll();
    Restaurant findById(Long id);
    Restaurant add (Restaurant restaurant);
    void delete(Restaurant restaurant);
}

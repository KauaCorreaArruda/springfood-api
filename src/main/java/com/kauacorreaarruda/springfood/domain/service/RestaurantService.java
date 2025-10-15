package com.kauacorreaarruda.springfood.domain.service;

import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import com.kauacorreaarruda.springfood.domain.model.Restaurant;
import com.kauacorreaarruda.springfood.domain.repository.KitchenRepository;
import com.kauacorreaarruda.springfood.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final KitchenRepository kitchenRepository;

    public RestaurantService(RestaurantRepository restaurantRepository, KitchenRepository kitchenRepository) {
        this.restaurantRepository = restaurantRepository;
        this.kitchenRepository = kitchenRepository;
    }

    public Restaurant save(Restaurant restaurant) {
        Long kitchenId = restaurant.getKitchen().getId();
        Kitchen kitchen = kitchenRepository.findById(kitchenId);

        if (kitchen == null) {
            throw new EntityNotFoundException(
                    String.format("There is no Kitchen with id %d", kitchenId));
        }

        restaurant.setKitchen(kitchen);

        return restaurantRepository.save(restaurant);
    }
}

package com.kauacorreaarruda.springfood.api.resource;

import com.kauacorreaarruda.springfood.domain.model.Restaurant;
import com.kauacorreaarruda.springfood.domain.repository.RestaurantRepository;
import com.kauacorreaarruda.springfood.domain.service.RestaurantService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantResource {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantService restaurantService;

    public RestaurantResource(RestaurantRepository restaurantRepository, RestaurantService restaurantService) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findById(@PathVariable Long id) {
        Restaurant restaurant = restaurantRepository.findById(id);

        if (restaurant != null) {
            return ResponseEntity.ok(restaurant);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant) {
        try {
            restaurant = restaurantService.save(restaurant);

            return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Restaurant restaurant) {

        try {
            Restaurant updatedRestaurant = restaurantRepository.findById(id);

            if (updatedRestaurant != null) {
                BeanUtils.copyProperties(restaurant, updatedRestaurant, "id");

                updatedRestaurant = restaurantService.save(updatedRestaurant);
                return ResponseEntity.ok(updatedRestaurant);
            }
            return ResponseEntity.notFound().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

        Restaurant updatedRestaurant = restaurantRepository.findById(id);

        if (updatedRestaurant == null) {
            return ResponseEntity.notFound().build();
        }

        merge(fields, updatedRestaurant);

        return update(id, updatedRestaurant);
    }

    private void merge(Map<String, Object> originFields,  Restaurant destinyRestaurant) {
        originFields.forEach((name, value) -> {
            System.out.println(name + " = " + value);
        });
    }
}

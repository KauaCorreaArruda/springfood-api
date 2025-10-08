package com.kauacorreaarruda.springfood.infrastructure.repository;

import com.kauacorreaarruda.springfood.domain.model.Restaurant;
import com.kauacorreaarruda.springfood.domain.repository.RestaurantRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class RestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurant> findAll() {
        return manager.createQuery("from Restaurant ", Restaurant.class)
                .getResultList();
    }

    @Override
    public Restaurant findById(Long id) {
        return manager.find(Restaurant.class, id);
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        return manager.merge(restaurant);
    }

    @Transactional
    @Override
    public void delete(Restaurant restaurant) {
        restaurant = findById(restaurant.getId());
        manager.remove(restaurant);
    }
}

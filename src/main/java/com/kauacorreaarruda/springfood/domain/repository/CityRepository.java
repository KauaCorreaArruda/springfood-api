package com.kauacorreaarruda.springfood.domain.repository;

import com.kauacorreaarruda.springfood.domain.model.City;

import java.util.List;

public interface CityRepository {

    List<City> findAll();
    City findById(Long id);
    City save(City city);
    void delete(Long id);
}

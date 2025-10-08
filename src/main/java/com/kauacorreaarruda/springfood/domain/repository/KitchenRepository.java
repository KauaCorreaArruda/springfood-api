package com.kauacorreaarruda.springfood.domain.repository;

import com.kauacorreaarruda.springfood.domain.model.Kitchen;

import java.util.List;

public interface KitchenRepository {

    List<Kitchen> findAll();
    Kitchen findById(Long id);
    Kitchen save(Kitchen kitchen);
    void delete(Kitchen kitchen);
}

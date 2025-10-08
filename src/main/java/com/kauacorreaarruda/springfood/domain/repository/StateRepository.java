package com.kauacorreaarruda.springfood.domain.repository;

import com.kauacorreaarruda.springfood.domain.model.State;

import java.util.List;

public interface StateRepository {

    List<State> findAll();
    State findById(Long id);
    State save(State state);
    void delete(State state);
}

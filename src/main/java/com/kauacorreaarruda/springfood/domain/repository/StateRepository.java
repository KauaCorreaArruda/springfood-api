package com.kauacorreaarruda.springfood.domain.repository;

import com.kauacorreaarruda.springfood.domain.model.State;
import org.springframework.stereotype.Component;

import java.util.List;

public interface StateRepository {

    List<State> findAll();
    State findById(Long id);
    State add(State state);
    void delete(State state);
}

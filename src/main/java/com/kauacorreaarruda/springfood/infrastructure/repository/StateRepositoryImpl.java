package com.kauacorreaarruda.springfood.infrastructure.repository;

import com.kauacorreaarruda.springfood.domain.model.State;
import com.kauacorreaarruda.springfood.domain.repository.StateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class StateRepositoryImpl implements StateRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<State> findAll() {
        return manager.createQuery("from State", State.class)
                .getResultList();
    }

    @Override
    public State findById(Long id) {
        return manager.find(State.class, id);
    }

    @Transactional
    @Override
    public State add(State state) {
        return manager.merge(state);
    }

    @Transactional
    @Override
    public void delete(State state) {
        manager.remove(state);
    }
}

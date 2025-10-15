package com.kauacorreaarruda.springfood.infrastructure.repository;

import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import com.kauacorreaarruda.springfood.domain.repository.KitchenRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class KitchenRepositoryImpl implements KitchenRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Kitchen> findAll() {
        return manager.createQuery("from Kitchen", Kitchen.class)
                .getResultList();
    }

    @Override
    public Kitchen findById(Long id) {
        return manager.find(Kitchen.class, id);
    }

    @Transactional
    @Override
    public Kitchen save(Kitchen kitchen) {
        return manager.merge(kitchen);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Kitchen kitchen = findById(id);

        if (kitchen == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(kitchen);
    }
}

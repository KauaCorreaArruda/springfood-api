package com.kauacorreaarruda.springfood.jpa;

import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class KitchenRegistration {

    @PersistenceContext
    private EntityManager manager;

    public List<Kitchen> kitchenList() {
        return manager.createQuery("from Kitchen", Kitchen.class)
                .getResultList();
    }

    @Transactional
    public Kitchen add(Kitchen kitchen) {
        return manager.merge(kitchen);
    }
}

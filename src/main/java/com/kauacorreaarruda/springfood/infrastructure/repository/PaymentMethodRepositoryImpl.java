package com.kauacorreaarruda.springfood.infrastructure.repository;

import com.kauacorreaarruda.springfood.domain.model.PaymentMethod;
import com.kauacorreaarruda.springfood.domain.repository.PaymentMethodRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PaymentMethodRepositoryImpl implements PaymentMethodRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<PaymentMethod> findAll() {
        return manager.createQuery("from PaymentMethod ", PaymentMethod.class)
                .getResultList();
    }

    @Override
    public PaymentMethod findById(Long id) {
        return manager.find(PaymentMethod.class, id);
    }

    @Transactional
    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return manager.merge(paymentMethod);
    }

    @Transactional
    @Override
    public void delete(PaymentMethod paymentMethod) {
        paymentMethod = findById(paymentMethod.getId());
        manager.remove(paymentMethod);
    }

}

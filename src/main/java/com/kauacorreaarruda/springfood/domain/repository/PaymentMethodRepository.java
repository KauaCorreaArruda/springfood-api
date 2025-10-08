package com.kauacorreaarruda.springfood.domain.repository;

import com.kauacorreaarruda.springfood.domain.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodRepository {

    List<PaymentMethod> findAll();
    PaymentMethod findById(Long id);
    PaymentMethod save(PaymentMethod paymentMethod);
    void delete(PaymentMethod paymentMethod);
}

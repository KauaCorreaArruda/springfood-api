package com.kauacorreaarruda.springfood.domain.repository;

import com.kauacorreaarruda.springfood.domain.model.PaymentMethod;
import com.kauacorreaarruda.springfood.domain.model.Permission;

import java.util.List;

public interface PermissionRepository {

    List<Permission> findAll();
    Permission findById(Long id);
    Permission add (Permission permission);
    void delete (Permission permission);
}

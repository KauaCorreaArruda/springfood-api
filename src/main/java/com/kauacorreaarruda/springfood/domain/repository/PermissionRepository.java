package com.kauacorreaarruda.springfood.domain.repository;

import com.kauacorreaarruda.springfood.domain.model.Permission;

import java.util.List;

public interface PermissionRepository {

    List<Permission> findAll();
    Permission findById(Long id);
    Permission save(Permission permission);
    void delete (Permission permission);
}

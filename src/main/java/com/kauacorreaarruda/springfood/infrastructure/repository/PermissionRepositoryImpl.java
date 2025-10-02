package com.kauacorreaarruda.springfood.infrastructure.repository;

import com.kauacorreaarruda.springfood.domain.model.Permission;
import com.kauacorreaarruda.springfood.domain.repository.PermissionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PermissionRepositoryImpl implements PermissionRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Permission> findAll() {
        return manager.createQuery("from Permission", Permission.class)
                .getResultList();
    }

    @Override
    public Permission findById(Long id) {
        return manager.find(Permission.class, id);
    }

    @Transactional
    @Override
    public Permission add(Permission permission) {
        return manager.merge(permission);
    }

    @Transactional
    @Override
    public void delete(Permission permission) {
        permission = findById(permission.getId());
        manager.remove(permission);
    }
}

package com.kauacorreaarruda.springfood.domain.service;

import com.kauacorreaarruda.springfood.domain.exception.EntityNotAvailableException;
import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import com.kauacorreaarruda.springfood.domain.repository.KitchenRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class KitchenService {

    KitchenRepository kitchenRepository;

    public KitchenService(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }

    public Kitchen save(Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    public void delete(Long id) {
        try {
            kitchenRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format("There is no kitchen with id %d", id)
            );
        } catch (DataIntegrityViolationException e) {
            throw new EntityNotAvailableException(
                    String.format("Kitchen with id %d cannot be deleted, because it is still in use", id)
            );
        }
    }
}

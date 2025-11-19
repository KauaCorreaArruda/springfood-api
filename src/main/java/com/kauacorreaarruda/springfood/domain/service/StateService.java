package com.kauacorreaarruda.springfood.domain.service;

import com.kauacorreaarruda.springfood.domain.exception.EntityNotAvailableException;
import com.kauacorreaarruda.springfood.domain.model.State;
import com.kauacorreaarruda.springfood.domain.repository.StateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public State save(State state) {
        return stateRepository.save(state);
    }

    public void delete(Long id) {
        try {
            stateRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format("There is no state with id %d", id)
            );
        } catch (DataIntegrityViolationException e) {
            throw new EntityNotAvailableException(
                    String.format("State with id %d cannot be deleted, because it is still in use", id)
            );
        }
    }
}

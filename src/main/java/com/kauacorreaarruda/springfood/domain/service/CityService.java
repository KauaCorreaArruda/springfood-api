package com.kauacorreaarruda.springfood.domain.service;

import com.kauacorreaarruda.springfood.domain.exception.EntityNotAvailableException;
import com.kauacorreaarruda.springfood.domain.model.City;
import com.kauacorreaarruda.springfood.domain.model.State;
import com.kauacorreaarruda.springfood.domain.repository.CityRepository;
import com.kauacorreaarruda.springfood.domain.repository.StateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    CityRepository cityRepository;
    StateRepository stateRepository;

    public CityService(CityRepository cityRepository,  StateRepository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

    public City save(City city) {
        Long stateId = city.getState().getId();
        State state = stateRepository.findById(stateId);

        if (state == null) {
            throw new EntityNotFoundException(
                    String.format("There is no State with id %d", stateId));
        }

        city.setState(state);

        return cityRepository.save(city);
    }

    public void delete(Long id) {
        try {
            cityRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(
                    String.format("There is no city with id %d", id)
            );
        } catch (DataIntegrityViolationException e) {
            throw new EntityNotAvailableException(
                    String.format("City with id %d cannot be deleted, because it is still in use", id)
            );
        }
    }
}

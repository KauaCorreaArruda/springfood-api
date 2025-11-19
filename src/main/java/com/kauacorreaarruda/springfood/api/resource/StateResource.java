package com.kauacorreaarruda.springfood.api.resource;

import com.kauacorreaarruda.springfood.domain.exception.EntityNotAvailableException;
import com.kauacorreaarruda.springfood.domain.model.State;
import com.kauacorreaarruda.springfood.domain.repository.StateRepository;
import com.kauacorreaarruda.springfood.domain.service.KitchenService;
import com.kauacorreaarruda.springfood.domain.service.StateService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/states")
public class StateResource {

    private final StateRepository stateRepository;
    private final StateService stateService;

    public StateResource(StateRepository stateRepository, StateService stateService) {
        this.stateRepository = stateRepository;
        this.stateService = stateService;
    }

    @GetMapping
    List<State>  findAll() {
        return stateRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id) {
        State State = stateRepository.findById(id);

        if (State != null) {
            return ResponseEntity.ok(State);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public State create(@RequestBody State state) {
        return stateService.save(state);
    }

    @PutMapping("/{id}")
    public ResponseEntity<State> update(@PathVariable Long id, @RequestBody State state) {
        State updatedState = stateRepository.findById(id);

                if (updatedState != null) {
                    BeanUtils.copyProperties(state, updatedState, "id");

                    updatedState = stateService.save(updatedState);
                    return ResponseEntity.ok(updatedState);
                }
                return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            stateService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (EntityNotAvailableException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}

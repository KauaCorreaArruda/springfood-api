package com.kauacorreaarruda.springfood.api.resource;

import com.kauacorreaarruda.springfood.domain.exception.EntityNotAvailableException;
import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import com.kauacorreaarruda.springfood.domain.repository.KitchenRepository;
import com.kauacorreaarruda.springfood.domain.service.KitchenService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kitchens")
public class KitchenResource {

    private final KitchenRepository kitchenRepository;
    private final KitchenService kitchenService;

    public KitchenResource(KitchenRepository kitchenRepository, KitchenService kitchenService) {
        this.kitchenRepository = kitchenRepository;
        this.kitchenService = kitchenService;
    }

    @GetMapping
    public List<Kitchen> findAll() {
        return kitchenRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitchen> findById(@PathVariable Long id) {
        Kitchen kitchen = kitchenRepository.findById(id);

        if (kitchen != null) {
            return ResponseEntity.ok(kitchen);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen create(@RequestBody Kitchen kitchen) {
        return kitchenService.save(kitchen);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitchen> update(@PathVariable Long id, @RequestBody Kitchen kitchen) {
        Kitchen updatedKitchen = kitchenRepository.findById(id);

        if (updatedKitchen != null) {
//        updatedKitchen.setName(kitchen.getName());
            BeanUtils.copyProperties(kitchen, updatedKitchen, "id");

            kitchenRepository.save(updatedKitchen);
            return ResponseEntity.ok(updatedKitchen);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Kitchen> delete(@PathVariable Long id) {
        try {
            kitchenService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();

        } catch (EntityNotAvailableException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}

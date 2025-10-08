package com.kauacorreaarruda.springfood.api.resource;

import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import com.kauacorreaarruda.springfood.domain.repository.KitchenRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/kitchens")
public class KitchenResource {

    private final KitchenRepository kitchenRepository;

    public KitchenResource(KitchenRepository kitchenRepository) {
        this.kitchenRepository = kitchenRepository;
    }


    @GetMapping
    public List<Kitchen> findAll() {
        return  kitchenRepository.findAll();
    }

    @GetMapping("/{id}")
    public Kitchen findById(@PathVariable Long id) {
        return kitchenRepository.findById(id);
    }
}

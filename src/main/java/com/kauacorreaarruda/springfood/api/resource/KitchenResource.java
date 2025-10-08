package com.kauacorreaarruda.springfood.api.resource;

import com.kauacorreaarruda.springfood.domain.model.Kitchen;
import com.kauacorreaarruda.springfood.domain.repository.KitchenRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Kitchen> findAll1() {
        System.out.println("findAll1");
        return  kitchenRepository.findAll();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Kitchen> findAll2() {
        System.out.println("findAll2");
        return  kitchenRepository.findAll();
    }
}

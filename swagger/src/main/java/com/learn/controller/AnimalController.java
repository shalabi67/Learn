package com.learn.controller;

import com.learn.model.Animal;
import com.learn.model.Pet;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshalabi on 20.06.17.
 */
@RestController
@RequestMapping("/animals/")
@Api(value="Animal Controller Class", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {

    @GetMapping("")
    public List<Animal> getAnimals() {
        Animal pet = new Animal();
        pet.setId(1);
        pet.setName("my cat");

        List<Animal> list = new ArrayList<>();
        list.add(pet);

        return list;
    }


}

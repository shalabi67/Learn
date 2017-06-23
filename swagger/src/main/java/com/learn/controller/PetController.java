package com.learn.controller;

/**
 * Created by mshalabi on 20.06.17.
 */

import com.learn.model.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/pets/")
@Api(value="Pet Controller API", produces = MediaType.APPLICATION_JSON_VALUE)
public class PetController {

    @GetMapping("")
    @ApiOperation("Get all Pets")
    @ApiResponses(value={@ApiResponse(code=200, message="OK", response = Pet.class, responseContainer = "List")})
    public List<Pet> getPets() {
        Pet pet = new Pet();
        pet.setId(1);
        pet.setName("my cat");

        List<Pet> list = new ArrayList<>();
        list.add(pet);

        return list;

    }
}

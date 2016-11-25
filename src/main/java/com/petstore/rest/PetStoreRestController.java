package com.petstore.rest;

import com.petstore.bo.Pet;
import com.petstore.dao.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iakoupov on 2016-11-23.
 */
@RestController
@RequestMapping("/pet-store/")
@CrossOrigin(origins = "http://localhost:63342")
public class PetStoreRestController {

    @Autowired
    private PetRepository repository;


    /**
     * Retruns all availabel pets
     * @return
     */
    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public List<Pet> getAllPets() {

        return repository.findAll();

    }

    @RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
    public Pet getPet(@PathVariable String id) {

        return repository.findOne(id);
    }

    @RequestMapping(value = "/pet", method = RequestMethod.POST)
    public void addNewPet(@RequestBody Pet pet) {
        // save new pet to the DB

        System.out.println("Adding new pet " + pet);
        repository.insert(pet);
    }

    @RequestMapping(value = "/pet", method = RequestMethod.PUT)
    public void updatePet(@RequestBody Pet pet) {

        repository.insert(pet);

    }

    @RequestMapping(value = "/pet/{id}", method = RequestMethod.DELETE)
    public void removePet(@PathVariable String id) {
        // find this pet and delete it
        repository.delete(id);

    }




}

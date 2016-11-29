package com.petstore.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.bo.Pet;
import com.petstore.dao.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.*;

/**
 * Created by iakoupov on 2016-11-23.
 */
@RestController
@RequestMapping("/pet-store/")
//@CrossOrigin(origins = "http://localhost:63342")
public class PetStoreRestController {

    private ThreadLocal<String> token = new ThreadLocal<String>();

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

    @RequestMapping(value = "/pets/{item}", method = RequestMethod.GET)
    public Set<Pet> getFilteredPets(@PathVariable String item) {

        System.out.println("searching names and description for " + item);

        // search for item
        Set<Pet> pets = new HashSet<>();
        pets.addAll(repository.findByDescriptionLike(item));
        pets.addAll(repository.findByNameLike(item));

        System.out.println("found: " + pets);

        return pets;

    }

    @RequestMapping(value = "/pet/{id}", method = RequestMethod.GET)
    public Pet getPet(@PathVariable String id) {

        Pet pet = repository.findOne(id);

        System.out.println("found pet for id " + id + " " + pet);

        return pet;
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @RequestMapping(value = "/pet", method = RequestMethod.POST)
    public void addNewPet(@RequestPart("pet") String petString, @RequestPart("file") List<MultipartFile> files) throws IOException {
        // save new pet to the DB

        System.out.println("Adding new pet " + petString);
        System.out.println("And files " + files);

        Pet pet = new ObjectMapper().readValue(petString, Pet.class);

        //System.out.println(Base64.getEncoder().encodeToString(file.getBytes()));

        // convert files to strings

        files.forEach(file -> {
            try {
                String img = Base64.getEncoder().encodeToString(file.getBytes());
                pet.getImages().add(img);
                System.out.println("image:" + img);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        repository.insert(pet);
    }

    @RequestMapping(value = "/pet", method = RequestMethod.PUT)
    public void updatePet(@RequestBody Pet pet) {

        System.out.println("Updating a pet " + pet);
        repository.save(pet);

    }

    @RequestMapping(value = "/pet/{id}", method = RequestMethod.DELETE)
    public void removePet(@PathVariable String id) {
        // find this pet and delete it

        System.out.println("deleting pet with id of " + id);
        repository.delete(id);

    }






}

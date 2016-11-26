package com.petstore.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.bo.Pet;
import com.petstore.dao.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
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

//    @RequestMapping(value = "/pet1", method = RequestMethod.POST)
//    public void addPet(@ModelAttribute("form") PetForm petForm) {
//
//        System.out.println("Adding new pet " + pet);
//        System.out.println("And files " + files);
//        repository.insert(pet);
//    }

    //
    /*@RequestMapping(method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public void create(@RequestPart("pet") String petString,
                       @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {

    }*/

    //

    @RequestMapping(value = "/pet", method = RequestMethod.PUT)
    public void updatePet(@RequestBody Pet pet) {

        System.out.println("Creating a new pet " + pet);
        repository.insert(pet);

    }

    @RequestMapping(value = "/pet/{id}", method = RequestMethod.DELETE)
    public void removePet(@PathVariable String id) {
        // find this pet and delete it

        System.out.println("deleting pet with id of " + id);
        repository.delete(id);

    }




}

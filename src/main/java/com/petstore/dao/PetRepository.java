package com.petstore.dao;

import com.petstore.bo.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


/**
 * Created by iakoupov on 2016-11-24.
 */
public interface PetRepository extends MongoRepository<Pet, String> {

    public Pet findByName(String name);

    public List<Pet> findByDescriptionLike(String description);

    public List<Pet> findByNameLike(String name);


}

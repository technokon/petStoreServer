package com.petstore.dao;

import com.petstore.bo.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * Created by iakoupov on 2016-11-24.
 */
public interface PetRepository extends MongoRepository<Pet, String> {

    public Pet findByName(String name);

}

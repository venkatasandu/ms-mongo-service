package com.ms.mongo.msmongoservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.mongo.msmongoservice.models.Pet;

public interface PetsRepository extends MongoRepository<Pet, String>{

}

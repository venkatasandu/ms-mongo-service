package com.ms.mongo.msmongoservice.controllers;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.mongo.msmongoservice.models.Pet;
import com.ms.mongo.msmongoservice.repositories.PetsRepository;

@RestController
@RequestMapping(value="/pets")
public class MsMongoRestController {
	
	@Autowired
	PetsRepository repository;
	
	@GetMapping(value="/")
	public List<Pet> getAllPets() {
		return repository.findAll();
	}

	@GetMapping(value="/{id}")
	public Optional<Pet> findPet(@PathVariable ObjectId id) {
		return repository.findById(id.toHexString());
	}
	
	@RequestMapping (value="/", method=RequestMethod.POST)
	public Optional<Pet> createPet(@RequestBody Pet pet) {
		pet.set_id(ObjectId.get());
		repository.save(pet);
		return Optional.of(pet);
	}
	
	@RequestMapping (value="/", method=RequestMethod.PUT)
	public Optional<Pet> modifyPet(@RequestBody Pet pet) {
		//pet.set_id(ObjectId.get());
		repository.save(pet);
		return Optional.of(pet);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deletePet(@PathVariable ObjectId id) {
		repository.deleteById(id.toHexString());
	}	
	
}

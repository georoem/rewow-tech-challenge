package com.ubits.backend.repository;

import java.util.List;

import com.ubits.backend.model.Owner;
import com.ubits.backend.model.Pet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long>{

	List<Pet> findByOwner(Owner owner);
    
}
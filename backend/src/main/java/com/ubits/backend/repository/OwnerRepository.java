package com.ubits.backend.repository;

import com.ubits.backend.model.Owner;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{

	Owner findByEmail(String email);
    
}
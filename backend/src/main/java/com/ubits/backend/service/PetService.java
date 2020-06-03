package com.ubits.backend.service;

import java.util.List;

import com.ubits.backend.dto.PetDto;

public interface PetService {

	PetDto createPet(PetDto petDto);

	List<PetDto> getPetsByOwnerId(Long ownerId);

	PetDto getPetsById(Long idPet);
    
}
package com.ubits.backend.mapper;

import java.util.List;

import com.ubits.backend.dto.PetDto;
import com.ubits.backend.model.Pet;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

	Pet dtoToModel(PetDto petDto);

	PetDto modelToDto(Pet pet);

	List<PetDto> modelsToDtos(List<Pet> pets);
    
}
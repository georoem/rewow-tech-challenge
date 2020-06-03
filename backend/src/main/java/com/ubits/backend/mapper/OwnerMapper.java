package com.ubits.backend.mapper;

import com.ubits.backend.dto.OwnerDto;
import com.ubits.backend.model.Owner;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

	Owner dtoToModel(OwnerDto ownerDto);

	OwnerDto modelToDto(Owner owner);
    
}
package com.ubits.backend.service;

import com.ubits.backend.dto.OwnerDto;

public interface OwnerService {

	OwnerDto createOwner(OwnerDto ownerDto);

	OwnerDto getOwnerByEmail(String email);

	OwnerDto getOwnerByBy(Long id);
    
}
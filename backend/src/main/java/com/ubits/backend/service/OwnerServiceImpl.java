package com.ubits.backend.service;

import com.ubits.backend.dto.OwnerDto;
import com.ubits.backend.mapper.OwnerMapper;
import com.ubits.backend.repository.OwnerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerRepository ownerRepository;
    private OwnerMapper mapper;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper mapper) {
        this.ownerRepository = ownerRepository;
        this.mapper = mapper;
    }

    @Override
    public OwnerDto createOwner(OwnerDto ownerDto) {
        return mapper.modelToDto(ownerRepository.save(mapper.dtoToModel(ownerDto)));
    }

    @Override
    public OwnerDto getOwnerByEmail(String email) {
        return mapper.modelToDto(ownerRepository.findByEmail(email));
    }

    @Override
    public OwnerDto getOwnerByBy(Long id) {
        return mapper.modelToDto(ownerRepository.findById(id).get());
    }

}
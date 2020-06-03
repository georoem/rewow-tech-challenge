package com.ubits.backend.service;

import java.util.List;

import com.ubits.backend.dto.PetDto;
import com.ubits.backend.mapper.PetMapper;
import com.ubits.backend.model.Owner;
import com.ubits.backend.repository.PetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    private PetMapper mapper;

    @Autowired
    public PetServiceImpl(PetRepository petRepository, PetMapper mapper) {
        this.petRepository = petRepository;
        this.mapper = mapper;
    }

    @Override
    public PetDto createPet(PetDto petDto) {
        validatePet(petDto);
        return mapper.modelToDto(petRepository.save(mapper.dtoToModel(petDto)));
    }

    @Override
    public List<PetDto> getPetsByOwnerId(Long ownerId) {
       return mapper.modelsToDtos(petRepository.findByOwner(new Owner(ownerId)));
    }
    
    @Override
    public PetDto getPetsById(Long idPet) {
        return mapper.modelToDto(petRepository.findById(idPet).get());
    }

    private void validatePet(PetDto petDto) {
    }

}
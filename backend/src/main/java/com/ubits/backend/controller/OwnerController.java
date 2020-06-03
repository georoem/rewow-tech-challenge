package com.ubits.backend.controller;

import java.util.List;

import com.ubits.backend.dto.OwnerDto;
import com.ubits.backend.dto.PetDto;
import com.ubits.backend.service.OwnerService;
import com.ubits.backend.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    
    private OwnerService ownerService;
    private PetService petService;

    @Autowired
    public OwnerController(OwnerService ownerService,
        PetService petService) {
        this.ownerService = ownerService;
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<OwnerDto> createOwner(@RequestBody OwnerDto ownerDto) {
        return new ResponseEntity<OwnerDto>(ownerService.createOwner(ownerDto), HttpStatus.OK);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<OwnerDto> getOwnerByEmail(@PathVariable String email) {
        return new ResponseEntity<>(ownerService.getOwnerByEmail(email), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.getOwnerByBy(id), HttpStatus.OK);
    }

    @GetMapping("/{idOwner}/pet")
    public ResponseEntity<List<PetDto>> getPetsByOwner(@PathVariable Long idOwner) {
        return new ResponseEntity<List<PetDto>>(petService.getPetsByOwnerId(idOwner), HttpStatus.OK);
    }
        
}
package com.ubits.backend.controller;

import java.util.List;

import com.ubits.backend.dto.AppointmentDto;
import com.ubits.backend.dto.PetDto;
import com.ubits.backend.service.AppointmentService;
import com.ubits.backend.service.PetService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class PetController {
    
    private PetService petService;
    private AppointmentService appointmentService;

    public PetController(PetService petService,
        AppointmentService appointmentService) {
        this.petService = petService;
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto) {
        return new ResponseEntity<PetDto>(petService.createPet(petDto), HttpStatus.CREATED);
    }

    @GetMapping("{idPet}")
    public ResponseEntity<PetDto> getPetById(@PathVariable Long idPet) {
        return new ResponseEntity<PetDto>(petService.getPetsById(idPet), HttpStatus.OK);
    }

    @GetMapping("{petId}/appointment")
    public ResponseEntity<List<AppointmentDto>> getAppointmentsByPetId(@PathVariable Long petId) {
        return new ResponseEntity<List<AppointmentDto>>(appointmentService.getAppointmentsByPetId(petId), HttpStatus.OK);
    }
}
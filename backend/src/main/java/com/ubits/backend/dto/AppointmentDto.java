package com.ubits.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AppointmentDto {

    private Long id;
    private PetDto pet;
    private List<ServiceDto> services;
    private LocalDateTime date;

    public AppointmentDto(Long id, PetDto pet, List<ServiceDto> services, LocalDateTime date) {
        this.id = id;
        this.pet = pet;
        this.services = services;
        this.date = date;
    }

    public AppointmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PetDto getPet() {
        return pet;
    }

    public void setPet(PetDto pet) {
        this.pet = pet;
    }

    public List<ServiceDto> getServices() {
        return services;
    }

    public void setServices(List<ServiceDto> services) {
        this.services = services;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
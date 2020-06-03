package com.ubits.backend.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "appointment")
public class Appointment {
    
    @Id
    @GeneratedValue(generator = "appointment_generator")
    @SequenceGenerator(
            name = "appointment_generator",
            sequenceName = "appointment_sequence",
            initialValue = 1
    )
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_pet", nullable = false)
    private Pet pet;
    @ManyToMany
    @JoinTable(
        name = "appointment_service", 
        joinColumns = @JoinColumn(name = "id_appointment"), 
        inverseJoinColumns = @JoinColumn(name = "id_service"))
    private List<Service> services;
    private LocalDateTime date;

    public Appointment(Long id, Pet pet, List<Service> services, LocalDateTime date) {
        this.id = id;
        this.pet = pet;
        this.services = services;
        this.date = date;
    }

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

}
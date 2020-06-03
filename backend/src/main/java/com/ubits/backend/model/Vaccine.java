package com.ubits.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccine")
public class Vaccine {

    private Long id;
    private String name;
    private String description;

    public Vaccine(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Vaccine() {
    }

    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
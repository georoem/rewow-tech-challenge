package com.ubits.backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_type")
public class ServiceType {
    
    private Long id;
    private String name;

    public ServiceType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ServiceType() {
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

}
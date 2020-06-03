package com.ubits.backend.dto;

public class ServiceTypeDto {
    
    private Long id;
    private String name;

    public ServiceTypeDto(Long id) {
        this.id = id;
    }

    public ServiceTypeDto() {
    }

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
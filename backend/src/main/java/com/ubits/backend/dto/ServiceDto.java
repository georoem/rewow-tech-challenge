package com.ubits.backend.dto;

public class ServiceDto {

    private Long id;
    private String name;
    private String description;
    private ServiceTypeDto type;

    public ServiceDto(Long id) {
        this.id = id;
    }

    public ServiceDto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ServiceTypeDto getType() {
        return type;
    }

    public void setType(ServiceTypeDto type) {
        this.type = type;
    }

}
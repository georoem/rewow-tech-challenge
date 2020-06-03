package com.ubits.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(generator = "pet_generator")
    @SequenceGenerator(
            name = "pet_generator",
            sequenceName = "pet_sequence",
            initialValue = 1
    )
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_owner", nullable = false)
    private Owner owner;
    private String type;
    private String size;
    private String breed;
    private Integer age;
    private String description;
    @OneToMany(mappedBy = "pet")
    private List<PetVaccine> vaccines;

    public Pet(Long id, String name, Owner owner, String type, String size, String breed, Integer age, String description) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.size = size;
        this.breed = breed;
        this.age = age;
        this.description = description;
    }

    public Pet() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PetVaccine> getVaccines() {
        return vaccines;
    }

    public void setVaccines(List<PetVaccine> vaccines) {
        this.vaccines = vaccines;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
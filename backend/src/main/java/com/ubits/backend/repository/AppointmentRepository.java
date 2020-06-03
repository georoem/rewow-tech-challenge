package com.ubits.backend.repository;

import java.util.List;

import com.ubits.backend.model.Appointment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long>{

	List<Appointment> findByPetId(Long petId);
    
}
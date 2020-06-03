package com.ubits.backend.service;

import java.util.List;

import com.ubits.backend.dto.AppointmentDto;

public interface AppointmentService {

	AppointmentDto createAppointment(AppointmentDto appointmentDto);

	AppointmentDto updateAppointment(AppointmentDto appointmentDto);

	void deleteAppointment(Long appointmentId);

	List<AppointmentDto> getAppointmentsByPetId(Long petId);

	AppointmentDto getAppointmentById(Long appointmentId);
    
}
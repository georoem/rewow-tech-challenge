package com.ubits.backend.mapper;

import java.util.List;

import com.ubits.backend.dto.AppointmentDto;
import com.ubits.backend.model.Appointment;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

	Appointment dtoToModel(AppointmentDto appointmentDto);

	AppointmentDto modelToDto(Appointment appointment);

	List<AppointmentDto> modelsToDtos(List<Appointment> appointments);
    
}
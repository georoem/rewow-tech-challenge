package com.ubits.backend.service;

import java.util.List;
import java.util.Optional;

import com.ubits.backend.dto.AppointmentDto;
import com.ubits.backend.mapper.AppointmentMapper;
import com.ubits.backend.model.Appointment;
import com.ubits.backend.repository.AppointmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentRepository appointmentRepository;

    private AppointmentMapper mapper;

    @Autowired
    public AppointmentServiceImpl(AppointmentRepository appointmentRepository, AppointmentMapper mapper) {
        this.appointmentRepository = appointmentRepository;
        this.mapper = mapper;
    }

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        validateAppointment(appointmentDto);
        return mapper.modelToDto(appointmentRepository.save(mapper.dtoToModel(appointmentDto)));
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto) {
        validateAppointment(appointmentDto);
        return mapper.modelToDto(appointmentRepository.save(mapper.dtoToModel(appointmentDto)));
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public List<AppointmentDto> getAppointmentsByPetId(Long petId) {
        return mapper.modelsToDtos(appointmentRepository.findByPetId(petId));
    }

    @Override
    public AppointmentDto getAppointmentById(Long appointmentId) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        return mapper.modelToDto(appointment.get());
    }

    private void validateAppointment(AppointmentDto appointmentDto) {
    }

}
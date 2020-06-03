package com.ubits.backend.controller;

import com.ubits.backend.dto.AppointmentDto;
import com.ubits.backend.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointment")
public class AppointmentController {
    
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(final AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<AppointmentDto>(appointmentService.createAppointment(appointmentDto),
                HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AppointmentDto> updateAppointment(@RequestBody AppointmentDto appointmentDto) {
        return new ResponseEntity<AppointmentDto>(appointmentService.updateAppointment(appointmentDto), HttpStatus.OK);
    }

    @DeleteMapping("{appointmentId}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable Long appointmentId) {
        return new ResponseEntity<Boolean>(HttpStatus.OK);
    }

    @GetMapping("{appointmentId}")
    public ResponseEntity<AppointmentDto> getAppointmentById(@PathVariable Long appointmentId) {
        return new ResponseEntity<AppointmentDto>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
    }
    
}
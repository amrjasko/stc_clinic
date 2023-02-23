package com.stc.clinic.repository;

import com.stc.clinic.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

    List<Appointment> getAllByAppointmentDate(LocalDate date);

    List<Appointment> getByPatientNameContainingIgnoreCase(String patientName);

    Optional<Appointment> findByPatientNationalId(String patientNationalId);

}

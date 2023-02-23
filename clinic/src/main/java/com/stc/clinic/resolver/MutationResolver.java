package com.stc.clinic.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.stc.clinic.entity.Appointment;
import com.stc.clinic.exceptions.APIException;
import com.stc.clinic.repository.AppointmentRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Validated
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> allAppointment() {
        return appointmentRepository.getAllByAppointmentDate(LocalDate.now());
    }

    public List<Appointment> getAppointmentByPatientName(String patientName) {
        return appointmentRepository.getByPatientNameContainingIgnoreCase(patientName);
    }

    public List<Appointment> getAppointmentByAppointmentDate(String appointmentDate) {
        if(appointmentDate == null || appointmentDate.isBlank())
        {
            throw new APIException("Appointment  not found with this date "+appointmentDate);
        }
        if(appointmentRepository.getAllByAppointmentDate(LocalDate.parse(appointmentDate)).size() <=0)
        {
            throw new APIException("Appointment  not found with this date "+appointmentDate);
        }
        return appointmentRepository.getAllByAppointmentDate(LocalDate.parse(appointmentDate));
    }

    public Appointment cancelAppointment(int id,String cancellationReason) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent())
        {
            appointment.get().setAppointmentStatus(0);
            appointment.get().setCancelReason(cancellationReason);
        }else {
            throw new APIException("Appointment  not found with id "+id);
        }
        return appointmentRepository.saveAndFlush(appointment.get());
    }

    public Appointment addAppointment(@Valid Appointment appointment)
    {
        appointment.setAppointmentDate(LocalDate.now());
        return appointmentRepository.save(appointment);
    }
}

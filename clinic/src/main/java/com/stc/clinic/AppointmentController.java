package com.stc.clinic;

import com.stc.clinic.entity.Appointment;
import com.stc.clinic.repository.AppointmentRepository;
import com.stc.clinic.resolver.MutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.GraphQlResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class AppointmentController {


    private final MutationResolver repository;

    public AppointmentController(MutationResolver repository) {
        this.repository = repository;
    }

    @Autowired
    private AppointmentRepository aa;

    @QueryMapping
    public List<Appointment> appointments()
    {
        return repository.allAppointment();
    }

    @QueryMapping
    public List<Appointment> appointmentsByPatientName(@Argument String patientName)
    {
        return repository.getAppointmentByPatientName(patientName);
    }

    @QueryMapping
    public List<Appointment> appointmentsByDate(@Argument String appointmentDate)
    {
        return repository.getAppointmentByAppointmentDate(appointmentDate);
    }


     @MutationMapping
     public Appointment addNewAppointment(@Argument Appointment appointment) {
         return repository.addAppointment(appointment);
     }

    @MutationMapping
    public Appointment cancelAppointment(@Argument int id, @Argument String reason) {
        return repository.cancelAppointment(id,reason);
    }
}

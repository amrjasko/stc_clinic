package com.stc.clinic.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Appointment {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "status")
    private int appointmentStatus = 1;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @Column
    @NotBlank
    private String patientName;

    @Column(length = 14)
    private String patientNationalId;

}

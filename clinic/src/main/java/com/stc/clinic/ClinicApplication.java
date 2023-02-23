package com.stc.clinic;

import com.stc.clinic.entity.Appointment;
import com.stc.clinic.repository.AppointmentRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicApplication.class, args);
        System.out.println("hi jasko");
    }

    @Bean
    ApplicationRunner applicationRunner(AppointmentRepository appointmentRepository) {
        return args -> {
            appointmentRepository.saveAll(List.of(
                    new Appointment(1, LocalDate.now(), 1, null,
                            "Amr Akram",
                            "12345678912345"),
                    new Appointment(2, LocalDate.now(), 1, null,
                            "Ahmed Hisham",
                            "23456789123456"),
                    new Appointment(3, LocalDate.now(), 1, null,
                            "Ibrahim Mohamed",
                            "34567891234567"),
                    new Appointment(4, LocalDate.now(), 1, null,
                            "Tasneem Mohamed",
                            "45678912345678")));
        };
    }
}

package com.sofkau.hospitalBackEnd.HospitalBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_medical_specialty")
    //@JsonBackReference
    private Specialty fkSpecialty;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "identification_number")
    private Long dni;

    @Column(name = "date")
    private String date;

    @Column(name = "number_of_appointments")
    private Integer numberOfAppointments;
}

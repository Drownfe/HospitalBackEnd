package com.sofkau.hospitalBackEnd.HospitalBackEnd.dto;

import lombok.Data;

import java.util.List;

@Data
public class PatientDTO {
    private Integer id;
    private String name;
    private Integer age;
    private Long dni;
    private List<String> date;
    private Integer numberOfAppointments;
}

package com.sofkau.hospitalBackEnd.HospitalBackEnd.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class SpecialtyDTO {
    private Integer id;
    private String name;
    private String physicianInCharge;
    private List<PatientDTO> patients = new ArrayList<>();
}

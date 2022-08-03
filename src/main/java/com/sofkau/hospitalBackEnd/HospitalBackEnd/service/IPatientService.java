package com.sofkau.hospitalBackEnd.HospitalBackEnd.service;

import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.PatientDTO;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.SpecialtyDTO;

public interface IPatientService {
    PatientDTO savePatientRegister(SpecialtyDTO dtoSpecialty);
}

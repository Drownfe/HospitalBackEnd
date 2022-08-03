package com.sofkau.hospitalBackEnd.HospitalBackEnd.controller;

import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.PatientDTO;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.SpecialtyDTO;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hospital/")
@CrossOrigin("*")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @PostMapping("registerPatient")
    public PatientDTO registerPatient(@RequestBody SpecialtyDTO dtoMedical){
        return patientService.savePatientRegister(dtoMedical);
    }
}

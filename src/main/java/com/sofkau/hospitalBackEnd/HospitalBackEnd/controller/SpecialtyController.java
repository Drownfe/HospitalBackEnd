package com.sofkau.hospitalBackEnd.HospitalBackEnd.controller;

import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.SpecialtyDTO;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hospital/")
@CrossOrigin("*")
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("allMedicalSpecialty")
    public List<SpecialtyDTO> findAllSpecialty(){
        return SpecialtyService.findAllSpecialty();
    }

    @PostMapping("registerspecialty")
    public SpecialtyDTO registerSpecialty(@RequestBody SpecialtyDTO specialty){
        return SpecialtyService.saveSpecialtyRegister(specialty);
    }
}

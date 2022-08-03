package com.sofkau.hospitalBackEnd.HospitalBackEnd.service;

import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.SpecialtyDTO;

import java.util.List;

public interface ISpecialtyService {
    List<SpecialtyDTO> findAllSpecialty();
}

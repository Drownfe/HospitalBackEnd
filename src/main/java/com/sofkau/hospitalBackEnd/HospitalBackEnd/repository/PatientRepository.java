package com.sofkau.hospitalBackEnd.HospitalBackEnd.repository;

import com.sofkau.hospitalBackEnd.HospitalBackEnd.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}

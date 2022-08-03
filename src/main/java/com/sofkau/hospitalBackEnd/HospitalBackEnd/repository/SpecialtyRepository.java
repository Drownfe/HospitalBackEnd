package com.sofkau.hospitalBackEnd.HospitalBackEnd.repository;

import com.sofkau.hospitalBackEnd.HospitalBackEnd.entity.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Integer> {
}

package com.sofkau.hospitalBackEnd.HospitalBackEnd.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "specialty")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "physician_in_charge", length = 45)
    private String physicianInCharge;

    @OneToMany(mappedBy = "fkMedicalSpecialty",fetch= FetchType.EAGER)
    @JsonManagedReference
    private List<Patient> patients = new ArrayList<>();
}

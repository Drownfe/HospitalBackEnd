package com.sofkau.hospitalBackEnd.HospitalBackEnd.service;

import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.PatientDTO;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.SpecialtyDTO;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.entity.Patient;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.entity.Specialty;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService implements IPatientService{

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    @Override
    public PatientDTO savePatientRegister(SpecialtyDTO dtoSpecialty) {
        List<SpecialtyDTO> Entity_toDTO;
        return convertPatientEntitytoDTO(patientrepository.save(
                convertDTOtoPatientEntity(dtoSpecialty.getPatients().get(0), dtoSpecialty)));
    }

    private Patient convertDTOtoPatientEntity(PatientDTO DTOpatient, SpecialtyDTO dtoSpecialty) {
        Patient aux_patient = new Patient();

        aux_patient.setId(DTOpatient.getId());
        aux_patient.setName(DTOpatient.getName());
        aux_patient.setAge(DTOpatient.getAge());
        aux_patient.setDni(DTOpatient.getDni());
        aux_patient.setDate(String.join(",", DTOpatient.getDate()));
        aux_patient.setNumberOfApointments(DTOpatient.getNumberOfApointments());
        aux_patient.setFkSpecialty(convertDTOtoEntity(dtoSpecialty));
        return aux_patient;
    }

    public Specialty convertDTOtoEntity(SpecialtyDTO specialty){

        Specialty auxdToSpecialty = new Specialty();
        auxdToSpecialty.setId(specialty.getId());
        auxdToSpecialty.setPhysicianInCharge(specialty.getPhysicianInCharge());
        auxdToSpecialty.setName(specialty.getName());
        auxdToSpecialty.setPatients(null);

        return auxdToSpecialty;
    }

    private SpecialtyDTO convertMedicalEntityToDTOsingle(Specialty specialty){

        SpecialtyDTO auxdToSpecialty = new SpecialtyDTO();
        auxdToSpecialty.setId(specialty.getId());
        auxdToSpecialty.setPhysicianInCharge(specialty.getPhysicianInCharge());
        auxdToSpecialty.setName(specialty.getName());
        auxdToSpecialty.setPatients(null);
        return auxdToSpecialty;
    }

    private PatientDTO convertPatientEntitytoDTO(Patient patient){

        PatientDTO auxdToPatient = new PatientDTO();

        auxdToPatient.setId(patient.getId());
        auxdToPatient.setName(patient.getName());
        auxdToPatient.setAge(patient.getAge());
        auxdToPatient.setDni(patient.getDni());

        String[] dates = patient.getDate().split(",");
        auxdToPatient.setDate(Arrays.stream(dates).collect(Collectors.toList()));
        auxdToPatient.setNumberOfApointments(patient.getNumberOfApointments());
        return auxdToPatient;
    }
}

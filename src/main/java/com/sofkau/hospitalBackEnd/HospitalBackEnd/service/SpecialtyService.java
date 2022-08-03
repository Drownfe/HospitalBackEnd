package com.sofkau.hospitalBackEnd.HospitalBackEnd.service;

import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.PatientDTO;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.dto.SpecialtyDTO;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.entity.Patient;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.entity.Specialty;
import com.sofkau.hospitalBackEnd.HospitalBackEnd.repository.SpecialtyRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyService implements ISpecialtyService{

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public List<SpecialtyDTO> findAllSpecialty() {
        List<SpecialtyDTO> Entity_ToDTO;

        Entity_ToDTO = convertMedicalEntityToDTO(specialtyRepository.findAll());

        return Entity_ToDTO;
    }

    public SpecialtyDTO saveSpecialtyRegister(SpecialtyDTO specialty) {

        return convertMedicalEntitytoDTOsingle(specialtyRepository.save(convertDTOtoEntity(specialty)));
    }

    public Specialty convertDTOtoEntity(SpecialtyDTO specialty){

        Specialty auxdToSpecialty = new Specialty();
        auxdToSpecialty.setId(specialty.getId());
        auxdToSpecialty.setPhysicianInCharge(specialty.getPhysicianInCharge());
        auxdToSpecialty.setName(specialty.getName());
        auxdToSpecialty.setPatients(convertDTOtoPatientEntity(specialty.getPatients()));

        return auxdToSpecialty;
    }
    private SpecialtyDTO convertMedicalEntitytoDTOsingle(Specialty specialty){

        SpecialtyDTO auxdToSpecialty = new SpecialtyDTO();
        auxdToSpecialty.setId(specialty.getId());
        auxdToSpecialty.setPhysicianInCharge(specialty.getPhysicianInCharge());
        auxdToSpecialty.setName(specialty.getName());
        auxdToSpecialty.setPatients(convertPatientEntitytoDTO(specialty.getPatients()));

        return auxdToSpecialty;
    }
    private List<Patient> convertDTOtoPatientEntity(List<Patient> DTOpatientList){
        List<Patient> patient_list = new ArrayList<>();
        for (int i = 0; i< DTOpatientList.size(); i++){

            Patient aux_dto_patient = new Patient();

            aux_dto_patient.setId(DTOpatientList.get(i).getId());
            aux_dto_patient.setName(DTOpatientList.get(i).getName());
            aux_dto_patient.setAge(DTOpatientList.get(i).getAge());
            aux_dto_patient.setIdentificationNumber(DTOpatientList.get(i).getIdentificationNumber());
            aux_dto_patient.setDate( String.join(", ", DTOpatientList.get(i).getDate()));
            aux_dto_patient.setNumberOfApointments(DTOpatientList.get(i).getNumberOfApointments());
            patient_list.add(aux_dto_patient);
        }
        return patient_list;
    }

    private List<SpecialtyDTO> convertMedicalEntityToDTO(List<Specialty> specialtyList){
        List<SpecialtyDTO> EntityToDTO = new ArrayList<>();
        for (int i = 0; i< specialtyList.size(); i++){
            SpecialtyDTO auxdToSpecialty = new SpecialtyDTO();
            auxdToSpecialty.setId(specialtyList.get(i).getId());
            auxdToSpecialty.setPhysicianInCharge(specialtyList.get(i).getPhysicianInCharge());
            auxdToSpecialty.setName(specialtyList.get(i).getName());
            auxdToSpecialty.setPatients(convertPatientEntityToDTO(specialtyList.get(i).getPatients()));
            EntityToDTO.add(auxdToSpecialty);
        }
        return EntityToDTO;
    }

    private List<PatientDTO> convertPatientEntityToDTO(List<Patient> patientList){
        List<PatientDTO> DTOpatientList = new ArrayList<>();
        for (int i = 0; i< patientList.size(); i++){

            PatientDTO auxdToPatient = new PatientDTO();

            auxdToPatient.setId(patientList.get(i).getId());
            auxdToPatient.setName(patientList.get(i).getName());
            auxdToPatient.setAge(patientList.get(i).getAge());
            auxdToPatient.setIdentificationNumber(patientList.get(i).getDni());

            String[] dates = patientList.get(i).getDate().split(",");
            auxdToPatient.setDate(Arrays.stream(dates).collect(Collectors.toList()));

            auxdToPatient.setNumberOfApointments(patientList.get(i).getNumberOfApointments());
            DTOpatientList.add(auxdToPatient);
        }
        return DTOpatientList;
    }

}

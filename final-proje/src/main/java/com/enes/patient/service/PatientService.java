package com.enes.patient.service;

import com.enes.patient.entity.Patient;
import com.enes.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("patientService")
@Transactional
public class PatientService {

    @Qualifier("patientRepository")
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findPatientsByLastName(String lastName){
        return patientRepository.findPatientsByLastName(lastName);
    }
    public List<Patient> findPatientsByCode(String code){
        return patientRepository.findPatientsByCode(code);
    }
    public List<Patient> findPatientsByFirstName(String firstName){
        return patientRepository.findPatientsByFirstName(firstName);
    }
    public List<Patient> findPatientsByDiagnosis(String diagnosis){
        return patientRepository.findPatientsByDiagnosis(diagnosis);
    }

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients(){
        List<Patient> all = new ArrayList();
        patientRepository.findAll().forEach(i->{
            all.add(i);
        });
        return all;
    }

    public void remove(Patient patient) {
        patientRepository.delete(patient);
    }
}

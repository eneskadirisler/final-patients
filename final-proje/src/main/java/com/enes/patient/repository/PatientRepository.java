package com.enes.patient.repository;


import com.enes.patient.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository("patientRepository")
public interface PatientRepository extends CrudRepository<Patient, Long> {

    List<Patient> findPatientsByLastName(String lastName);
    List<Patient> findPatientsByCode(String code);
    List<Patient> findPatientsByFirstName(String firstName);
    List<Patient> findPatientsByDiagnosis(String diagnosis);
}

package com.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Patient;
import com.healthcare.repository.PatientRepository;

@Service
public class PatientService {
@Autowired(required = true)  
private PatientRepository patientRepository;

public Patient addPatient(Patient patient){
    return patientRepository.save(patient);
}
public Patient getByPatientId (Long id) {
    return patientRepository.findById(id).orElse(null);
}

public List<Patient> getAllPatients() {
    return patientRepository.findAll();
}

    
}

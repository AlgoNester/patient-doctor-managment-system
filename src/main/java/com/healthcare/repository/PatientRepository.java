package com.healthcare.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.model.Patient;

public interface PatientRepository extends JpaRepository <Patient, Long> {}
    


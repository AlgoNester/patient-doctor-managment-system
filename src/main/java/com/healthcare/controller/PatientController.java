package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.healthcare.model.Patient;
import com.healthcare.services.PatientService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
   
    
      @PostMapping
   public ResponseEntity<Patient> addDoctor(@RequestBody Patient patient) {
     Patient patientInfo= patientService.addPatient(patient);
     return new ResponseEntity<>(patientInfo, HttpStatus.OK);
      
   }
     @GetMapping()
   public ResponseEntity<List<Patient>> getAllPatients(@RequestParam String param) {
      List<Patient> patients= patientService.getAllPatients();
      return new ResponseEntity<>(patients, HttpStatus.OK);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
    Patient patient =patientService.getByPatientId(id);
    return patient!=null ? new ResponseEntity<>(patient, HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND);

      
   }

   @DeleteMapping("/{id}")
   public String deletePatient(@RequestParam String param) {
    return new String();
}

    

    
}

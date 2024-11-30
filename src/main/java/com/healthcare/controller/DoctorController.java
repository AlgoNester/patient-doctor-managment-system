package com.healthcare.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.model.Doctor;
import com.healthcare.services.DoctorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

   @PostMapping
   public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
     Doctor doctorInfo= doctorService.saveDoctor(doctor);
     return new ResponseEntity<>(doctorInfo, HttpStatus.OK);
      
   }
   
   @GetMapping()
   public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam String param) {
      List<Doctor> doctors= doctorService.getAllDoctors();
      return new ResponseEntity<>(doctors, HttpStatus.OK);
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
    Doctor doctor =doctorService.getDoctorById(id);
    return doctor!=null ? new ResponseEntity<>(doctor, HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND);

      
   }

   @DeleteMapping("/{id}")
   public String deleteDoctor(@RequestParam String param) {
    return new String();
}

   
    
    
}

package com.healthcare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.model.Doctor;
import com.healthcare.repository.DoctorRepository;

@Service
public class DoctorService {

    @Autowired(required = true)
    private  DoctorRepository doctorRepositoy ;

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepositoy.save(doctor);
    }

    public Doctor getDoctorById(Long id){
        return doctorRepositoy.findById(id).orElse(null);
    }
    public List<Doctor> getAllDoctors() {
        return doctorRepositoy.findAll();
    }

    public Doctor updateDoctor(Long id, Doctor doctorInfo){
        Optional<Doctor> optionalDoctor = doctorRepositoy.findById(id);
        if (optionalDoctor.isPresent()) {
            Doctor existingDoctor = optionalDoctor.get();
            existingDoctor.setFirstName(doctorInfo.getFirstName());
            existingDoctor.setLastName(doctorInfo.getLastName());
            existingDoctor.setAvailability(doctorInfo.getAvailability());
            existingDoctor.setSpeciality(doctorInfo.getSpeciality());
            return doctorRepositoy.save(existingDoctor);

        }
        return null;

    }
    public boolean deleteDoctor(Long id){
        if(doctorRepositoy.existsById(id)) {
            doctorRepositoy.deleteById(id);
            return true;
        }
        return false; 
    }
    
}

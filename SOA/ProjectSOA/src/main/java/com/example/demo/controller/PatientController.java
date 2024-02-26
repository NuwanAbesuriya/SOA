package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Patient;
import com.example.demo.service.PatientService;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }


    @GetMapping("/{patientid}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long patientid) {
        return ResponseEntity.of(patientService.getPatientById(patientid));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Patient>> searchPatientsByNom(
            @RequestParam String nom) {
        List<Patient> patients = patientService.searchPatientsByNom(nom);
        return ResponseEntity.ok(patients);
    }

    @PostMapping("/add")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient addedPatient = patientService.savePatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPatient);
    }

    @PutMapping("/update/{patientid}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientid, @RequestBody Patient patient) {
        return patientService.getPatientById(patientid)
                .map(existingPatient -> {
                    patient.setId(patientid);
                    Patient updatedPatient = patientService.savePatient(patient);
                    return ResponseEntity.ok(updatedPatient);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{patientid}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long patientid) {
        if (patientService.getPatientById(patientid).isPresent()) {
            patientService.deletePatient(patientid);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

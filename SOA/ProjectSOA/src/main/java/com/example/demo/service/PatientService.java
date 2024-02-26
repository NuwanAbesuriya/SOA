package com.example.demo.service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    
    

    public PatientService(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
 // Récupérer tous les patients
	public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
	 // Récupérer un patient par ID
    public Optional<Patient> getPatientById(Long patientid) {
        return patientRepository.findById(patientid);
    }
    // Sauvegarder un patient
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
 // Supprimer un patient par ID
    public void deletePatient(Long patientid) {
        patientRepository.deleteById(patientid);
    }
 // Rechercher des patients par nom
    public List<Patient> searchPatientsByNom(String nom) {
        return patientRepository.findByNomContaining(nom);
    }
    

    
}

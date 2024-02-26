package com.example.demo.service;

import com.example.demo.model.Chirurgie;
import com.example.demo.repository.ChirurgieRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.SalleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ChirurgieService {
    @Autowired
    private ChirurgieRepository chirurgieRepository;
    
    @Autowired
    private SalleRepository salleRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private PatientRepository patientRepository;

    

	public ChirurgieService(ChirurgieRepository chirurgieRepository) {
		super();
		this.chirurgieRepository = chirurgieRepository;
	}
    
 // Récupérer toutes les chirurgies
    
	public List<Chirurgie> getAllChirurgies() {
        return chirurgieRepository.findAll();
    }
 // Récupérer une chirurgie par ID
    public Optional<Chirurgie> getChirurgieById(Long id) {
        return chirurgieRepository.findById(id);
    }
 // Sauvegarder une chirurgie
    public Chirurgie saveChirurgie(Chirurgie chirurgie) {
    	// Ensure associated entities are saved/persisted
    	        salleRepository.save(chirurgie.getSalle());
    	        medecinRepository.save(chirurgie.getMedecin());
    	        patientRepository.save(chirurgie.getPatient());

    	        // Save Chirurgie entity
    	        
    	    
        return chirurgieRepository.save(chirurgie);
    }
 // Supprimer une chirurgie par ID
    public void deleteChirurgie(Long id) {
        chirurgieRepository.deleteById(id);
    }
 // Rechercher des chirurgies par type
    public List<Chirurgie> searchChirurgiesByType(String type) {
        return chirurgieRepository.findByTypeContaining(type);
    }
 // Rechercher des chirurgies entre deux dates  
    
    public List<Chirurgie> searchChirurgiesByDateBetween(Date dateDebut, Date dateFin) {
        return chirurgieRepository.findByDateBetween(dateDebut, dateFin);
    }

    
}

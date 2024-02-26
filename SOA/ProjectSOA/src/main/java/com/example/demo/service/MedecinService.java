package com.example.demo.service;

import com.example.demo.model.Medecin;
import com.example.demo.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedecinService {
    @Autowired
    private MedecinRepository medecinRepository;
    
    

    public MedecinService(MedecinRepository medecinRepository) {
		super();
		this.medecinRepository = medecinRepository;
	}
 // Récupérer tous les médecins
	public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }
	// Récupérer un médecin par ID
    public Optional<Medecin> getMedecinById(Long medecinid) {
        return medecinRepository.findById(medecinid);
    }
 // Sauvegarder un médecin
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }
 // Supprimer un médecin par ID
    public void deleteMedecin(Long medecinid) {
        medecinRepository.deleteById(medecinid);
    }
    
 // Rechercher des médecins par spécialité
    public List<Medecin> searchMedecinsBySpecialite(String specialite) {
        return medecinRepository.findBySpecialiteContaining(specialite);
    }
    

  
}

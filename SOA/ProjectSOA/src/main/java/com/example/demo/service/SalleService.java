package com.example.demo.service;

import com.example.demo.model.Salle;
import com.example.demo.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;
    
    

    public SalleService(SalleRepository salleRepository) {
		super();
		this.salleRepository = salleRepository;
	}
 // Récupérer toutes les salles
	public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }
	// Récupérer une salle par ID
    public Optional<Salle> getSalleById(Long salleid) {
        return salleRepository.findById(salleid);
    }
    // Sauvegarder une salle
    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }
 // Supprimer une salle par ID
    public void deleteSalle(Long salleid) {
        salleRepository.deleteById(salleid);
    }
 // Rechercher des salles par type
    public List<Salle> searchSallesByType(String type) {
        return salleRepository.findByTypeContaining(type);
    }

    
}

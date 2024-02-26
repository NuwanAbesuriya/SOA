package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Chirurgie;

public interface ChirurgieRepository extends JpaRepository<Chirurgie, Long> {


    // Recherche de chirurgies par type
	List<Chirurgie> findByTypeContaining(String type);

	// Recherche de chirurgies entre deux dates
	List<Chirurgie> findByDateBetween(Date dateDebut, Date dateFin);

}

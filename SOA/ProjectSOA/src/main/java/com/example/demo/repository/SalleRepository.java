package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Salle;

public interface SalleRepository extends JpaRepository<Salle, Long> {

	// Recherche de salles par type
	List<Salle> findByTypeContaining(String type);

}

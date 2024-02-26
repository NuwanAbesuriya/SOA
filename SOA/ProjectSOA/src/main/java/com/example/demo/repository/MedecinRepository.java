package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {

	// Recherche de médecins par spécialité
	List<Medecin> findBySpecialiteContaining(String specialite);

}

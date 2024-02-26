package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "medecin")
public class Medecin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medecinid;
    private String nom;
    private String specialite;
    private String adresse;
    private String numeroTelephone;
    
    public Medecin() {
        // Default constructor
    }
	public Medecin(Long id, String nom, String specialite, String adresse, String numeroTelephone) {
		super();
		this.medecinid = id;
		this.nom = nom;
		this.specialite = specialite;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
	}
	public Medecin(String nom, String specialite, String adresse, String numeroTelephone) {
		super();
		this.nom = nom;
		this.specialite = specialite;
		this.adresse = adresse;
		this.numeroTelephone = numeroTelephone;
	}
	public Long getId() {
		return medecinid;
	}
	public void setId(Long id) {
		this.medecinid = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
    

}

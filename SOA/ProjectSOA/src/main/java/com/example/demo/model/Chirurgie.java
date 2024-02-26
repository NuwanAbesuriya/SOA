package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "chirurgie")
public class Chirurgie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String type;
    private String description;
    private Date date;
    private double frais;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "salleid", nullable=false)
    private Salle salle;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patientid", nullable=false)
    private Patient patient;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "medecinid",nullable=false )
    private Medecin medecin;
    

	public Chirurgie() {
		
	}

	public Chirurgie(Long id, String type, String description, Date date, double frais, Salle salle, Patient patient,
			Medecin medecin) {
		super();
		this.id = id;
		this.type = type;
		this.description = description;
		this.date = date;
		this.frais = frais;
		this.salle = salle;
		this.patient = patient;
		this.medecin = medecin;
	}

	public Chirurgie(String type, String description, Date date, double frais, Salle salle, Patient patient,
			Medecin medecin) {
		super();
		this.type = type;
		this.description = description;
		this.date = date;
		this.frais = frais;
		this.salle = salle;
		this.patient = patient;
		this.medecin = medecin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getFrais() {
		return frais;
	}

	public void setFrais(double frais) {
		this.frais = frais;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
    

}

package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "salle")
public class Salle {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long salleid;
    private String numero;
    private int capacite;
    private String type;
    private boolean disponible;
    
    
	public Salle() {
		
	}
	public Salle(Long id, String numero, int capacite, String type, boolean disponible) {
		super();
		this.salleid = id;
		this.numero = numero;
		this.capacite = capacite;
		this.type = type;
		this.disponible = disponible;
	}
	public Salle(String numero, int capacite, String type, boolean disponible) {
		super();
		this.numero = numero;
		this.capacite = capacite;
		this.type = type;
		this.disponible = disponible;
	}
	public Long getId() {
		return salleid;
	}
	public void setId(Long id) {
		this.salleid = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
    

}

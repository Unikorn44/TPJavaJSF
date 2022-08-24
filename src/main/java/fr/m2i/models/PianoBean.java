package fr.m2i.models;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named //Cette classe est à gérer par le cdi ET c'est une Bean managée aka Backed Bean 
@RequestScoped //Dispo tout au long de la requête
public class PianoBean implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private String description;
	private Integer prix;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	
	public PianoBean(String nom, String description, Integer prix) {
		this.nom = nom;
		this.description = description;
		this.prix = prix;
	}

	
	
}

package fr.m2i.backed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import fr.m2i.models.PianoBean;

@Named //Cette classe est à gérer par le cdi ET c'est une Bean managée aka Backed Bean 
@SessionScoped //Dispo tout au long de la requête
public class DepotBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<PianoBean> pianosAVendre;

	public List<PianoBean> getPianosAVendre() {
		return pianosAVendre;
	}

	public void setPianosAVendre(List<PianoBean> pianosAVendre) {
		this.pianosAVendre = pianosAVendre;
	}

	@PostConstruct
	public void init() {
		
		System.out.println("Passage par le init");
		this.pianosAVendre = new ArrayList<PianoBean>();
		
		this.pianosAVendre.add(new PianoBean("Piano à Queue", "Grand piano pour les concerts huppés", 100000));
		this.pianosAVendre.add(new PianoBean("Piano droit", "Petit piano pour les petits concerts pas huppés", 5000));
		this.pianosAVendre.add(new PianoBean("Piano de cuisine", "Piano pour les non mélomanes", 20000));
		this.pianosAVendre.add(new PianoBean("Piano à Bretelles", "Piano pour concerts de rue", 5000));
		
		System.out.println("taille liste : " + this.pianosAVendre.size());
	}

	
	
	
	
}

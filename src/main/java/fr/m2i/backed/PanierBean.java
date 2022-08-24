package fr.m2i.backed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Named;

import fr.m2i.models.PianoBean;
import fr.m2i.models.PianoCommandeBean;

@SuppressWarnings("unused")
@Named //Cette classe est à gérer par le cdi ET c'est une Bean managée aka Backed Bean 
@SessionScoped //Dispo tout au long de la requête
public class PanierBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty("#{param.name}")
	private Integer quantite = 0;
	
		
	List<PianoCommandeBean> panierPianos = new ArrayList<PianoCommandeBean>();
	
	public List<PianoCommandeBean> getPanierPianos() {
		return panierPianos;
	}

	public void setPanierPianos(List<PianoCommandeBean> panierPianos) {
		this.panierPianos = panierPianos;
	}

	public void ajouterAuPanier(PianoBean piano) {
		System.out.println("bip");
		this.panierPianos.add(new PianoCommandeBean(piano, 1));
		
	}

	public void supprimerCommande() {
		System.out.println("bip-bip");
		this.panierPianos = new ArrayList<>();
	}
	
}

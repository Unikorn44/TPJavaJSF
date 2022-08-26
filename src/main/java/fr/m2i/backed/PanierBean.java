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
			
	List<PianoCommandeBean> panier = new ArrayList<PianoCommandeBean>();
	
	public List<PianoCommandeBean> getPanier() {
		return panier;
	}

	public void setPanier(List<PianoCommandeBean> panier) {
		this.panier = panier;
	}

	public void supprimerCommande() {
		System.out.println("bip-bip");
		this.panier = new ArrayList<>();
	}
	
	public void ajoutListe(PianoBean piano) {
		//boolean pour ne PAS modifier LONGUEUR list dans boucle
		boolean estPresent = false;
		
		//boucle sur chaque élément présent dans la liste
		for(PianoCommandeBean commande: panier) {
			//if de détection présence piano dans liste de commande
			if(commande.getPianoBean().getNom().equals(piano.getNom())) {
				commande.setQuantite(commande.getQuantite()+1);
				estPresent = true;				
				break; //sortie boucle en cas présence
			} 	
		}		
		//Modification list HORS itération
		if(!estPresent) {
			panier.add(new PianoCommandeBean(piano, 1));	
		}		
	}
	
	//retrait piano de la commande
	public void retirerCommande(PianoBean piano) {
		Integer position = 0;
		Integer q = 0;
		//PianoCommandeBean commande = new PianoCommandeBean(piano, q);
		//boucle sur chaque élément présent dans la liste
		for(PianoCommandeBean commande: panier) {
			q = commande.getQuantite();
			//if de détection présence piano dans liste de commande
			if(commande.getPianoBean().getNom().equals(piano.getNom())) {
				if (q > 1) {
					commande.setQuantite(commande.getQuantite()-1);						
					System.out.println("reduced " + position);
					break; //sortie boucle					
				} else {
					System.out.println("out !" + position);
					break;
				}
			} else {
				position++;
				System.out.println("+1" + position);
			}
		}			
		if (q == 1) {
			//PianoBean paino2remove = commande.getPianoBean();
			System.out.println("destroy " + position);
			System.out.println(panier);
			panier.remove((int)position);					
		}
	}
	
	public Integer getPrixCommande(PianoCommandeBean commande) {
		//calcul prix chaque ligne commande
		return commande.getPianoBean().getPrix()*commande.getQuantite();		
	}
	
	
	public Integer prixTotalPanier() {
		Integer prixTotal = 0;
		for(PianoCommandeBean commande: panier) {
			prixTotal += getPrixCommande(commande);
		}
		return prixTotal;
	}
	
}

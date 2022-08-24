package fr.m2i.models;



public class PianoCommandeBean {
	
	
	private PianoBean pianoBean;
	private Integer quantite;
	
	public PianoCommandeBean(PianoBean pianoBean, Integer quantite) {
		this.setPianoBean(pianoBean);
		this.quantite = quantite;
	}
	
	public PianoBean getPianoBean() {
		return pianoBean;
	}
	public void setPianoBean(PianoBean pianoBean) {
		this.pianoBean = pianoBean;
	}	

	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}


	
}

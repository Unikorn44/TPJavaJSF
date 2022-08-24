package fr.m2i.backed;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RouteBean implements Serializable {
	
	@Inject
	@ManagedProperty(value="#{param.pageId}")
	private String pageId;
	
	private static final long serialVersionUID = 1L;
	
	public String page() {
		
		if(pageId.equals("index")) {
			
			return "index";
		}
		if(pageId.equals("panier")) {			
			return "panier";
		}

		System.out.println("Nope");
		return "/index?faces-redirect=true";
	}

}

package BO;

import java.util.Date;

public class Encheres {
	private Utilisateurs utilisateur;
	private Articles_Vendus article;
	private Date date_enchere;
	private float montant_enchere;
	
	
	
	public Encheres(Utilisateurs utilisateur, Articles_Vendus article, Date date_enchere, float montant_enchere) {
		super();
		this.utilisateur = utilisateur;
		this.article = article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}



	public Utilisateurs getutilisateur() {
		return utilisateur;
	}



	public Articles_Vendus getarticle() {
		return article;
	}



	public Date getDate_enchere() {
		return date_enchere;
	}



	public float getMontant_enchere() {
		return montant_enchere;
	}

	
	
	
	
	
	
}

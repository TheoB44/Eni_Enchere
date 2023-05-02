package BO;

import java.util.Date;

public class Encheres {
	private int no_utilisateur;
	private int no_article;
	private Date date_enchere;
	private float montant_enchere;
	
	
	
	public Encheres(int no_utilisateur, int no_article, Date date_enchere, float montant_enchere) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.no_article = no_article;
		this.date_enchere = date_enchere;
		this.montant_enchere = montant_enchere;
	}



	public int getNo_utilisateur() {
		return no_utilisateur;
	}



	public int getNo_article() {
		return no_article;
	}



	public Date getDate_enchere() {
		return date_enchere;
	}



	public float getMontant_enchere() {
		return montant_enchere;
	}

	
	
	
	
	
	
}

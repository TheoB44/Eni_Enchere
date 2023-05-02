package BO;

import java.util.Date;

public class Articles_Vendus {

	private int no_article;
	private String nom_article;
	private String description;
	private Date date_debut_enchere;
	private Date date_fin_enchere;
	private float prix_initial;
	private float prix_vente;
	private int no_utilisateur;
	private int no_categorie;
	private char etat_vente;
	private String image;
	
	
	public Articles_Vendus(int no_article, String nom_article, String description, Date date_debut_enchere,
			Date date_fin_enchere, float prix_initial, float prix_vente, int no_utilisateur, int no_categorie,
			char etat_vente, String image) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_enchere = date_debut_enchere;
		this.date_fin_enchere = date_fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.no_utilisateur = no_utilisateur;
		this.no_categorie = no_categorie;
		this.etat_vente = etat_vente;
		this.image = image;
	}


	public int getNo_article() {
		return no_article;
	}


	public String getNom_article() {
		return nom_article;
	}


	public String getDescription() {
		return description;
	}


	public Date getDate_debut_enchere() {
		return date_debut_enchere;
	}


	public Date getDate_fin_enchere() {
		return date_fin_enchere;
	}


	public float getPrix_initial() {
		return prix_initial;
	}


	public float getPrix_vente() {
		return prix_vente;
	}


	public int getNo_utilisateur() {
		return no_utilisateur;
	}


	public int getNo_categorie() {
		return no_categorie;
	}


	public char getEtat_vente() {
		return etat_vente;
	}


	public String getImage() {
		return image;
	}
	
	
	
	
}

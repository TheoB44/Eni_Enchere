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
	private Utilisateurs utilisateur;
	private Categories categorie;
	
	


	public Articles_Vendus(int no_article, String nom_article, String description, Date date_debut_enchere,
			Date date_fin_enchere, float prix_initial, float prix_vente, int no_utilisateur, int no_categorie,
			char etat_vente, String image, Utilisateurs utilisateur, Categories categorie) {
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
		this.utilisateur = utilisateur;
		this.categorie = categorie;
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


	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateurs utilisateur) {
		this.utilisateur = utilisateur;
	}


	public Categories getCategorie() {
		return categorie;
	}


	public void setCategorie(Categories categorie) {
		this.categorie = categorie;
	}


	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}


	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setDate_debut_enchere(Date date_debut_enchere) {
		this.date_debut_enchere = date_debut_enchere;
	}


	public void setDate_fin_enchere(Date date_fin_enchere) {
		this.date_fin_enchere = date_fin_enchere;
	}


	public void setPrix_initial(float prix_initial) {
		this.prix_initial = prix_initial;
	}


	public void setPrix_vente(float prix_vente) {
		this.prix_vente = prix_vente;
	}


	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}


	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}


	public void setEtat_vente(char etat_vente) {
		this.etat_vente = etat_vente;
	}


	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}

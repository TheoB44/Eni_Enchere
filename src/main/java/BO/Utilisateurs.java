package BO;

public class Utilisateurs {

	private int no_utilisateurs;
	private String psuedo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String code_postal;
	private String ville;
	private String mot_de_passe;
	private int credit;
	private boolean administrateur;


public Utilisateurs(int no_utilisateurs, String psuedo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
		super();
		this.no_utilisateurs = no_utilisateurs;
		this.psuedo = psuedo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}

public int getNo_utilisateurs() {
	return no_utilisateurs;
}
public String getPsuedo() {
	return psuedo;
}
public String getNom() {
	return nom;
}
public String getPrenom() {
	return prenom;
}
public String getEmail() {
	return email;
}
public String getTelephone() {
	return telephone;
}
public String getRue() {
	return rue;
}
public String getCode_postal() {
	return code_postal;
}
public String getVille() {
	return ville;
}
public String getMot_de_passe() {
	return mot_de_passe;
}
public int getCredit() {
	return credit;
}
public boolean isAdministrateur() {
	return administrateur;
}
	
}

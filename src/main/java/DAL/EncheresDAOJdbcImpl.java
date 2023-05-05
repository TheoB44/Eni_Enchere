package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BO.Articles_Vendus;
import BO.Encheres;
import BO.Utilisateurs;

public class EncheresDAOJdbcImpl implements EncheresDAO {

	private static final String SELECT_ALL = "SELECT E.montant_enchere, A.nom_article, A.date_fin_enchere, V.pseudo, A.no_utilisateur FROM ENCHERES E"
			+ " LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS V ON A.no_utilisateur = V.no_utilisateur"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur;";

	private static final String SELECT_SEARCH = "SELECT E.montant_enchere, A.nom_article, A.date_fin_enchere, U.pseudo FROM ENCHERES E"
			+ " LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur"
			+ " LEFT JOIN CATEGORIES C ON C.no_categorie = A.no_categorie"
			+ " WHERE A.nom_article like ?;";
	
	private static final String SELECT_SEARCH_ARTICLE = "SELECT E.montant_enchere, A.nom_article, A.date_fin_enchere, U.pseudo FROM ENCHERES E"
			+ " LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur"
			+ " LEFT JOIN CATEGORIES C ON C.no_categorie = A.no_categorie"
			+ " WHERE A.nom_article like ?"
			+ " AND C.no_categorie = ?;";
	
	private static final String SELECT_SEARCH_CONNECTED = "SELECT E.montant_enchere, A.nom_article, A.date_fin_enchere, U.pseudo FROM ENCHERES E"
			+ " LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur"
			+ " LEFT JOIN CATEGORIES C ON C.no_categorie = A.no_categorie"
			+ " WHERE A.nom_article like ?"
			+ " AND C.no_categorie = ?";
	
	private static final String SELECT_SEARCH_CONNECTED_ALL = "SELECT E.montant_enchere, A.nom_article, A.date_fin_enchere, U.pseudo FROM ENCHERES E"
			+ " LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur"
			+ " LEFT JOIN CATEGORIES C ON C.no_categorie = A.no_categorie"
			+ " WHERE A.nom_article like ?";
	

	@Override
	public List<Encheres> SearchConnected(String nomArticle, String noCate, int noUtil, List<String> etatVente, String type) {
		List<Encheres> resultat = new ArrayList();
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = null;
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			String requete = null;
			if(noCate.equals("all")){
				requete = SELECT_SEARCH_CONNECTED_ALL;
			}
			else {
				requete = SELECT_SEARCH_CONNECTED;
			}
			
			if(type.equals("achat")) {
				List<String> elements = new ArrayList();
				
				if(etatVente.contains("enchereOuverte") || etatVente.size() == 0) {
					String requetePart = "";
					requetePart += " ( A.etat_vente = 'EC' )";
					elements.add(requetePart);
				}
				
				if(etatVente.contains("mesEncheres") || etatVente.size() == 0) {
					String requetePart = "";
					requetePart += " ( E.no_utilisateur = " +noUtil + " )";
					elements.add(requetePart);
				}
				
				if(etatVente.contains("enchereRemporte") || etatVente.size() == 0) {
					String requetePart = "";
					requetePart += " ( E.no_utilisateur = " +noUtil + " AND";
					requetePart += " E.montant_enchere = A.prix_vente)";
					elements.add(requetePart);
				}


				if(elements.size()>0 ){
					
					requete += " AND (";
					
					for (int i = 0; i < elements.size(); i++) {
						  requete += elements.get(i);
						  if(i< elements.size()-1) {
							  requete += " OR ";
						  }
						}
					
					requete += " );";
				}
				
			}
			else {
				
				List<String> elements = new ArrayList();
				
				if(etatVente.contains("checkVenteEC") || etatVente.size() == 0) {
					String requetePart = "";
					requetePart += " ( A.no_utilisateur = " +noUtil;
					requetePart += " AND A.etat_vente = 'EC' )";
					elements.add(requetePart);
				}
				
				if(etatVente.contains("checkVenteDebute") || etatVente.size() == 0) {
					String requetePart = "";
					requetePart += " ( A.no_utilisateur = " +noUtil;
					requetePart += " AND A.etat_vente = 'CR' )";
					elements.add(requetePart);
				}
				
				if(etatVente.contains("checkVenteTermine") || etatVente.size() == 0) {
					String requetePart = "";
					requetePart += " ( A.no_utilisateur = " +noUtil;
					requetePart += " AND A.etat_vente = 'VD' )";
					elements.add(requetePart);
				}
				
				if(elements.size()>0){
					
					requete += " AND (";
					
					for (int i = 0; i < elements.size(); i++) {
						  requete += elements.get(i);
						  if(i< elements.size()-1) {
							  requete += " OR ";
						  }
						}
					
					requete += " );";
				}

			}
			
			ps = cnx.prepareStatement(requete);

			// 3e etape : attribuer les parametres nécessaires à ma requête
			
			if(noCate.equals("all")){
				ps.setString(1, "%"+ nomArticle +"%");
			}
			else {
				ps.setString(2, "%"+ nomArticle +"%");
				ps.setString(2, noCate);
			}

			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Encheres encheres = null;
					encheres = new Encheres();
					encheres.setMontant_enchere(rs.getFloat("montant_enchere"));
					Articles_Vendus article = new Articles_Vendus();
					article.setNom_article(rs.getString("nom_article"));
					article.setDate_fin_enchere(rs.getDate("date_fin_enchere"));
					Utilisateurs util = new Utilisateurs();
					util.setPseudo(rs.getString("pseudo"));
					encheres.setArticle(article);
					encheres.setUtilisateur(util);
					resultat.add(encheres);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	@Override
	public List<Encheres> Search(String nomArticle, String noCate) {
		List<Encheres> resultat = new ArrayList();
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = null;
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			if(noCate.equals("all"))
			{
				ps = cnx.prepareStatement(SELECT_SEARCH);

				// 3e etape : attribuer les parametres nécessaires à ma requête
				ps.setString(1, "%"+ nomArticle +"%");
			}
			else {
				ps = cnx.prepareStatement(SELECT_SEARCH_ARTICLE);

				// 3e etape : attribuer les parametres nécessaires à ma requête
				ps.setString(1, "%"+ nomArticle +"%");
				ps.setString(2, noCate);
			}

			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Encheres encheres = null;
					encheres = new Encheres();
					encheres.setMontant_enchere(rs.getFloat("montant_enchere"));
					Articles_Vendus article = new Articles_Vendus();
					article.setNom_article(rs.getString("nom_article"));
					article.setDate_fin_enchere(rs.getDate("date_fin_enchere"));
					Utilisateurs util = new Utilisateurs();
					util.setPseudo(rs.getString("pseudo"));
					encheres.setArticle(article);
					encheres.setUtilisateur(util);
					resultat.add(encheres);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public List<Encheres> SelectAll() {
		List<Encheres> resultat = new ArrayList();
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);

			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Encheres encheres = null;
					encheres = new Encheres();
					encheres.setMontant_enchere(rs.getFloat("montant_enchere"));
					Articles_Vendus article = new Articles_Vendus();
					article.setNom_article(rs.getString("nom_article"));
					article.setDate_fin_enchere(rs.getDate("date_fin_enchere"));
					article.setNo_utilisateur(rs.getInt("no_utilisateur"));
					Utilisateurs util = new Utilisateurs();
					util.setPseudo(rs.getString("pseudo"));
					encheres.setArticle(article);
					encheres.setUtilisateur(util);
					resultat.add(encheres);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
}

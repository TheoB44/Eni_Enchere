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

	private static final String SELECT_ALL = "SELECT E.montant_enchere, A.nom_article, A.date_fin_enchere, U.pseudo FROM ENCHERES E"
			+ " LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur;";

	private static final String SELECT_SEARCH_ALL = "SELECT E.montant_enchere, A.nom_article, A.date_fin_enchere, U.pseudo FROM ENCHERES E"
			+ " LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur"
			+ " LEFT JOIN CATEGORIES C ON C.no_categorie = A.no_categorie"
			+ " WHERE A.nom_article like ?;";
	
	private static final String SELECT_SEARCH = "SELECT E.montant_enchere, A.nom_article, A.date_fin_enchere, U.pseudo FROM ENCHERES E"
			+ " LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur"
			+ " LEFT JOIN CATEGORIES C ON C.no_categorie = A.no_categorie"
			+ " WHERE A.nom_article like ?"
			+ " AND C.no_categorie = ?;";

	@Override
	public List<Encheres> Search(String nomArticle, String noCate) {
		List<Encheres> resultat = new ArrayList();
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = null;
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			if(noCate.equals("all"))
			{
				ps = cnx.prepareStatement(SELECT_SEARCH_ALL);

				// 3e etape : attribuer les parametres nécessaires à ma requête
				ps.setString(1, "%"+ nomArticle +"%");
			}
			else {
				ps = cnx.prepareStatement(SELECT_SEARCH);

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

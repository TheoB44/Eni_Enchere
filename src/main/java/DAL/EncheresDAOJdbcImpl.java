package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BO.Encheres;

public class EncheresDAOJdbcImpl implements EncheresDAO {

	private static final String SELECT_ALL = "SELECT E.date_enchere, E.montant_enchere, A.nom_article, U.pseudo FROM ENCHERES"
			+ " E LEFT JOIN ARTICLES_VENDUS A ON A.no_article = E.no_article"
			+ " LEFT JOIN UTILISATEURS U ON U.no_utilisateur = E.no_utilisateur;";
	
	
	@Override
	public Encheres SelectAll() {
		Encheres resultat = null;
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_CONNEXION);
		
			
			// 3e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				resultat = new Encheres();
				while (rs.next()) {
					resultat.setNo_utilisateurs(rs.getInt("no_utilisateur"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
}

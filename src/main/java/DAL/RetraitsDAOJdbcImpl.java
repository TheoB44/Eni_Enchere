package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BO.Retraits;

public class RetraitsDAOJdbcImpl implements RetraitsDAO {

private static final String SELECT_RETRAIT_BY_ID = "SELECT * FROM RETRAITS WHERE no_article = ?";

	
	@Override
	public Retraits selectRetraitById(int idArticle) {
		Retraits resultat = new Retraits();
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_RETRAIT_BY_ID);
		
			ps.setInt(1, idArticle);
			
			// 3e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while (rs.next()) {
					
					resultat.setCode_postal(rs.getString("code_postal"));
					resultat.setRue(rs.getString("rue"));
					resultat.setVille(rs.getString("ville"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	
	
}

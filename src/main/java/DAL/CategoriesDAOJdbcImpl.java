package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BO.Categories;

public class CategoriesDAOJdbcImpl implements CategoriesDAO {
	
	private static final String SELECT_ALL = "SELECT * FROM CATEGORIES";

	
	@Override
	public List<Categories> SelectAll() {
		List<Categories> resultat = new ArrayList();
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL);
		
			// 3e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				while (rs.next()) {
					Categories categorie = null;
					categorie = new Categories();
					categorie.setLibelle(rs.getString("libelle"));
					categorie.setNo_categorie(rs.getInt("no_categorie"));
					resultat.add(categorie);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
}

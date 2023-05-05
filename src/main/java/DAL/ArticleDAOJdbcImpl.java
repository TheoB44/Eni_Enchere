package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BO.Articles_Vendus;
import BO.Utilisateurs;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_enchere,date_fin_enchere,prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente,image) VALUES (?,?,?,?,?,?,?,?,?,?);";
	
	@Override
	public boolean insert(Articles_Vendus article) {
		
		boolean vretour= false;
		try (Connection cnx = ConnectionProvider.getConnection();) {

			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, article.getNom_article());
			ps.setString(2, article.getDescription());
			ps.setDate(3, (Date) article.getDate_debut_enchere()); 
			ps.setDate(4, (Date) article.getDate_fin_enchere());
			ps.setFloat(5, article.getPrix_initial());
			ps.setString(6, null);
			ps.setInt(7, article.getNo_utilisateur());
			ps.setInt(8, article.getNo_categorie());
			ps.setString(9, "CR");
			ps.setString(10, article.getImage());

			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				article.setNo_article(id);
			}
			vretour = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vretour;
	}


}

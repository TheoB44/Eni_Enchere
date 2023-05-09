package DAL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BO.Articles_Vendus;
import BO.Categories;
import BO.Utilisateurs;

public class ArticleDAOJdbcImpl implements ArticleDAO {

	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS(nom_article,description,date_debut_enchere,date_fin_enchere,prix_initial,prix_vente,no_utilisateur,no_categorie,etat_vente,image) VALUES (?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_ARTICLE_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article = ?";
	private static final String SELECT_ARTICLE_ALL_BY_ID = "SELECT A.nom_article, A.description, C.libelle, A.no_utilisateur, A.image, A.etat_vente, A.prix_vente, A.prix_initial, A.date_debut_enchere, A.date_fin_enchere FROM ARTICLES_VENDUS A"
			+ " LEFT JOIN CATEGORIES C ON A.no_categorie = C.no_categorie"
			+ " WHERE no_article = ?";
	
	public Articles_Vendus getArticleByIdAll(int idArticle)
	{
		Articles_Vendus resultat = null;
		try (Connection cnx = ConnectionProvider.getConnection();) {
		
		PreparedStatement ps = cnx.prepareStatement(SELECT_ARTICLE_ALL_BY_ID);

			ps.setInt(1, idArticle);
			
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				resultat = new Articles_Vendus();
				while (rs.next()) {
					Categories cate = new Categories();
					cate.setLibelle(rs.getString("libelle"));
					resultat.setCategorie(cate);
					resultat.setNo_article(idArticle);
					resultat.setNom_article(rs.getString("nom_article"));
					resultat.setDescription(rs.getString("description"));
					resultat.setDate_debut_enchere(rs.getDate("date_debut_enchere"));
					resultat.setDate_fin_enchere(rs.getDate("date_fin_enchere"));
					resultat.setPrix_initial(rs.getFloat("prix_initial"));
					resultat.setPrix_vente(rs.getFloat("prix_vente"));
					resultat.setEtat_vente(rs.getString("etat_vente"));
					resultat.setImage(rs.getString("image"));
					resultat.setNo_utilisateur(rs.getInt("no_utilisateur"));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	public Articles_Vendus getArticleById(int idArticle)
	{
		Articles_Vendus resultat = null;
		try (Connection cnx = ConnectionProvider.getConnection();) {
		
		PreparedStatement ps = cnx.prepareStatement(SELECT_ARTICLE_BY_ID);

			ps.setInt(1, idArticle);
			
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				resultat = new Articles_Vendus();
				while (rs.next()) {
					resultat.setNo_article(idArticle);
					resultat.setNo_categorie(rs.getInt("no_categorie"));
					resultat.setNom_article(rs.getString("nom_article"));
					resultat.setDescription(rs.getString("description"));
					resultat.setDate_debut_enchere(rs.getDate("date_debut_enchere"));
					resultat.setDate_fin_enchere(rs.getDate("date_fin_enchere"));
					resultat.setPrix_initial(rs.getFloat("prix_initial"));
					resultat.setPrix_vente(rs.getFloat("prix_vente"));
					resultat.setEtat_vente(rs.getString("etat_vente"));
					resultat.setImage(rs.getString("image"));
					resultat.setNo_utilisateur(rs.getInt("no_utilisateur"));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	
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
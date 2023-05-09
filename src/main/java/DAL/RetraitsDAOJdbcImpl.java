package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BO.Retraits;

public class RetraitsDAOJdbcImpl implements RetraitsDAO {

private static final String SELECT_RETRAIT_BY_ID = "SELECT * FROM RETRAITS WHERE no_article = ?";
private static final String INSERT = "INSERT INTO RETRAITS VALUES(?,?,?,?);";
private static final String UPDATE = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?;";
private static final String DELETE = "DELETE FROM RETRAITS WHERE no_article = ?;";



public boolean delete(Retraits retrait)
{
boolean vretour = false;
	
	try (Connection cnx = ConnectionProvider.getConnection();) {
		cnx.setAutoCommit(false);
		PreparedStatement ps = cnx.prepareStatement(DELETE);

		ps.setInt(1, retrait.getarticle().getNo_article());
		
		ps.executeUpdate();
		cnx.commit();
		vretour = true;
	}catch (Exception e) {
		e.printStackTrace();
	}

	return vretour;
}

public  boolean update(Retraits retrait)
{
boolean vretour = true;
	
	try (Connection cnx = ConnectionProvider.getConnection();) {
		PreparedStatement ps = cnx.prepareStatement(UPDATE);

		ps.setString(1, retrait.getRue());
		ps.setString(2, retrait.getCode_postal());
		ps.setString(3, retrait.getVille());
		ps.setInt(4, retrait.getarticle().getNo_article());
		
		ps.executeUpdate();
	}catch (Exception e) {
		e.printStackTrace();
		vretour = false;
	}

	return vretour;
}


public boolean insert(Retraits retrait) {
	boolean vretour = false;
	
	try (Connection cnx = ConnectionProvider.getConnection();) {
		PreparedStatement ps = cnx.prepareStatement(INSERT);

		ps.setInt(1, retrait.getarticle().getNo_article());
		ps.setString(2, retrait.getRue());
		ps.setString(3, retrait.getCode_postal());
		ps.setString(4, retrait.getVille());
		
		ps.executeUpdate();
		vretour = true;
	}catch (Exception e) {
		e.printStackTrace();
	}

	return vretour;
}



	
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

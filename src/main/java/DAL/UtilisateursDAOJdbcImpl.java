package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BO.Utilisateurs;
import DAL.UtilisateursDAO;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {
	
	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	private static final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?;";

	
	@Override
	public Utilisateurs selectById(int id) {
		Utilisateurs resultat = null;
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_BY_ID);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setInt(1, id);
			
			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			resultat = new Utilisateurs();
			while (rs.next()) {
				resultat.setNo_utilisateurs(rs.getInt("no_utilisateur"));
				resultat.setAdministrateur(rs.getBoolean(""));
				resultat.setCode_postal(rs.getString(""));
				resultat.setCredit(rs.getInt(""));
				resultat.setEmail(rs.getString(""));
				resultat.setMot_de_passe(rs.getString(""));
				resultat.setNo_utilisateurs(rs.getInt(""));
				resultat.setNom(rs.getString(""));
				resultat.setPrenom(rs.getString(""));
				resultat.setPseudo(rs.getString(""));
				resultat.setRue(rs.getString(""));
				resultat.setTelephone(rs.getString(""));
				resultat.setVille(rs.getString(""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	/*
	@Override
	public void insert(Liste liste) {
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps =
					cnx.prepareStatement(INSERT,
										PreparedStatement.RETURN_GENERATED_KEYS);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setString(1, liste.getNom());
			
			// 4e etape : execution de la requete et interpretation des resultats
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				liste.setId(id);
			}
			
			insertArticle(liste);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*/
	
}

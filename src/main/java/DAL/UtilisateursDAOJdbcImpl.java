package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BO.Utilisateurs;
import DAL.UtilisateursDAO;
import DAL.ConnectionProvider;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {
	
	private static final String SELECT_CONNEXION = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?;";
	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	private static final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?;";

	@Override
	public Utilisateurs Connexion(String identifiant, String mdp) {
		Utilisateurs resultat = null;
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_CONNEXION);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setString(1, identifiant);
			ps.setString(2, mdp);
			
			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			if(rs != null) {
				resultat = new Utilisateurs();
				while (rs.next()) {
					resultat.setNo_utilisateurs(rs.getInt("no_utilisateur"));
					resultat.setPseudo(rs.getString("pseudo"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
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
				resultat.setAdministrateur(rs.getBoolean("administrateur"));
				resultat.setCode_postal(rs.getString("code_postal"));
				resultat.setCredit(rs.getInt("credit"));
				resultat.setEmail(rs.getString("email"));
				resultat.setMot_de_passe(rs.getString("mot_de_passe"));
				resultat.setNom(rs.getString("nom"));
				resultat.setPrenom(rs.getString("prenom"));
				resultat.setPseudo(rs.getString("pseudo"));
				resultat.setRue(rs.getString("rue"));
				resultat.setTelephone(rs.getString("telephone"));
				resultat.setVille(rs.getString("ville"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public void insert(Utilisateurs util) {
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps =
					cnx.prepareStatement(INSERT,
										PreparedStatement.RETURN_GENERATED_KEYS);
			
			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setString(1, util.getNom());
			
			// 4e etape : execution de la requete et interpretation des resultats
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				util.setNo_utilisateurs(id);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(int no_util) {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(DELETE);
			ps.setInt(1, no_util);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

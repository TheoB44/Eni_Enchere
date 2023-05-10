package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BO.Utilisateurs;
import DAL.UtilisateursDAO;
import DAL.ConnectionProvider;

public class UtilisateursDAOJdbcImpl implements UtilisateursDAO {

	private static final String SELECT_CONNEXION = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?;";
	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?;";
	private static final String INSERT = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String DELETEUTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?;";
	private static final String DELETEARTICLE = "DELETE FROM ARTICLES_VENDUS WHERE no_utilisateur=?;";
	private static final String DELETEENCHERE = "DELETE FROM ENCHERES WHERE no_article = ?;";
	private static final String DELETERETRAITS = "DELETE FROM RETRAITS WHERE no_article = ?;";
	private static final String UPDTATE = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ? WHERE no_utilisateur=?;";
	private static final String SELECT_ARTICLE_UTILISATEUR = "SELECT no_article FROM ARTICLES_VENDUS WHERE no_utilisateur=?";
	private static final String SELECT_TEST_PSEUDO_MAIL_EXIST = "SELECT no_utilisateur FROM UTILISATEURS WHERE pseudo = ? or email = ?";
	private static final String SELECT_ADRESSE_UTILISATEUR = "SELECT rue, code_postal, ville FROM UTILISATEURS WHERE no_utilisateur = ?";
	private static final String SELECT_ADMINISTRATEUR = "SELECT administrateur FROM UTILISATEURS WHERE no_utilisateur = ? ;";
	private static final String SELECT_ALL_UTILISATEUR = "SELECT * FROM UTILISATEURS;";
	
	public boolean IsAdmin(int id)
	{
		boolean resultat = false;
		try (Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement ps = cnx.prepareStatement(SELECT_ADMINISTRATEUR);

				ps.setInt(1, id);
				
				ResultSet rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						boolean admin = rs.getBoolean("administrateur");
						
						if(admin)
						{
							resultat = true;
						}
					}
				}
			}catch (Exception e) {
				e.getMessage();
			}
			return resultat;
	}
	
	public List<Utilisateurs> selectAll()
	{
		List<Utilisateurs> resultat = new ArrayList<Utilisateurs>();
		Utilisateurs util = null;
		// 1e etape : ouvrir la connexion a la bdd
		try (Connection cnx = ConnectionProvider.getConnection();) {
			// 2e etape : preparer la requete SQL qu'on souhaite executer
			PreparedStatement ps = cnx.prepareStatement(SELECT_ALL_UTILISATEUR);

			// 4e etape : execution de la requete et interpretation des resultats
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				util = new Utilisateurs();
				util.setNo_utilisateurs(rs.getInt("no_utilisateur"));
				util.setAdministrateur(rs.getBoolean("administrateur"));
				util.setCode_postal(rs.getString("code_postal"));
				util.setCredit(rs.getInt("credit"));
				util.setEmail(rs.getString("email"));
				util.setMot_de_passe(rs.getString("mot_de_passe"));
				util.setNom(rs.getString("nom"));
				util.setPrenom(rs.getString("prenom"));
				util.setPseudo(rs.getString("pseudo"));
				util.setRue(rs.getString("rue"));
				util.setTelephone(rs.getString("telephone"));
				util.setVille(rs.getString("ville"));
				resultat.add(util);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
	
	
	public Utilisateurs getAdressById(int idUtil)
	{
		Utilisateurs resultat = null;
		try (Connection cnx = ConnectionProvider.getConnection();) {
		
		PreparedStatement ps = cnx.prepareStatement(SELECT_ADRESSE_UTILISATEUR);

			ps.setInt(1, idUtil);
			
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				resultat = new Utilisateurs();
				while (rs.next()) {
					resultat.setRue(rs.getString("rue"));
					resultat.setVille(rs.getString("ville"));
					resultat.setCode_postal(rs.getString("code_postal"));
				}
			}
		}catch (Exception e) {
			
		}
		return resultat;
	}
	
	
	
	
	
	
	
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
			if (rs != null) {
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
			PreparedStatement ps = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

			// 3e etape : attribuer les parametres nécessaires à ma requête
			ps.setString(1, util.getPseudo());
			ps.setString(2, util.getNom());
			ps.setString(3, util.getPrenom());
			ps.setString(4, util.getEmail());
			ps.setString(5, util.getTelephone());
			ps.setString(6, util.getRue());
			ps.setString(7, util.getCode_postal());
			ps.setString(8, util.getVille());
			ps.setString(9, util.getMot_de_passe());
			ps.setInt(10, 100);
			ps.setBoolean(11, util.isAdministrateur());

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
		deleteEnchere(no_util);
		deleteArticles(no_util);
		deleteUtil(no_util);
	}

	private void deleteEnchere(int no_util) {
		try (Connection cnx = ConnectionProvider.getConnection();) {

			cnx.setAutoCommit(false);

			PreparedStatement ps = cnx.prepareStatement(SELECT_ARTICLE_UTILISATEUR);

			ps.setInt(1, no_util);

			ResultSet rs = ps.executeQuery();
			List<Integer> resultat = new ArrayList<Integer>();
			int i = 1;
			while (rs.next()) {
				resultat.add(rs.getInt(i));
				i++;
			}

			for (Integer integer : resultat) {
				PreparedStatement ps2 = cnx.prepareStatement(DELETEENCHERE);
				ps2.setInt(1, integer.intValue());
				ps2.executeUpdate();

				cnx.commit();

				PreparedStatement ps3 = cnx.prepareStatement(DELETERETRAITS);
				ps2.setInt(1, integer.intValue());
				ps2.executeUpdate();

				cnx.commit();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteArticles(int no_util) {
		try (Connection cnx = ConnectionProvider.getConnection();) {

			cnx.setAutoCommit(false);

			PreparedStatement ps = cnx.prepareStatement(DELETEARTICLE);
			ps.setInt(1, no_util);
			ps.executeUpdate();

			cnx.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteUtil(int no_util) {
		try (Connection cnx = ConnectionProvider.getConnection();) {

			PreparedStatement ps = cnx.prepareStatement(DELETEUTILISATEUR);
			ps.setInt(1, no_util);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Utilisateurs util) {

		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(UPDTATE);

			// element à modifier
			ps.setString(1, util.getPseudo());
			ps.setString(2, util.getNom());
			ps.setString(3, util.getPrenom());
			ps.setString(4, util.getEmail());
			ps.setString(5, util.getTelephone());
			ps.setString(6, util.getRue());
			ps.setString(7, util.getCode_postal());
			ps.setString(8, util.getVille());
			ps.setString(9, util.getMot_de_passe());
			// Condition
			ps.setInt(10, util.getNo_utilisateurs());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean testPseudoAndMail(String pseudo, String mail) {
		boolean vretour = false;
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement ps = cnx.prepareStatement(SELECT_TEST_PSEUDO_MAIL_EXIST);

			ps.setString(1, pseudo);
			ps.setString(2, mail);

			ResultSet rs = ps.executeQuery();
			if (rs != null && rs.next()) {
				vretour = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vretour;
	}
}

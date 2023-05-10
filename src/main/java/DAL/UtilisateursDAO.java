package DAL;

import java.util.List;

import BO.Utilisateurs;

public interface UtilisateursDAO {
	Utilisateurs selectById(int id);
	Utilisateurs Connexion(String indentifiant, String mdp);
	void insert(Utilisateurs util);
	void delete(int id);
	void update(Utilisateurs util);
	boolean testPseudoAndMail(String pseudo, String mail);
	Utilisateurs getAdressById(int idUtil);
	boolean IsAdmin(int id);
	List<Utilisateurs> selectAll();
}

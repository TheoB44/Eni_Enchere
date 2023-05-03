package BLL;

import DAL.DAOFactory;
import DAL.EncheresDAO;

public class EncheresBLL {

	private EncheresDAO dao;

	public UtilisateurBLL() {
		dao = DAOFactory.getUtilDAO();
	}
	
	public Utilisateurs connexion(String id, String mdp) {
		return dao.Connexion(id, mdp);
	}
	
}

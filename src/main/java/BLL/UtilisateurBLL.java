package BLL;

import java.util.List;

import BO.Utilisateurs;
import DAL.DAOFactory;
import DAL.UtilisateursDAO;

public class UtilisateurBLL {

	private UtilisateursDAO dao;

	public UtilisateurBLL() {
		dao = DAOFactory.getUtilDAO();
	}
	
	public Utilisateurs connexion(String id, String mdp) {
		return dao.Connexion(id, mdp);
	}
	
	public Utilisateurs selectById(int id)
	{
		return dao.selectById(id);
	}

}

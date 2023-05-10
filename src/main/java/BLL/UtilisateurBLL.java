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
	
	public void insert(Utilisateurs util)
	{
		dao.insert(util);
	}
	
	public void update(Utilisateurs util)
	{
		dao.update(util);
	}
	
	public void delete(int idUtil)
	{
		dao.delete(idUtil);
	}
	
	public boolean testPseudoAndMail(String pseudo, String mail)
	{
		return dao.testPseudoAndMail(pseudo, mail);
	}
	
	public Utilisateurs getAdressById(int IdUtil) {
		return dao.getAdressById(IdUtil);
	}
	
	public boolean IsAdmin(int id)
	{
		return dao.IsAdmin(id);
	}
	
	public List<Utilisateurs> selectAll()
	{
		return dao.selectAll();
	}
	
	public int getCredit(int idUtil)
	{
		return dao.getCredit(idUtil);
	}

}

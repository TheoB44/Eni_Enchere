package BLL;

import BO.Retraits;
import DAL.DAOFactory;
import DAL.RetraitsDAO;

public class RetraitsBLL {
	private RetraitsDAO dao;

	public RetraitsBLL() {
		dao = DAOFactory.getRetraitsDAO();
	}
	
	public Retraits selectRetraitById(int idArticle)
	{
		return dao.selectRetraitById(idArticle);
	}
	
	public boolean insert(Retraits retrait)
	{
		return dao.insert(retrait);
	}
	
	public boolean update(Retraits retrait)
	{
		return dao.update(retrait);
	}
	
	public boolean delete(Retraits retrait) 
	{
		return dao.delete(retrait);
	}
}

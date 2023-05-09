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
}

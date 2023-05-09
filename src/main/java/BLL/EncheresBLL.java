package BLL;

import java.util.List;

import BO.Encheres;
import DAL.DAOFactory;
import DAL.EncheresDAO;

public class EncheresBLL {

	private EncheresDAO dao;

	public EncheresBLL() {
		dao = DAOFactory.getEncheresDAO();
	}
	
	public List<Encheres> listeEncheres() {
		return dao.SelectAll();
	}
	
	public Encheres topEnchere(int noArticle) {
		return dao.topEnchere(noArticle);
	}
	
	public List<Encheres> listeEncheresSearch(String nomArticle, String noCate) {
		return dao.Search(nomArticle, noCate);
	}
	
	public List<Encheres> listeEncheresSearchConnected(String nomArticle, String noCate, int noUtil, List<String> etatVente, String type) {
		return dao.SearchConnected(nomArticle, noCate, noUtil, etatVente, type);
	}
	
}

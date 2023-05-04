package BLL;

import java.util.List;

import BO.Categories;
import DAL.CategoriesDAO;
import DAL.DAOFactory;

public class CategorieBLL {

	private CategoriesDAO dao;

	public CategorieBLL() {
		dao = DAOFactory.getCategoriesDAO();
	}
	
	public List<Categories> listeCategories() {
		return dao.SelectAll();
	}
	
}

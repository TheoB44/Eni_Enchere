package DAL;

import DAL.UtilisateursDAO;
import DAL.UtilisateursDAOJdbcImpl;

public abstract class DAOFactory {
	private static UtilisateursDAO utilDAO;
	private static EncheresDAO encheresDAO;
	private static CategoriesDAO categoriesDAO;
	
	public static UtilisateursDAO getUtilDAO() {
		if (utilDAO == null) {
			utilDAO = new UtilisateursDAOJdbcImpl();
		}
		return utilDAO;
	}
	
	public static EncheresDAO getEncheresDAO() {
		if (encheresDAO == null) {
			encheresDAO = new EncheresDAOJdbcImpl();
		}
		return encheresDAO;
	}
	
	public static CategoriesDAO getCategoriesDAO() {
		if (categoriesDAO == null) {
			categoriesDAO = new CategoriesDAOJdbcImpl();
		}
		return categoriesDAO;
	}
}

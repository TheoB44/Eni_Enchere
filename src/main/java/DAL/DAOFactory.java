package DAL;

import DAL.UtilisateursDAO;
import DAL.UtilisateursDAOJdbcImpl;

public abstract class DAOFactory {
	private static UtilisateursDAO utilDAO;
	private static RetraitsDAO retraitsDAO;
	private static EncheresDAO encheresDAO;
	private static CategoriesDAO categoriesDAO;
	private static ArticleDAO articleDAO;
	
	public static UtilisateursDAO getUtilDAO() {
		if (utilDAO == null) {
			utilDAO = new UtilisateursDAOJdbcImpl();
		}
		return utilDAO;
	}
	
	public static RetraitsDAO getRetraitsDAO() {
		if (retraitsDAO == null) {
			retraitsDAO = new RetraitsDAOJdbcImpl();
		}
		return retraitsDAO;
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
	
	public static ArticleDAO getArticleDAO() {
		if (articleDAO == null) {
			articleDAO = new ArticleDAOJdbcImpl();
		}
		return articleDAO;
	}
	
	
}

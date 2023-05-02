package DAL;

import DAL.UtilisateursDAO;
import DAL.UtilisateursDAOJdbcImpl;

public abstract class DAOFactory {
	private static UtilisateursDAO listeDAO;
	
	public static UtilisateursDAO getListeDAO() {
		if (listeDAO == null) {
			listeDAO = new UtilisateursDAOJdbcImpl();
		}
		return listeDAO;
	}
}

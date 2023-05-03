package DAL;

import DAL.UtilisateursDAO;
import DAL.UtilisateursDAOJdbcImpl;

public abstract class DAOFactory {
	private static UtilisateursDAO utilDAO;
	
	public static UtilisateursDAO getUtilDAO() {
		if (utilDAO == null) {
			utilDAO = new UtilisateursDAOJdbcImpl();
		}
		return utilDAO;
	}
}

package DAL;

import DAL.UtilisateursDAO;
import DAL.UtilisateursDAOJdbcImpl;

public abstract class DAOFactory {
	private static UtilisateursDAO utilDAO;
	private static EncheresDAO encheresDAO;
	
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
}

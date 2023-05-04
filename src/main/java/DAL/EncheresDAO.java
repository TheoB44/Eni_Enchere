package DAL;

import java.util.List;

import BO.Encheres;

public interface EncheresDAO {
	
	List<Encheres> SelectAll();
	
	List<Encheres> Search(String nomArticle, String noCate);

}

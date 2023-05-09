package DAL;

import java.util.List;

import BO.Encheres;

public interface EncheresDAO {
	
	List<Encheres> SelectAll();
	
	List<Encheres> Search(String nomArticle, String noCate);
	
	List<Encheres> SearchConnected(String nomArticle, String noCate, int noUtil, List<String> etatVente, String type);
	
	Encheres topEnchere(int noArticle);


}

package DAL;

import BO.Retraits;

public interface RetraitsDAO {
	
	Retraits selectRetraitById(int id);

	boolean insert(Retraits retrait);
	
	 boolean update(Retraits retrait);
	 
	 boolean delete (Retraits retrait);
}

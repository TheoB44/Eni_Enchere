package DAL;

import java.util.List;

import BO.Utilisateurs;

public interface UtilisateursDAO {
	Utilisateurs selectById(int id);
	void insert(Utilisateurs liste);
	void delete(int id);
}

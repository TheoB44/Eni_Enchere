package DAL;

import BO.Articles_Vendus;

public interface ArticleDAO {
	
	boolean insert(Articles_Vendus article);
	
	Articles_Vendus getArticleById(int idArticle);
	
	Articles_Vendus getArticleByIdAll(int idArticle);

	boolean update(Articles_Vendus article);
	
	boolean delete(int idArticle);
}

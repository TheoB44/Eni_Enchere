package DAL;

import BO.Articles_Vendus;

public interface ArticleDAO {
	
	boolean insert(Articles_Vendus article);
	
	boolean update(Articles_Vendus article);
	
	Articles_Vendus getArticleById(int idArticle);

	boolean delete(int idArticle);
}

package DAL;

import BO.Articles_Vendus;

public interface ArticleDAO {
	
	boolean insert(Articles_Vendus article);
	
	Articles_Vendus getArticleById(int idArticle);

}

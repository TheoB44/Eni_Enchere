package BLL;

import BO.Articles_Vendus;
import DAL.ArticleDAO;
import DAL.DAOFactory;
import DAL.UtilisateursDAO;

public class ArticleBLL {

	private ArticleDAO dao;

	public ArticleBLL() {
		dao = DAOFactory.getArticleDAO();
	}
	
	
	
	public boolean insert(Articles_Vendus article)
	{
		return dao.insert(article);
	}
	
	public Articles_Vendus getArticleById(int idArticle)
	{
		return dao.getArticleById(idArticle);
	}
	
	
}

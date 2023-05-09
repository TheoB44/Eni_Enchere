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
	

	public boolean update(Articles_Vendus article)
	{
		return dao.update(article);
	}
	

	public Articles_Vendus getArticleById(int idArticle)
	{
		return dao.getArticleById(idArticle);
	}
	
	public Articles_Vendus getArticleByIdAll(int idArticle)
	{
		return dao.getArticleByIdAll(idArticle);
	}
	
	
}
	public boolean delete(int idArticle)
	{
		return dao.delete(idArticle);
	}
	
	
}

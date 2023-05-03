package BO;

public class Retraits {

	private String rue;
	private String code_postal;
	private String ville;
	private Articles_Vendus article;
	
	public Retraits(Articles_Vendus article, String rue, String code_postal, String ville) {
		super();
		this.article = article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public Articles_Vendus getarticle() {
		return article;
	}

	public String getRue() {
		return rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public String getVille() {
		return ville;
	}
	
	
	
}

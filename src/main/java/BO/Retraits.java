package BO;

public class Retraits {

	private int no_article;
	private String rue;
	private String code_postal;
	private String ville;
	
	public Retraits(int no_article, String rue, String code_postal, String ville) {
		super();
		this.no_article = no_article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public int getNo_article() {
		return no_article;
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

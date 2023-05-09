<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="fragments/meta.html"></jsp:include>
</head>
<body>

	<h1>ENI-Enchères</h1>

	<img></img>


	<h1>Nouvelle Vente</h1>
	
	
	<c:if test="${not IsAlreadyCreated}">
	
	<div>
		<form action = "NouvelleVente" method = post>
			<p>Article :</p>
			<input type="text" id="nomArticle" name="nomArticle"></input>
	
			<p>Description :</p>
			<textarea id="description" name="description"></textarea>
	
			<p>Catégorie</p>
			<div>
			 <select name="categorieEnchere" id="categorieEnchere">
					<c:forEach var="current" items="${listeCategories}">
						<option value="${current.no_categorie}">${current.libelle}</option>
					</c:forEach>
			</select>
			</div>
	
			<p>Photo de l'article</p>
			<button>Uploader</button>
	
			<p>Mise à prix :</p>
			<input id="prix" name="prix" type="number"></input>
	
			<p>Début de l'enchère :</p>
			<input type="date" id="dateDebut" name="dateDebut">
	
			<p>Fin de l'enchère :</p>
			<input type="date" id="dateFin" name="dateFin">
	
			<div id="retrait" >
				<p>Rue :</p>
				<input type="text" name="rue"id="rue" value="${Adresse.rue}"> </input>
	
				<p>Code Postal :</p>
				<input type="text" name="code_postal"id="code_postal" value="${Adresse.code_postal}"></input>
	
				<p>Ville :</p>
				<input type="text" name="ville"id="ville" value="${Adresse.ville}"></input>
			</div>
	
			<button>Enregistrer</button>
			<button onclick = "window.location.href = '${pageContext.request.contextPath}/Accueil'">Annuler</button>
			
		</form>
	</div>
	
	</c:if>

	<c:if test="${IsAlreadyCreated}">
	
	<div>
		<form action = "NouvelleVente" method = post>
			<p>Article :</p>
			<input type="text" id="nomArticle" name="nomArticle" value="${article.nom_article}"></input>
	
			<p>Description :</p>
			<textarea id="description" name="description" value="${article.description}"></textarea>
	
			<p>Catégorie</p>
			<div>
			 <select name="categorieEnchere" id="categorieEnchere">
					<c:forEach var="current" items="${listeCategories}">
						<option value="${current.no_categorie}">${current.libelle}</option>
					</c:forEach>
			</select>
			</div>
			
			<input type = "hidden" value="${article.no_categorie}" id="Categorie"></input>
			
			<script>
				var idCategorie = document.getElementById("Categorie").value;
			
				
				var liste = document.getElementById("categorieEnchere");
				
				for(let i = 0; i < liste.options.length;i++)
				{
					categorie = liste.options[i];
					if (categorie.value === idCategorie) 
					  {
					    categorie.selected = true;
					  }
				}
			</script>
			
			
	
			<p>Photo de l'article</p>
			<button>Uploader</button>
	
			<p>Mise à prix :</p>
			<input id="prix" name="prix" type="number" value="${article.prix_initial}"></input>
	
			<p>Début de l'enchère :</p>
			<input type="date" id="dateDebut" name="dateDebut" value="${article.date_debut_enchere}">
	
			<p>Fin de l'enchère :</p>
			<input type="date" id="dateFin" name="dateFin" value="${article.date_fin_enchere}">
	
			<div id="retrait" >
				<p>Rue :</p>
				<input type="text" name="rue"id="rue" value="${Adresse.rue}" ></input>
	
				<p>Code Postal :</p>
				<input type="text" name="code_postal"id="code_postal" value="${Adresse.code_postal}"></input>
	
				<p>Ville :</p>
				<input type="text" name="ville"id="ville" value="${Adresse.ville}"></input>
			</div>
			
			<input type="hidden" id="idArticle" name="idArticle" value="${article.no_article}"></input>
	
			<button name="Modifier" id="Modifier" value="true">Enregistrer</button>
			<button onclick = "window.location.href = '${pageContext.request.contextPath}/Accueil'">Annuler</button>
				
			<c:if test="${(article.etat_vente =='CR')}">
				<button name="Supprimer" id="Supprimer" value="true">Annuler la vente</button>
			</c:if>
		</form>
		

	</div>
	
	</c:if>

</body>
</html>
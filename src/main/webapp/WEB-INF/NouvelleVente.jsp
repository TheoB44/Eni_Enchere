<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="fragments/meta.html"></jsp:include>
<jsp:include page="fragments/HeaderConnected.jsp"></jsp:include>
</head>
<body>

	<img></img>


	<h1 style="text-align:center;">Nouvelle Vente</h1>
	
	
	<c:if test="${not IsAlreadyCreated}">
	
	<div style="text-align:center;">
		<form action = "NouvelleVente" method = post enctype="multipart/form-data">
			<p>Article :</p>
			<input type="text" id="nomArticle" name="nomArticle"></input>
	
			<br>
	
			<p>Description :</p>
			<textarea id="description" name="description"></textarea>
	
			<br>
	
			<p>Catégorie</p>
			<div>
			 <select name="categorieEnchere" id="categorieEnchere">
					<c:forEach var="current" items="${listeCategories}">
						<option value="${current.no_categorie}">${current.libelle}</option>
					</c:forEach>
			</select>
			</div>
			
			<br>
	
			<br>
			
			<p>Image :</p>
			<input type="file" id="imageArticle" name="imageArticle" />
			
			<br>
	
			<p>Mise à prix :</p>
			<input id="prix" name="prix" type="number"></input>
	
			<br>
			
			<p>Début de l'enchère :</p>
			<input type="date" id="dateDebut" name="dateDebut">
			
			<br>
	
			<p>Fin de l'enchère :</p>
			<input type="date" id="dateFin" name="dateFin">
			
			<br>
	
			<div id="retrait" >
				<p>Rue :</p>
				<input type="text" name="rue"id="rue" value="${Adresse.rue}"> </input>
				
				<br>
	
				<p>Code Postal :</p>
				<input type="text" name="code_postal"id="code_postal" value="${Adresse.code_postal}"></input>
	
				<br>
				
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
			<textarea id="description" name="description">${article.description}</textarea>
	
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
	
			<p>Mise à prix :</p>
			<input id="prix" name="prix" type="number" value="${article.prix_initial}"></input>
	
			<p>Début de l'enchère :</p>
			<input type="date" id="dateDebut" name="dateDebut" value="${article.date_debut_enchere}">
	
			<p>Fin de l'enchère :</p>
			<input type="date" id="dateFin" name="dateFin" value="${article.date_fin_enchere}">
	
			<div id="retrait" >
				<p>Rue :</p>
				<input type="text" name="rue"id="rue" value="${retrait.rue}" ></input>
	
				<p>Code Postal :</p>
				<input type="text" name="code_postal"id="code_postal" value="${retrait.code_postal}"></input>
	
				<p>Ville :</p>
				<input type="text" name="ville"id="ville" value="${retrait.ville}"></input>
			</div>
			
			<input type="hidden" id="idArticle" name="idArticle" value="${article.no_article}"></input>
	
			<c:if test="${(article.etat_vente =='CR')}">
				<button name="Modifier" id="Modifier" value="true">Enregistrer</button>
			</c:if>
			<c:if test="${not (article.etat_vente =='CR')}">
			Vous ne pouvez plus modifier cette vente !
			</c:if>
			
			<button onclick = "window.location.href = '${pageContext.request.contextPath}/Accueil'">Annuler</button>
				
			<c:if test="${(article.etat_vente =='CR')}">
				<button name="Supprimer" id="Supprimer" value="true">Annuler la vente</button>
			</c:if>
		</form>
		

	</div>
	
	</c:if>

</body>
</html>
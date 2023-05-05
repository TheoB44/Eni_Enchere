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
		<!-- condition pour afficher ou non le bouton annuler -->
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/ListeEncheres'">Annuler la vente</button>

	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="fragments/meta.html"></jsp:include>
</head>
<body>

	<h1>ENI-Ench�res</h1>

	<img></img>


	<h1>Nouvelle Vente</h1>
	<div>

		<p>Article :</p>
		<input type="text"></input>

		<p>Description :</p>
		<textarea id="description"></textarea>

		<p>Cat�gorie</p>
		<select id="categorie"></select>

		<p>Photo de l'article</p>
		<button>Uploader</button>

		<p>Mise � prix :</p>
		<input id="prix" type="number"></input>

		<p>D�but de l'ench�re :</p>
		<input type="date" id="dateDebut" name="dateDebut">

		<p>Fin de l'ench�re :</p>
		<input type="date" id="dateFin" name="dateFin">

		<div id="retrait">
			<p>Rue :</p>
			<input type="text"></input>

			<p>Code Postal :</p>
			<input type="text"></input>

			<p>Ville :</p>
			<input type="text"></input>
		</div>

		<button onclick = "window.location.href = '${pageContext.request.contextPath}/ListeEncheres'">Enregistrer</button>
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/ListeEncheres'">Annuler</button>
		<button onclick = "window.location.href = '${pageContext.request.contextPath}/ListeEncheres'">Annuler la vente</button>

	</div>

</body>
</html>
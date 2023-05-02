<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>ENI-Enchères</h1>

	<img></img>

	<h1>Enchérir</h1>

	<div>

		<p>Article :</p>
		<input type="text"></input>

		<p>Description :</p>
		<textarea id="description"></textarea>

		<p>Catégorie</p>
		<select id="categorie"></select>

		<p>Photo de l'article</p>
		<button>Uploader</button>

		<p>Mise à prix :</p>
		<input id="prix" type="number"></input>

		<p>Début de l'enchère :</p>
		<input type="date" id="dateDebut" name="dateDebut">

		<p>Fin de l'enchère :</p>
		<input type="date" id="dateFin" name="dateFin">

		<div id="retrait">
			<p>Rue :</p>
			<input type="text"></input>

			<p>Code Postal :</p>
			<input type="text"></input>

			<p>Ville :</p>
			<input type="text"></input>
		</div>

		<button>Enregistrer</button>
		<button>Annuler</button>
		<button>Annuler la vente</button>

	</div>



</body>
</html>
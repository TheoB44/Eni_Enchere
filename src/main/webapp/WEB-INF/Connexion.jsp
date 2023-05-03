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
	<div id="connexion-container">

		<h1>ENI-Enchères</h1>
		<br>

		<form class="row justify-content-center mb-2" method="post" action="Connexion">

			<div name="connexion-identifiant" id="connexion-identifiant">
				<div id="connexion-divCo">
					Identifiant : <input type="text" name="connexion_identifiant"></input>
				</div>
				<br>
				<div id="connexion-divCo">
					Mot de passe : <input type="text" name="connexion_mdp"></input>
				</div>
			</div>

			<br> <br>

			<button name="connexion-btn" id="connexion-btn">Connexion</button>

			<div name="connexion-connexion" id="connexion-connexion">
				<input type="checkbox"></input>
				<p link="https://google.com">Mot de passe oublié</p>
			</div>

		</form>

		<button
			onclick="window.location.href = '${pageContext.request.contextPath}/Inscription'">Créer
			un compte</button>

	</div>

</body>
</html>

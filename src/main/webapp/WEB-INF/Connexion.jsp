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
	<br>

	<p>Identifiant :</p>
	<input type="text"></input>
	<br>
	<p>Mot de passe :</p>
	<input type="text"></input>
	<br>
	<button>Connexion</button>
	<input type="checkbox"></input>
	<p link="https://google.com">Mot de passe oubli�</p>

	<button onclick = "window.location.href = '${pageContext.request.contextPath}/Inscription'">Cr�er un compte</button>

</body>
</html>

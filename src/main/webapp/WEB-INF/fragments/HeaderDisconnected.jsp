<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<include page="fragments/meta.html"></include>

<div id="div-Header" name = "div-Header">

	<a href="Accueil"><image style ="width:100px;" src="$../../img/home.png" href="Accueil"></image></a>

	<div id="Inscription-connexion">
		<a href="${pageContext.request.contextPath}/Connexion">S'inscrire - Se connecter</a>
	</div>

</div>



</body>
</html>
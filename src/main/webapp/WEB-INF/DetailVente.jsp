<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<c:if test="${connected == true }">
<jsp:include page="fragments/HeaderConnected.jsp"></jsp:include>
</c:if>
<c:if test="${connected == false }">
<jsp:include page="fragments/HeaderDisconnected.jsp"></jsp:include>
</c:if>
<link href="styles/style.css" rel="stylesheet" type="text/css">
<title>Detail de la vente</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	
	<c:if test="${etatVente == 'EC' || etatVente == 'CR'}">
		<div id="Titre-Centre"><h1>Detail vente</h1></div>
	</c:if>
	
	<c:if test="${etatVente == 'VD' && acheteur == true}">
		<div id="Titre-Centre">Bravo ${topEnchere.utilisateur.pseudo}, Vous avez emporté la vente !</div>
	</c:if>
	
	<c:if test="${etatVente == 'VD' && acheteur == false}">
		<div id="Titre-Centre"> ${topEnchere.utilisateur.pseudo} a emporté la vente !</div>
	</c:if>
	
	
	
	
	<div id = "DetailVente-Image">
	<img></img>
	</div>
	
	<div id = "DetailVente-Info">
	
	
	<p class="card-text">${article.nom_article}</p>
	
	<br>
	<p class="card-text">Description :${article.description}</p>
	<br>
	
	<p class="card-text">Catégorie : ${article.categorie.libelle}</p>
	<br>
	<p class="card-text">Meilleure offre : ${topEnchere.montant_enchere} par ${topEnchere.utilisateur.pseudo}  </p>
	<br>
	<p class="card-text">Mise à prix : ${article.prix_initial}</p>
	<br>
	<p class="card-text">Fin de l'enchère :  ${article.date_fin_enchere}</p>
	
	<br>
	<p class="card-text">Retrait : ${retrait.rue} ${retrait.code_postal} ${retrait.ville} </p>
	<br>
	 Vendeur :<a name="idVendeur" id="idVendeur"
						href="${pageContext.request.contextPath}/MonProfil?idVendeur=${utilVendeur.no_utilisateurs}"
						class="card-text"> ${utilVendeur.pseudo}</a>
	<br>
	<br>
	
	<c:if test="${enchere.article.etat_vente == 'VD' && acheteur == true && connected == true }">
		<p class="card-text">Tel : ${utilVendeur.telephone}</p>
		<br>
	</c:if>
	
		<c:if test="${etatVente == 'EC' && connected == true }">
			<form method="post" action="DetailVente" name="DetailVente" id="DetailVente">
				<input type='hidden' name='idVendeur' id='idVendeur' value="${idVendeur}" />
				<input type='hidden' name='idArticle' id='idArticle' value="${idArticle}" />
				<input type='hidden' name='noArticle' id='noArticle' value="${article.no_article}" />
				<input type='hidden' name='previousEnchere' id='previousEnchere' value="${topEnchere.montant_enchere}" />
			
				<p>Ma proposition :</p> <input name='montantEnchere' id='montantEnchere' type ="number" min="${topEnchere.montant_enchere}"></input>     
			
				
				<button>Enchérir</button>
				
			</form>
	</c:if>
	
	
	
	
	</div>
	
	

</body>
</html>
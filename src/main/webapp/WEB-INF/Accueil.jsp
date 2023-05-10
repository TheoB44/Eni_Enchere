<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head onload="recupererCookie();">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Accueil</title>


<c:if test="${userConnected}">
<jsp:include page="fragments/HeaderConnected.jsp"></jsp:include>
</c:if>

<c:if test="${not userConnected}">
<jsp:include page="fragments/HeaderDisconnected.jsp"></jsp:include>
</c:if>

</head>
<body>
	
	

	<div id="Titre-Centre" align="center"><h1>Liste des Enchères</h1></div>

	<form style="padding-inline:20px; text-align:center;" class="justify-content-center" method="post" action="Accueil">
		<div id ="divFiltres">
			Filtres : <br>
			<div class="input-group">
				<input type="search" placeholder="Le nom de l'article contient"
					name="searchNomArticle" class="form-control"> <span class="input-group-append">
				</span>
			</div>
			<br> <br> Catégorie : <select name="categorieEnchere"
				id="categorieEnchere" class="form-select">
				<option value="all">Toutes</option>
				<c:forEach var="current" items="${listeCategories}">
					<option value="${current.no_categorie}">${current.libelle}</option>
				</c:forEach>
			</select>
		</div>

		<c:if test="${userConnected}">
			<input type="radio" name="achatVente" value="achat" checked="checked"> Achats</input>
			<div id="checkAchats">
				<input type="checkbox" id="enchereOuverte" name="enchereOuverte"
					value="enchereOuverte"> enchères ouvertes</input> <input
					type="checkbox" id="mesEncheres" name="mesEncheres"
					value="mesEncheres"> mes enchères</input> <input type="checkbox"
					id="enchereRemporte" name="enchereRemporte" value="enchereRemporte">mes
				enchères reportées</input>
			</div>

			<input type="radio" name="achatVente" value="vente"> Mes Ventes</input>
			<div id="checkVentes">
				<input type="checkbox" id="checkVenteEC" name="checkVenteEC"
					disabled value="checkVenteEC"> mes ventes en cours</input> <input
					type="checkbox" id="checkVenteDebute" name="checkVenteDebute"
					disabled value="checkVenteDebute"> ventes non débutées</input> <input
					type="checkbox" id="checkVenteTermine" name="checkVenteTermine"
					disabled value="checkVenteTermine"> ventes terminées</input>
			</div>
		</c:if>


		<script>
			var radio = document.getElementsByName('achatVente');

			radio[0].addEventListener('change', function() {
				document.getElementById("enchereOuverte").disabled = false;
				document.getElementById("mesEncheres").disabled = false;
				document.getElementById("enchereRemporte").disabled = false;

				document.getElementById("checkVenteEC").disabled = true;
				document.getElementById("checkVenteEC").checked = false;
				document.getElementById("checkVenteDebute").disabled = true;
				document.getElementById("checkVenteDebute").checked = false;
				document.getElementById("checkVenteTermine").disabled = true;
				document.getElementById("checkVenteTermine").checked = false;
			});

			radio[1].addEventListener('change', function() {
				document.getElementById("enchereOuverte").disabled = true;
				document.getElementById("enchereOuverte").checked = false;
				document.getElementById("mesEncheres").disabled = true;
				document.getElementById("mesEncheres").checked = false;
				document.getElementById("enchereRemporte").disabled = true;
				document.getElementById("enchereRemporte").checked = false;

				document.getElementById("checkVenteEC").disabled = false;
				document.getElementById("checkVenteDebute").disabled = false;
				document.getElementById("checkVenteTermine").disabled = false;
			});
		</script>

		<br>
		<div id="bouton">
			<button  class="btn btn-outline-dark">Rechercher</button>
		</div>
	</form>
	<br>

	<div class="row" id ="rowResult">

		<c:forEach var="current" items="${listeEncheres}">
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="data:image/jpeg;base64,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" alt="Card image cap">
				<div class="card-body">

					<h6 class="card-title">
						<a href="${pageContext.request.contextPath}/RedirectEnchere?idVendeur=${current.article.no_utilisateur}&idArticle=${current.article.no_article}">${current.article.nom_article}</a>
					</h6>

					<p class="card-text">Prix : ${current.montant_enchere} points</p>
					<p class="card-text">Fin de l'enchère :
						${current.article.date_fin_enchere}</p>
					Vendeur :<a name="idVendeur" id="idVendeur"
						href="${pageContext.request.contextPath}/MonProfil?idVendeur=${current.article.no_utilisateur}"
						class="card-text">${current.utilisateur.pseudo}</a>
				</div>
			</div>
		</c:forEach>

	</div>


</body>
</html>
<script>
var test = false;
function recupererCookie() {
    nom = nom + "=";
    var liste = document.cookie.split(';');
    var id = null;
    var mdp = null;
    for (var i = 0; i < liste.length; i++) {
        var c = liste[i];
        if(c.includes("user"))
       	{
        	var t = c.split('=');
       		id = t[1];
       	}
        	
        if(c.includes("pwd"))
       	{
        	var t = c.split('=');
       		mdp = t[1];
       	}
    }
    
    if(id != null && mdp != null)
    {
    	test = true;
    }
    test =  false;
}

</script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="fragments/meta.html"></jsp:include>
<title>Accueil</title>



<c:if test="${userConnected}">
	<jsp:include page="fragments/HeaderConnected.html"></jsp:include>
		<div id="ListeEnchere-Lien">
			<table id = "Table-Bouton-Connecter" name = "Table-Bouton-Connecter" align="right">
				<tr>
					<td>
						<form method="get" action="Encherir" name="Encherir" id="Encherir">
							<button>Ench�re</button>
						</form>
					</td>
					<td>
						<form method="get" action="NouvelleVente" name="NouvelleVente"
							id="NouvelleVente">
							<button>Vendre un article</button>
						</form>
					</td>
					<td>
						<form method="get" action="MonProfil" value="true" name="MyProfil"
							id="MyProfil">
							<button>Mon Profil</button>
							<input type="hidden" value="${Id_Utils}" name="IDUtilisateur"
								id="IDUtilisateur" />
						</form>
					</td>	
					<td>
						<form method="get" action="Deconnexion">
							<button>Deconnexion</button>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</c:if>

	<c:if test="${not userConnected}">
	<jsp:include page="fragments/HeaderDisconnected.html"></jsp:include>
		<div id="Inscription-connexion">
			<a href="${pageContext.request.contextPath}/Connexion">S'inscrire
				- Se connecter</a>
		</div>
	</c:if>
	
</head>
<body>
	<h1>ENI-Ench�res</h1>
	
	

	<div id="Titre-Centre" align="center">Liste des Ench�res</div>

	<form class="justify-content-center" method="post" action="Accueil">
		<div>
			Filtres : <br>
			<div class="input-group">
				<input type="search" placeholder="Le nom de l'article contient"
					name="searchNomArticle"> <span class="input-group-append">
				</span>
			</div>
			<br> <br> Cat�gorie : <select name="categorieEnchere"
				id="categorieEnchere">
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
					value="enchereOuverte"> ench�res ouvertes</input> <input
					type="checkbox" id="mesEncheres" name="mesEncheres"
					value="mesEncheres"> mes ench�res</input> <input type="checkbox"
					id="enchereRemporte" name="enchereRemporte" value="enchereRemporte">mes
				ench�res report�es</input>
			</div>

			<input type="radio" name="achatVente" value="vente"> Mes Ventes</input>
			<div id="checkVentes">
				<input type="checkbox" id="checkVenteEC" name="checkVenteEC"
					disabled value="checkVenteEC"> mes ventes en cours</input> <input
					type="checkbox" id="checkVenteDebute" name="checkVenteDebute"
					disabled value="checkVenteDebute"> ventes non d�but�es</input> <input
					type="checkbox" id="checkVenteTermine" name="checkVenteTermine"
					disabled value="checkVenteTermine"> ventes termin�es</input>
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


		<div id="bouton">
			<button>Rechercher</button>
		</div>
	</form>
	<br>

	<div class="row">

		<c:forEach var="current" items="${listeEncheres}">
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="..." alt="Card image cap">
				<div class="card-body">

					<h6 class="card-title">
						<a href="${pageContext.request.contextPath}/RedirectEnchere?idVendeur=${current.article.no_utilisateur}&idArticle=${current.article.no_article}">${current.article.nom_article}</a>
					</h6>

					<p class="card-text">Prix : ${current.montant_enchere} points</p>
					<p class="card-text">Fin de l'ench�re :
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
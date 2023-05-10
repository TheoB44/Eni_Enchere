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
				
				<c:if test="${current.article.image != null}">
					<image src="img/${current.article.image}">
				</c:if>
				
				<c:if test="${current.article.image == null}">
					<img class="card-img-top" src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxAOERUSDxAPFhAPDxAVFRATEhUQEBAVFxUWGBYSFRMYHTQgGBolHRUVIT0tJSkrLi8uFx8zODMtNygtLisBCgoKBQUFDgUFDisZExkrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrK//AABEIAOEA4QMBIgACEQEDEQH/xAAcAAEAAQUBAQAAAAAAAAAAAAAACAEEBQYHAgP/xABBEAACAgEBBQQFCAgFBQAAAAAAAQIDBBEFBgchQRIxUWETInGBkQgjMkJSYoKhFBU0cpKxwdEzQ6LC8CRjdIPh/8QAFAEBAAAAAAAAAAAAAAAAAAAAAP/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AO4gAAAAAAAAFrtPaFOLXK2+yEK4LVzk9Ev/AKBdGH3g3mwtnQ7eXkV1rom9Zy8owXOT9iON788a7LNatlp1w5p5M168vOEenvOQ5+bZkTdl1k52SfOc5OUn8QO4bf481Qbjg4srNOStul6OL81WvWa9rRoO1eLe2cjXTKVUX9SiuNensk05fmaIAMpmbw5t/wDjZmVZr0nfZNfBsx07ZPvcn7W2eAB96suyHONk4tdVKUdPgzK4e9+0qHrXn5kdOnp7HH+FvRmDAHQNm8YNs0P1siFy5erdVB/6oJS/M3bYfHuD0Wbhtd3zlE+2vNuuejS97OEgCYG7m++ztpL/AKbJrlLrXL5u1e2EuZsaIPwm4tNNppppp6NPxT6HRdzuL2dgNQyW8jHWi0m/nYr7s+vvAk2DAbqb24e1a/SYtibjp2q36ttb+9HwM+AAAAAAAAAAAAAAAAAALTam0KsWmd10lGqmEpSl4Jd4FjvVvJj7Lx5ZGTLSMeUYr6dkukIrqyL+/W/GVti3tXS7NMH83jxesK14v7UvFscQd8bdsZLsnrGmDapp6Qj4v7zNVA9SZ5AAAAACpQAAAAKlAAAAyOx9sZGFbG7GtlXbBrSUX3rrFrqvJkmOGnEGnbFXZm1DMqj85V3Kf/cr8V5dCKxkNi7Vtwr4X48+zbVJNPo/FPxT7gJp6gwG5O8lW1cSvJr0TktJw612L6UX/wA5oz4AAAAAAAAAAAAAAZwf5QW9rlOOzqZerBRsv06yfOut+xaSftidzy741QlOX0a4Sk/ZFav8kQx29tOWbk3ZE/pZF1ljWuvZ7Um1FeSWi9yAsWeQAABUChlN39gZW0LfRYlM7J9705RgvtSk+UV7S53N3au2rlQxqeXaes56cqoL6UmSu3X3cx9mY8cfGglGP0pfXsl1nJ9WByHYfASckpZ2Wot99dEe1p/7J9/8JtGPwP2VH6UsmfnKzTX+FI6aioHLMrgXsya9SzLg/KcZL4SiadvFwLy6U54V8L0ufopr0Nr5d0Za9mT9vZJCFGBCfaGBdjWSqvqnXbB6ShOLjJe59C2Ja8QNyMfbNDhNKORBN1XpetB/Zb6xfgRU2ngWYt06bo9myqbjJea/oBaAAAEAB0vgbvQ8LPWNOXzGdpDm+Ubf8uXf1fq/iXgSYIQ0XSrkpwbU4SUoyXfGSeqa89UTO2BtKOZjU5Ee7Iors08O1FNr3PUDIAAAAAAAAAAAAANa4k5Lp2VmTT0f6LZHX95dn/cRCJg8QcGWTszLqgtZSxrGl4uK7SX+kh8wKAAAViEjaeGu7Etq59VLjrTBqy56cvRwabj+J6R9/kB3Dgfun+g4KyLI6ZGaozeq5wq/y4e9et+LyOkJFK4pLRLRLRJdFp0PQAAAAABRojv8ofY0acyrIitFlVNS85wemvwaJEnGPlKpegw319Nf8OzDX+gHAwAAAAAlRwTy/S7Hx0++p3V/w2Sa/KSIrkmfk/6/qhf+Vf8A7QOlAAAAAAAAAAAAAKNEa+LPDe3Aunk4tblh2ylLswWrxm3q4NL6nPk/D2ElWeJ1qSaejT70+afloBCDQaEsNtcL9kZknOzFjGberlVJ1Nvxaj3mJq4KbHT1lC+S+y7pJfFcwI47I2XdmWxpx65Tsm9FGK1978F5kouGO5MNj43ZfZeTdo7rF4ruhF/ZX9WzO7C3aw9nx7OJj11+LjH1pe2XezLJAEioAAAAACmoBsj18onbUbsunGi9Vi1uU/KdmnL4JHY9+N66dkYsr7WnN+rVXr61s2uSS8OpEva20bMu6y+562WzlKT82/8AiAswAAAAFSU3BLD9FsfHb77XdY/xWSSfwiiMGDiTvshVWtbLrIVwXjKclGK+LJm7G2fDEoqx4fQoqrrj5qEUtfy194F8AAAAAAAAAAAAAAAAAAAAAAAAAUbANmv7473YuyKHbky9aWvo6ov5y1rpFeHi+5GC4i8S8fZMXXX2bctrlUn6tfhKxru9neRt2/tzIz75X5VjnbJ97+jBdIQj9WK8ALvfDevJ2tkO/IfJaqupP5umH2Yrx8X1+BgmGUAAAACpse426N218lU1aqtaO23TlXD+76Ab7wA3R9Ne9oWx+bx9Y0arlO1rSU/NRi2va/IkDoWWxtl1YdFdFEVGqmCjFL+b82XwAAAAAAAAAAAAAAAAAAAAAAAKN6AJS0OL8TeLyr7WLsuUZTWsZ5aacYvrGn7T+93eGpjOMXE2VzngYE9KlrG++L0dr60xfSPR+PNd2uvGmwPd98pyc5ycpybbk3rJt9Wz5thsoAAAAFdDeuH3DXK2vJWSTqxE+d0lzn4qtdX59wGC3Q3Vydr3qnGjyWjstl/h0x+1N/yXeyU25262PsnHjRjrzna0lO2XWUv7dC63c3exdm0qjErUK1zfWc5dZzl3ykZTQCoAAAAAAAAAAAAAAAAAAAAAAAKM5hxu31eBjrFolpk5UZatd9dfWXk33HT5PTvIhcRdtyz9o5FzesVbKuC6KEG4x08nzfvA1yUvzPIAAAAD600yslGMIylOclGMYpylKTeiikubbZe7B2LftC6NGNW52zfd3KK6yk+iRJfh7w4xdjxU2lblyjpO+S+h4wqT+iu/zYGlcO+DSj2cjaq1fJxxE+UfO1rvfkuR2umiMIqEIqMYpJRitEl4JHvQqAAAAAAAAAAAAAAAAAAAAAAAAAAAFltq5149013wpsfwiyFTeveTbzqVZXOD7pwlH4rQhZtLDlj22U2L16bJwl05xbX9ALYAAD0jybLw82C9o7Qoo0fYdinZp0rh60n+WnvA7xwX3QWz8JXWQX6TlpTk2ucIPnGHw5+86LoUhBRSSSSSSSXcku5HoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAozhnG7h/Y7JbRxIdpSS/SK4rVprkrUl3rTTX2HdDzJa8n3Pp4gQgkeSVO8PCnZWdJ2OmVVku+dMuxr5uPc2a9XwF2enq8rMa8Na0vyjqBHquLlyS1baSS5tvokurJH8FNyJ7OpllZMOzk5SSUH301Lmk/vSfN+CSNj3b4dbM2dJTox07V3W2N2SX7uvd7jbUBVAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD53XwrWs5RivGTUV8WWH6/w9dP0rH18PSR/uBkwfOm6E1rCUZLxi1JfFH0AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAozl/EzitXsyTxsRRsy0vWb510arlr4y8jYOKm9X6pwJ2Qa/SLX6KnynJPWf4Ypv3JdSKN03JuUm3KTbcm23Jt6ttvvbAye3N5czPk5ZWRbPX6rk1BeSiuWhiSgAzOw9583AkpYuTbBrT1e03B+Ti+Wh3vhnxVr2m442Wo1Zj+g1yryPKP2Z+XXoRrPrj2yrkpRbUoyTUk9Gmu5p+IE3UVNR4Zb0/rXAhbJr01fzdq++vre/vNuAAAAAAAAAAAAAAAAAAAAAAAAAAAAUZUowOAfKRz28rGx9X2a8aVunRuyxx/lV+Zx1nYflI4Ell4t+nq2Y0qtemtc3L+Vpx0AAABUoV0A7P8m7NatyqdfVddc0unaTab+Gh3s4H8m7Ck7sq5p9mNdcE/GTbbXw0O+AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGmcVt1XtbAlXBfP0v0tPnKKacPxJte3R9CKdtUotxkmpRbTTWjTT0aa8SbzRy3ibwphtGUsnDcK8p/Tg/Vqv82/qz8wI4FDJ7b2Dl4M+xl49tUtdF24tRl+7Pul7mY0BofSiqVklGEXKUmkorm5N9EvHuL7YmwcvPn2MTHttlro+xF9mP7036sV7Wjv3C/hTHZrWTmuFmZ9SMfWqx/NNr1p6dencvFhsfC/dZ7KwIVTS9NZ85a/vS+r7lyNvAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAwG+f7HZ+6/5EVqv2v8AH/UACVO5P7HX7DPgAAAAAAAAAAAAAAAAAAAB/9k=" alt="Card image cap">
				</c:if>
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
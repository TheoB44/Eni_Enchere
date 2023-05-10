<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="fragments/meta.html"></jsp:include>
<jsp:include page="fragments/HeaderConnection.jsp"></jsp:include>
</head>
	<body >
		<div id="connexion-container">
	
			<h1>ENI-Enchères</h1>
			<br>
	
			<form class="row justify-content-center mb-2" method="post" action="Connexion">
	
				<input type="hidden" value = "${ErreurConnexion}" name ="IsErreurConnexion" id = "IsErreurConnexion">
	
					<div name="connexion-identifiant" id="connexion-identifiant">
						<div id="connexion-divCo" name="Identifiant">
							Identifiant : <input type="text" name="connexion_identifiant" id="connexion_identifiant" value="${userId}"></input>
						</div>
						<br>
						<div id="connexion" name="MDP">
							Mot de passe : <input type="password" name="connexion_mdp" id="connexion_mdp"></input>
						</div>
					</div>
		
					<br> <br>
		
					<button class="btn btn-outline-dark" name="connexion-btn" id="connexion-btn" onclick="CreateCookie();">Connexion</button>
		
					<div name="connexion-connexion" id="connexion-connexion" >
			    		<input type="checkbox" id="CheckBox-Souvenir"> Se souvenir de moi</input> <!-- Ici crÃ©er un cookie avec les id -->
						<p link="https://google.com">Mot de passe oublié</p>
					</div>
	
			</form>
	
			<button
				onclick="window.location.href = '${pageContext.request.contextPath}/Inscription'" class="btn btn-outline-dark">Créer un compte</button>
		</div>	
		
		<script>
				var connexionErreur = document.getElementById("IsErreurConnexion").value != "" ? document.getElementById("IsErreurConnexion").value : false;				
				if(connexionErreur)
				{
					alert("Pseudo ou mot de passe oublié !");
				}
		</script>
		
		
		<script>
		function CreateCookie()
		{
			var checkbox = document.getElementById("CheckBox-Souvenir");
			
			if(checkbox.checked)
			{
				if((document.getElementById("connexion_identifiant").value != null && document.getElementById("connexion_identifiant").value != "") && (document.getElementById("connexion_mdp").value != null && document.getElementById("connexion_mdp").value != ""))
				{
					var string = 'id=' + document.getElementById("connexion_identifiant").value; 
					document.cookie = string;
				}
			}
		}
		</script>
	</body>
</html>




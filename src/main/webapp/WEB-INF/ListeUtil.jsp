<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="fragments/meta.html"></jsp:include>
<meta charset="ISO-8859-1">
<title>Liste Utilisateur</title>
</head>
<body>


<h3>Liste des utilisateurs : </h3>
<div class="row">
	<c:forEach var="current" items="${ListeUtilisateur}">
		<c:if test="${not current.administrateur}">
			<div class="card" style="width: 18rem;">
				<img class="card-img-top" src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" width="15px" alt="Card image cap">
				<div class="card-body">
					<h6 class="card-title">
						${current.pseudo}
					</h6>
					<a href="${pageContext.request.contextPath}/ListeUtilisateur?idUtil=${current.no_utilisateurs}">Supprimer Utilisateur</a>
				</div>
			</div>
		</c:if>
				
	</c:forEach>
</div>


</body>
</html>
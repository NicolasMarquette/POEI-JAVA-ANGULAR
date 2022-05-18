<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="cssFontAwesome/all.css" rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="css/style.css" rel="stylesheet" />

<meta charset="UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Récapitulatif commande</title>
</head>
<body>
<div class="container">
<div class="container header">
			<header class="d-flex">
				<h1 class="logo navbar-brand">
					<!-- Pas oublier de le copier dans les autres pages -->
					<a class="logo" href="accueil.jsp"><img alt="sushi logo"
						src="images/logo/sushi_logo.png"
						style="width: 300px; height: 250px;" /></a>
				</h1>
				<nav class="d-flex align-self-center">
					<ul class="nav nav-pills nav-justified">
						<!-- <li class="nav-item p-2 flex-fill"><a class="nav-link"
							href="accueil.jsp">Itadakimasu</a></li> -->
						<li class="nav-item p-2 flex-fill"><a class="nav-link"
							href="carte.jsp">Notre carte</a></li>
						<li class="nav-item p-2 flex-fill"><a class="nav-link"
							href="authentification.jsp">Authentification</a></li>
						<li class="nav-item p-2 flex-fill"><a class="nav-link"
							href="inscription.jsp">Inscription</a></li>
					</ul>
				</nav>
			</header>
			<p class="menuhr"></p>
		</div>

<section>
		<h1>La commande de <c:out value="${client.nom}"></c:out> (montant panier: <c:out value="${sessionScope.panier.total}"></c:out>€)</h1>
		
		</section>

<section class="factureClient">

			<table border="1" width="100%" cellspacing="6" cellpadding="10">

				<caption>Voici le récapitulatif de votre commande</caption>
				<thead>
					<tr>
						<th width="20%">Articles</th>
						<th width="20%">Quantité</th>
						<th width="40%">Prix total</th>
					</tr>
				</thead>
				<!-- 				<tfoot> -->
				<!-- 					<tr> -->
				<!-- 						<th width="50%">Total</th> -->
				<!-- 						<th width="50%">0</th> -->
				<!-- 					</tr> -->
				<!-- 				</tfoot> -->
				<tbody>
					<c:forEach var="p" items="${sessionScope.panier.panier}">
						<tr>
							<td><c:out value="${p.value.article.nom}"></c:out></td>
							<td><c:out value="${p.value.quantite}"></c:out></td>
							<td><c:out value="${p.value.somme}"></c:out></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form action="servletCommande" method="post">
				<input type="submit" value="Valider la commande" class="btn btn-dark">
			</form>
			<form action="servletRetourPanier" method="post">
				<input type="submit" value="Retour au panier" class="btn btn-dark">
			</form>
		</section>
</div>
</body>
</html>
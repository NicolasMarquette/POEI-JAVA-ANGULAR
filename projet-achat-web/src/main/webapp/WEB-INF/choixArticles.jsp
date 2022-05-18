<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.gstatic.com/%22%3E" />
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300;400;700&display=swap"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="css/style.css" rel="stylesheet" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		

		<div class="container">
			<form action="servletPanier" method="post">
				<div>
					<label for="article">Choisissez vos articles:</label> <select
						name="article">
						<c:forEach var="a" items="${articles}">
							<c:set var="nom" value="${a.nom}"></c:set>
							<c:set var="id" value="${a.idArticle}"></c:set>
							<option value="${id}" />${nom}</option>
						</c:forEach>
					</select>

				</div>
				<p class="form-floating mb-3 mt-3" style="width: 100px">
					<input type="number" min="1" max=10 name="quantite" id="quantite"
						value="1" class="form-control" /> <label for="quantite"
						class="text-black">Quantite</label>
				</p>
				<br> <input type="submit" value="Ajouter au panier"
					class="btn btn-dark">
			</form>

		</div>


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
			<form action="servletRecap" method="post">
				<input type="submit" value="Valider le panier" class="btn btn-dark">
			</form>
		</section>


		<div class="container footer">
			<footer class="footer-distributed d-flex justify-content-between">
				<div class="footer-left">
					<p class="footer-company-name">Itadakimasu © 2022</p>
					<a href="#"><i class="fa-brands fa-facebook"></i></a>
				</div>

				<div class="footer-right">

					<p>Contact Us</p>

					<form action="#" method="post">

						<p class="form-floating mb-3 mt-3">
							<input type="text" name="email" placeholder="Email">
						</p>
						<p class="form-floating mb-3 mt-3">
							<textarea name="message" placeholder="Message"></textarea>
						</p>
						<button type="button" class="btn btn-outline-info btn-sm">Send</button>

					</form>
				</div>
			</footer>
		</div>

		<div></div>


	</div>
</body>
</html>
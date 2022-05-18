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

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<title>Commandes</title>
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
					<li class="nav-item p-2 flex-fill"><a
						class="nav-link" href="servletRetourPanier">Ma commande</a></li>
					<li class="nav-item p-2 flex-fill"><a class="nav-link"
						href="servletDeconnexion">Deconnection</a></li>
				</ul>
			</nav>
		</header>
		<p class="menuhr"></p>
	</div>

		<p class="display-5 text-center">
			Félicitation
			 <c:out value="${client.prenom}"></c:out> <c:out value="${client.nom}"></c:out>
			. Votre commande a bien été validée.<br> Montant total de la
			commande :
			<c:out value="${sessionScope.total}"></c:out>
			€.<br> Adresse de livraison :
			<c:out value="${client.adresse}"></c:out>
			<br> Votre commande sera livrée d'ici 30 minutes.
		</p>
		<br>
		<br>
		<p class="display-4 text-center">A bientôt chez Itadakimasu !</p>
		<img src="images/completed.svg"
			class="w-50 mt-4 ml-4 col-12 mx-auto d-block"
			alt="Votre commande est validée">
	</div>

<div class="container footer">
			<footer class="footer-distributed d-flex justify-content-between">
	<div class="container bloc-sm">
		<div class="row">
			<div class="col-sm-12">
				<p class="text-center white footer-p">
					<br /> <i class="fas fa-heart"></i> Itadakimasu © 2022
				</p>
				<p class="text-center">Copyright Sarah, Nicolas, Dimitri</p>
				<nav class="row row-no-gutters social"
					aria-label="navigation des réseaux sociaux">
					<div class="col-sm-6">
						<div class="text-center">
							<a class="social" aria-label="Twitter"> <span
								class="fab fa-twitter icon-md 2x"></span> <span
								class="footer-text icon-md">Twitter</span></a>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="text-center">
							<a class="social" aria-label="Facebook"> <span
								class="fab fa-facebook icon-md"></span> <span
								class="footer-text icon-md">Facebook</span></a>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="text-center">
							<a class="social" aria-label="Linkedin"> <span
								class="fab fa-linkedin icon-md"></span> <span
								class="footer-text icon-md">Linkedin</span></a>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="text-center">
							<a class="social" aria-label="Instagram"> <span
								class="fab fa-instagram icon-md"></span> <span
								class="footer-text icon-md">Instagram</span></a>
						</div>
					</div>
				</nav>
			</div>
			</div>
		</div>
		</footer>
	</div>
</body>
</html>
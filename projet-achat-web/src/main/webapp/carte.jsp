<%@page import="model.Article"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>La carte</title>
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
						<li class="nav-item p-2 flex-fill" ${hidden_auth}><a
							class="nav-link" href="authentification.jsp">Authentification</a></li>
						<li class="nav-item p-2 flex-fill" ${hidden_auth}><a
							class="nav-link" href="inscription.jsp">Inscription</a></li>
						<li class="nav-item p-2 flex-fill" ${hidden_deco}><a
							class="nav-link" href="servletRetourPanier">Ma commande</a></li>
						<li class="nav-item p-2 flex-fill" ${hidden_deco}><a
							class="nav-link" href="servletDeconnexion">Deconnection</a></li>
					</ul>
				</nav>
			</header>
			<p class="menuhr"></p>
		</div>

		<div>
			<p class="text-center" style="font-size: 50px;; font-family:">La
				carte d'Itadakimasu</p>
			<img class="mx-auto d-block" alt="separateur menu"
				src="images/sep.png" style="width: 400px;" /> <br>
		</div>

	
<div class="plat-grid">
				<div class="plat-cards">

					<c:forEach var="a" items="${articles }">
						<c:url var="myurl" value="/${a.image}" context="/images" />
						<figure class="plat flex-grow-1">
							<div class="plat-card-picture">
								<img src=".${myurl}" alt="${a.image}"
									class="rounded-circle  mx-auto d-block" />
							</div>

							<figcaption>
								<p style="font-size: 15px;color: #e9483e; text-align:center"><b>
									<c:out value="${a.nom}"></c:out></b>
								</p>
								<p style="font-size: 15px;color: #e9483e;text-align:center "><b>
									<c:out value="${a.tarif}"></c:out></b>
									€
								</p>

							</figcaption>
							<div class="card-body">
								<c:out value="${a.description}"></c:out>
							</div>
						</figure>
					</c:forEach>


				</div>
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
			</div>


</body>
</html>
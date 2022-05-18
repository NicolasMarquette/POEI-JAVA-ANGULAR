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
						<li class="nav-item p-2 flex-fill"><a class="nav-link"
							href="authentification.jsp">Authentification</a></li>
						<li class="nav-item p-2 flex-fill"><a class="nav-link"
							href="inscription.jsp">Inscription</a></li>
					</ul>
				</nav>
			</header>
			<p class="menuhr"></p>
		</div>

<div>
<p class="text-center" style="font-size:50px;;font-family:">La carte d'Itadakimasu</p>
<img class = "mx-auto d-block" alt="separateur menu" src="images/sep.png" style="width: 400px;"/>
<br>
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
							<p>
								<c:out value="${a.nom}"></c:out>
							</p>
							<p>
								<c:out value="${a.tarif}"></c:out>
								€
							</p>

						</figcaption>
					</figure>
				</c:forEach>
			</div>
		</div>

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


	</div>



</body>
</html>
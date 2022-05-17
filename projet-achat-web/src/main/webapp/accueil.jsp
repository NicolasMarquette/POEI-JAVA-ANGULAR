<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>accueil</title>
<link rel="preconnect" href="https://fonts.gstatic.com/%22%3E" />
<link
	href="https://fonts.googleapis.com/css2?family=Raleway:wght@300;400;700&display=swap"
	rel="stylesheet" />
<link href="./css/all.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="css/style.css" rel="stylesheet" />
</head>

<body>
	<div class="container">

		<div class="container header">
			<header class="d-flex">
				<h1 class="logo navbar-brand">
					<img alt="sushi logo" src="images/logo/sushi_logo.png" />
				</h1>
				<nav class="d-flex align-self-center">
					<ul class="nav nav-pills nav-justified">
						<li class="nav-item p-2 flex-fill"><a class="nav-link"
							href="accueil.jsp">Itadakimasu</a></li>
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
			<div class="container mt-5">
				<!-- Carousel -->
				<div id="demo" class="carousel slide carousel-fade"
					data-bs-ride="carousel">

					<!-- Indicators/dots -->
					<div class="carousel-indicators">
						<button type="button" data-bs-target="#demo" data-bs-slide-to="0"
							class="active"></button>
						<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
						<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
					</div>

					<!-- The slideshow/carousel -->
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="images/carousel/carousel1.jpg" alt="sushi1"
								class="img-fluid d-block rounded w-100">
						</div>
						<div class="carousel-item">
							<img src="images/carousel/carousel2.jpg" alt="sushi2"
								class="d-block rounded w-100">
						</div>
						<div class="carousel-item">
							<img src="images/carousel/carousel3.jpg" alt="sushi3"
								class="img-fluid d-block rounded w-100">
						</div>
					</div>

					<!-- Left and right controls/icons -->
					<button class="carousel-control-prev" type="button"
						data-bs-target="#demo" data-bs-slide="prev">
						<span class="carousel-control-prev-icon"></span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#demo" data-bs-slide="next">
						<span class="carousel-control-next-icon"></span>
					</button>
				</div>
			</div>
		</section>

		<div class="container">
			<h2>Livraison à domicile de plats japonais</h2>
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
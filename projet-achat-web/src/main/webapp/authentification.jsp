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
<title>Authentification</title>
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

		<div class="container">
			<form action="servletAuthentification" method="post">
				<div class="container" style="width: 800px">
					<div class="label">
						<fieldset>
							<legend class="text-center">Informations
								d'authentification</legend>
							<div class="container border rounded">
								<p class="form-floating mb-3 mt-3">
									<input name="email" type="email" class="form-control"
										placeholder="Enter email" value="example@example.com" required>
									<label for="email" class="text-black">Email</label>
								</p>
								<p class="form-floating mb-3 mt-3">
									<input name="mdp" type="password" class="form-control"
										placeholder="Enter mdp"> <label for="mdp"
										class="text-black">Mot de passe</label>
								</p>
							</div>
							<br> <input type="submit" value="Me connecter"
								class="btn btn-dark">
							<button onclick="" class="btn btn-dark">Annuler</button>
						</fieldset>
					</div>
				</div>
			</form>
		</div>


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

	</div>

</body>
</html>
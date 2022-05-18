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

		<div class="container">
			<form action="servletInscription" method="post">
				<div class="container" style="width: 800px">
					<div class="label">
						<fieldset>
							<legend class="text-center">Création d'un nouveau compte</legend>
							<div class="container border rounded">
								<p class="form-floating mb-3 mt-3">
									<input name="email" type="email" class="form-control"
										placeholder="Enter email" value="example@example.com" required>
									<label for="email" class="text-black">Email</label>
								</p>
								<p class="form-floating mb-3 mt-3">
									<input name="nom" class="form-control" placeholder="Enter nom">
									<label for="nom" class="text-black">Nom</label>
								</p>
								<p class="form-floating mb-3 mt-3">
									<input name="prenom" class="form-control"
										placeholder="Enter prenom"> <label for="prenom"
										class="text-black">Prenom</label>
								</p>
								<p class="form-floating mb-3 mt-3">
									<input name="mdp" type="password" class="form-control"
										placeholder="Enter mdp"> <label for="mdp"
										class="text-black">Mot de passe</label>
								</p>
								<p class="form-floating mb-3 mt-3">
									<input name="adresse" class="form-control"
										placeholder="Enter adresse"> <label for="adresse"
										class="text-black">Adresse</label>
								</p>
								<p class="form-floating mb-3 mt-3">
									<input name="tel" class="form-control" placeholder="Enter tel">
									<label for="tel" class="text-black">Téléphone</label>
								</p>
							</div>
							<br> <input type="submit" value="Envoyer"
								class="btn btn-dark">
							<button onclick="" class="btn btn-dark">Annuler</button>
						</fieldset>
					</div>
				</div>
			</form>
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
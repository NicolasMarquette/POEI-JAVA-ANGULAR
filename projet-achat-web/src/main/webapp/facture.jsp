<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>accueil</title>
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link href="cssFontAwesome/all.css" rel="stylesheet" />
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

<i class="fas fa-facebook"></i><i class="fas fa-dog"></i>
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
				<tfoot>
					<tr>
						<th width="50%">Total</th>
						<th width="50%">0</th>
					</tr>
				</tfoot>
				<tbody>
					<tr>
						<td width="50%">test1</td>
						<td width="50%">26</td>
					</tr>
					<tr>
						<td width="50%">test2</td>
						<td width="50%">32</td>
					</tr>
					<tr>
						<td width="50%">test3</td>
						<td width="50%">12</td>
					</tr>
				</tbody>
			</table>

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
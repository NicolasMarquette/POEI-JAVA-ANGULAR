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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Veuillez rentrer vos informations </h1>
		<form action="servletInscription" method="post">
		<div class="container" style = "width : 800px">
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
						placeholder="Enter prenom">
					<label for="prenom" class="text-black">Prenom</label>
				</p>
				<p class="form-floating mb-3 mt-3">
					<input name="mdp" type="password" class="form-control"
						placeholder="Enter mdp">
					<label for="mdp" class="text-black">Mot de passe</label>
				</p>
				<p class="form-floating mb-3 mt-3">
					<input name="adresse" class="form-control"
						placeholder="Enter adresse">
					<label for="adresse" class="text-black">Adresse</label>
				</p>
				<p class="form-floating mb-3 mt-3">
					<input name="tel" class="form-control" placeholder="Enter tel">
					<label for="tel" class="text-black">Téléphone</label>
				</p>
				</div>
					<br> <input type="submit" value="Envoyer" class="btn btn-dark">
					<button onclick="" class="btn btn-dark"> Annuler </button>
			</fieldset>	
			</div>
		</div>
	</form>
</body>
</html>
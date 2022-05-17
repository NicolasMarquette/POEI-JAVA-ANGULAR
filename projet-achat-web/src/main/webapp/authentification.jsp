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
<title>Authentification</title>
</head>
<body>
<h1>Veuillez vous connecter <br></h1>
<form action="servlet1" method="post">
		<div class="container">
			<div class="label">
				<p class="form-floating mb-3 mt-3">
					<input name="email" type="email" class="form-control"
						placeholder="Enter email" value="example@example.com" required>
					<label for="email" class="text-black">Email</label>
				</p>
				<p class="form-floating mb-3 mt-3">
					<input name="mdp" type="password" class="form-control"
						placeholder="Enter mdp">
					<label for="mdp" class="text-black">Mot de passe</label>
				</p>
				<br> <input type="submit" value="Me connecter" class="btn btn-dark">
			</div>
		</div>
	</form>
</body>
</html>
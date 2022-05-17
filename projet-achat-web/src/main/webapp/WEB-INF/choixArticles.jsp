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
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
	Page du choix des articles

	<form action="servletPanier" method="post">
		<div>
			<label for="article">Choisissez vos articles:</label>
			<select name="article">
				<c:forEach var="a" items="${articles }">
					<option name = "nomarticle" value=<c:out value='${a.nom}'/>><c:out
							value='${a.nom}'></c:out></option>
				</c:forEach>
			</select>
		</div>
		<p class="form-floating mb-3 mt-3" style="width: 100px">
			<input type="number" min="1" max=10 name="quantite" id="quantite"
				value="1" class="form-control" />
			<label for="quantite" class="text-black">Quantite</label>
		</p>
		<br> <input type="submit" value="Ajouter au panier"
			class="btn btn-dark">
	</form>
</body>
</html>
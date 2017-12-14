<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
<script
	src="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>

<body>
	<div class="container">
		<h1>Nouveau Collaborateur</h1>

		<form >
			<div class="form-group">
				<label for="nom">Nom *</label> 
				<input type="text" class="form-control" id="nom" required>
			</div>
			<div class="form-group">
				<label for="prenom">Prénom *</label> 
				<input type="text" class="form-control" id="prenom" required>
			</div>
			<div class="form-group">
				<label for="dateNaissance">Date de naissance *</label> 
				<input type="date" class="form-control" id="dateNaissance" required>
			</div>
			<div class="form-group">
				<label for="adresse">Adresse *</label>
				<textarea class="form-control" rows="4" id="adresse" required></textarea>
			</div>
			<div class="form-group">
				<label for="numSecuSociale">Numéro de sécurité sociale *</label> 
				<input type="number" class="form-control" id="numSecuSociale" min="15" required>
			</div>
			<button type="submit" class="btn btn-default">Créer</button>
		</form>
	</div>
</body>
</html>
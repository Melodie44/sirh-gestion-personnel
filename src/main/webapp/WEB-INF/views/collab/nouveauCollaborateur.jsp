<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>

<body>
	<div class="container">
		<h1>Nouveau Collaborateur</h1>

		<form method="post">
			<div class="form-group">
				<label for="nom">Nom *</label> 
				<input id="nom" type="text" class="form-control" name="nom" required>
			</div>
			<div class="form-group">
				<label for="prenom">Prénom *</label> 
				<input id="prenom" type="text" class="form-control" name="prenom" required>
			</div>
			<div class="form-group">
				<label for="dateNaissance">Date de naissance *</label> 
				<input id="dateNaissance" type="date" class="form-control" name="dateNaissance" required>
			</div>
			<div class="form-group">
				<label for="adresse">Adresse *</label>
				<textarea id="adresse" class="form-control" rows="4" name="adresse" required></textarea>
			</div>
			<div class="form-group">
				<label for="numSecuSociale">Numéro de sécurité sociale *</label> 
				<input id="numSecuSociale" type="number" class="form-control" name="numSecuSociale" required>
			</div>
			<button type="submit" class="btn btn-default">Créer</button>
		</form>
	</div>
</body>
</html>
<%@page import="dev.sgp.entite.Departement"%>
<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body style="padding:50px">
	<h1>Les collaborateurs</h1>
	
	<form id="rechercher" method="post">
	<div class="row">
		<div class="col-md-4" style="text-align:right">
			<label for="recherche">Rechercher un nom ou un prénom qui commence par : </label>
		</div>
		<div class="col-md-2">
			<input type="text" name="recherche" size="25px">
		</div>
		<div class="col-md-2">
			<button type="submit" class="btn btn-default">Rechercher</button>
		</div>
		<div class="col-md-4">
			<div class="checkbox">
  				<label><input type="checkbox" value="">Voir les collaborateurs désactivés</label>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4" style="text-align:right">
			<label for="depart">Filtrer par département : </label>
		</div>
		<div class="col-md-2">
			<select class="form-control" id="depart">
				<%
					List<Departement> departements = (List<Departement>) request.getAttribute("departements");
					for (Departement depart : departements) {
				%>
    			<option><%=depart.getNom()%></option>
				<%
					}
				%>
  			</select>
  		</div>
  		<div class="col-md-6"></div>
  	</div>
	</form>
	
	</br>
	
	<div class="row">
	<%
		List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("listeNoms");
		for (Collaborateur collab : listeNoms) {
	%>
	<form id="editer" method="post">
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<%=collab.getNom()%> <%=collab.getPrenom()%>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-6">
						<img src=<%=collab.getPhoto()%> alt="photo">
					</div>
					<div class="col-md-6">
						<p>Fonction : <%=collab.getIntitulePoste()%></p>
						<p>Département : <%=collab.getDepartement().getNom()%></p>
						<p>Email : <%=collab.getEmailPro()%></p>
						<p>Téléphone : <%=collab.getTelephone()%></p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-9"></div>
					<div class="col-md-3">
						<button type="submit" class="btn btn-default" >Editer</button>
					</div>
				</div>
			</div>
		
		</div>
	</div>
	</form>
	<%
		}
	%>
	</div>
</body>
</html>
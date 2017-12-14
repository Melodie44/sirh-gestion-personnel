<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SGP - App</title>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
	</head>
	<body>
		<h1>Les collaborateurs</h1>
		<ul>
			<%
				List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("listeNoms");
				for (Collaborateur collab : listeNoms) {
			%>
			<img src=<%=collab.getPhoto()%> alt="photo">
			<li>Nom : <%=collab.getNom()%></li>
			<li>Prénom : <%=collab.getPrenom()%></li>
			<li>Adresse :<%=collab.getAdresse()%></li>
			<li>Date de naissance : <%=collab.getDateNaissance()%></li>
			<li>Numéro de sécurité sociale : <%=collab.getNumSecuSociale()%></li>
			<li>Email pro : <%=collab.getEmailPro()%></li>
			<li>Matricule : <%=collab.getMatricule()%></li>
			<li>Date, heure création : <%=collab.getDateHeureCreation()%></li>
			<%
				}
			%>
		</ul>
	</body>
</html>
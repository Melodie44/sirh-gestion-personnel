<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="dev.sgp.entite.VisiteWeb"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>Statistiques</h1>
	
		<div class="table-responsive">
  			<table class="table-striped table-bordered">
    			<thead class="active">
    				<tr>
    					<th>Chemin</th>
    					<th>Nombres de visites</th>
    					<th>Min (ms)</th>
    					<th>Moyenne (ms)</th>
    				</tr>
    			</thead>
    			<tbody>
    				<c:forEach items="${visites}" var="visite">	
    				<tr>
    					<td>${visite.chemin}</td>
    					<td></td>
    				</tr>
    				</c:forEach>
    			</tbody>
  			</table>
		</div>
	</div>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="medical.m2i.bo.Ville" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
</head> 
<body>
<%@ include file="fragments/header.jsp" %>
<main class="container">

<a href="inscription.jsp" class="btn btn-primary">Ajouter un patient</a>

<% ArrayList<Ville> listeville = new ArrayList<Ville>();
%>

<table class="table table-striped">
	<thead>
		<th>ID</<th><th>Nom</th><th>Code Postal</th>
	</thead>
	<tbody>
		<%
		listeville = ( ArrayList ) request.getAttribute( "listeville" );
		for( Ville p : listeville ) {
			%>
			<tr>
				<td><%= p.getId() %></td>
				<td><%= p.getNom() %></td>
				<td><%= p.getCodePostal()%></td>
			</tr>
			<%
		}
		%>		
	</tbody>
</table>


</main>
<%@ include file="fragments/footer.jsp" %>


</body>
</html>
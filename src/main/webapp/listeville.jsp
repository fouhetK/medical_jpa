<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="medical.m2i.model.Ville"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
</head>
<body class="mb-5">
	<%@ include file="fragments/header.jsp"%>
	<main class="container">

		<a href="createville" class="btn btn-primary">Ajouter une
			ville</a>

		<%
		ArrayList<Ville> listeville = new ArrayList<Ville>();
		%>

		<table class="table table-striped">
			<thead>
				<th>ID</
				<th>
				<th>Nom</th>
				<th>Code Postal</th>
				<th>Pays</th>
				<th>Action</th>
			</thead>
			<tbody>
				<%
				listeville = (ArrayList) request.getAttribute("listeville");
				for (Ville p : listeville) {
				%>
				<tr>
					<td><%=p.getId()%></td>
					<td><%=p.getNom()%></td>
					<td><%=p.getCodePostal()%></td>
					<td><%=p.getPays().getNom()%></td>
					<td>
						<a class="btn btn-secondary" href="editville?id=<%=p.getId()%>">
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i>
						</a>
						<button class="btn btn-danger" onclick="supprimer(<%=p.getId()%>)">
							<i class="fa fa-times" aria-hidden="true"></i>
						</button>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>


	</main>
	<%@ include file="fragments/footer.jsp"%>
<script>
function supprimer (id){
	if (confirm("Êtes vous sur ?")){
		window.location = "deleteville?id=" + id;
	}
}
</script>

</body>
</html>
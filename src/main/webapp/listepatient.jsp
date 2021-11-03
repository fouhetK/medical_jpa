<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="medical.m2i.bo.Patient"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des patients</title>
</head>
<body>
	<%@ include file="fragments/header.jsp"%>
	<main class="container">

		<a href="inscription.jsp" class="btn btn-primary">Ajouter un
			patient</a>

		<%
		ArrayList<Patient> listepatient = new ArrayList<Patient>();
		%>

		<table class="table table-striped">
			<thead>
				<th>ID</
				<th>
				<th>Nom & prénom</th>
				<th>Date de naissance</th>
				<th>Adresse</th>
				<th>Ville</th>
				<th>Pays</th>
				<th>Action</th>
			</thead>
			<tbody>
				<%
				listepatient = (ArrayList) request.getAttribute("listepatient");
				for (Patient p : listepatient) {
				%>
				<tr>
					<td><%=p.getId()%></td>
					<td><%=p.getNom() + " " + p.getPrenom()%></td>
					<td><%=p.getDatenaissance()%></td>
					<td><%=p.getAdresse()%></td>
					<td><%=p.getVille().getNom()%></td>
					<td><%=p.getPays().getNom()%></td>
					<td>
						<a class="btn btn-secondary" href="editpatient?id=<%=p.getId()%>">
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
		window.location = "deletepatient?id=" + id;
	}
}
</script>

</body>
</html>
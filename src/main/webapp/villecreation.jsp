<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="medical.m2i.model.Pays"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de modification de ville</title>
</head>

<body>
	<%@ include file="fragments/header.jsp"%>
	<main class="container">
		<h1>Formulaire d'ajout de ville a la base de donnée</h1>
		<hr>
		<div></div>
		<form name="monForm"
			action="http://localhost:8080/medical5_jpa/createville"
			method="post">
			<div class="form-line mb-4">
				<label class="form-label">Nom de la ville *</label> <input class="form-control"
					type="text" name="nom" placeholder="Le nom de la ville" required>
			</div>
			<div class="form-line mb-4">
				<label class="form-label">Code Postal *</label> <input class="form-control" type="text" name="codepostal"
					placeholder="Code Postal" required>
			</div>

			<div class="form-line mb-4">
				<label class="form-label">Pays *</label> <select name="pays"
					class="form-select" required id="pays">
					<% ArrayList<Pays> listepays = (ArrayList<Pays>) request.getAttribute("listepays"); %>
					<option value="">--choisisser un pays--</option>
					<% for (Pays p : listepays) { %>
						<option value="<%= p.getCode() %>"><%= p.getNom() %></option>
					<%} %>
				</select>
			</div>

			<div class="form-line mb-4">
				<button type="submit" id="buttoncreateville" class="btn btn-primary">Envoyer</button>
			</div>

		</form>
	</main>
</body>
</html>
<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="medical.m2i.model.Pays"%>
<%@ page import="medical.m2i.model.Ville"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de modification de ville</title>
</head>

<body>
	<%@ include file="fragments/header.jsp"%>
	<% Ville ville = (Ville) request.getAttribute("ville"); %>
	<main class="container">
		<h1>Formulaire d'inscription é</h1>
		<hr>
		<div></div>
		<form name="monForm"
			action="http://localhost:8080/medical5_jpa/editville"
			method="post">
			<input name="id_ville" type="hidden" value="<%= ville.getId() %>">
			<div class="form-line mb-4">
				<label class="form-label">Nom de la ville *</label> <input class="form-control"
					type="text" name="nom" placeholder="Le nom de la ville"
					value="<%= ville.getNom() %>" required>
			</div>
			<div class="form-line mb-4">
				<label class="form-label">Code Postal *</label> <input class="form-control" type="text" name="codepostal"
					placeholder="Code Postal" value="<%= ville.getCodePostal() %>" required>
			</div>

			<div class="form-line mb-4">
				<label class="form-label">Pays *</label> <select name="pays"
					class="form-select" required id="pays">
					<% ArrayList<Pays> listepays = (ArrayList<Pays>) request.getAttribute("listepays"); %>
					<% for (Pays p : listepays) { %>
						<option <% if (ville.getPays().getCode().equals(p.getCode())) out.println("selected"); %> value="<%= p.getCode() %>"><%= p.getNom() %></option>
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
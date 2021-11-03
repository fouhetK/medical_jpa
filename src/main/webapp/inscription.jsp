<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'inscription</title>
<script>function load(page) {
	  if (page.value != "") {
		  var myHeaders = new Headers();

		  var myInit = { method: 'GET',
		                 headers: myHeaders,
		                 mode: 'cors',
		                 cache: 'default' };
		  fetch('http://localhost:8080/medical5_jpa/villes?pays=' + page.value, myInit)
		  .then(response => response.text())
		  .then(function(response) {
					    document.getElementById('ville').disabled = false;
				        document.getElementById('ville').innerHTML = response;
			})
			.catch(function(error) {
				  console.log('Il y a eu un problème avec l\'opération fetch: ' + error.message);
				});
		  } else {
		    document.getElementById('ville').disabled = true;
		    document.getElementById('ville').innerHTML = '<option value="">--choisisser un pays--</option>';
		  }
		}
</script>
</head>

<body>
	<%@ include file="fragments/header.jsp"%>

	<main class="container">
		<h1>Formulaire d'inscription</h1>
		<hr>
		<div></div>
		<form name="monForm"
			action="http://localhost:8080/medical5_jpa/ajoutpatient"
			method="post">
			<div class="form-line mb-4">
				<label class="form-label">Nom *</label> <input class="form-control"
					type="text" name="nom" placeholder="Votre nom" required>
			</div>
			<div class="form-line mb-4">
				<label class="form-label">Prénom *</label> <input class="form-control" type="text" name="prenom"
					placeholder="Votre prénom" required>
			</div>

			<div class="form-line mb-4">
				<label class="form-label">Date de naissance *</label> <input
					class="form-control" type="date" name="datenaissance" placeholder="dd/mm/yyyy" required>
			</div>

			<div class="form-line mb-4">
				<label class="form-label">Adresse *</label> <input class="form-control" type="text"
					name="adresse" placeholder="Votre adresse" required>
			</div>

			<div class="form-line mb-4">
				<label class="form-label">Pays *</label> <select name="pays"
					class="form-select" required id="pays" onchange="load(this)">
					<option value="">--choisisser un pays--</option>
					<option value="Fra">France</option>
					<option value="Ita">Italie</option>
					<option value="Ang">Angleterre</option>
				</select>
			</div>

			<div class="form-line mb-4">
				<label class="form-label">Ville *</label>
				<div id="cities-content" style="width: 59%; float: right">
					<select class="form-select" name="ville" required id="ville" disabled>
						<option value="">--choisisser un pays--</option>
					</select>
				</div>
			</div>

			<div class="form-line mb-4">
				<button type="submit" id="buttoncreatepatient" class="btn btn-primary">Envoyer</button>
			</div>

		</form>
	</main>
</body>

</html>
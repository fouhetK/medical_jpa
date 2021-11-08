<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/core.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.9-1/md5.js"></script>
<title>Welcome to MediCom App</title>
</head>
<body>

	<main class="container">
		<div class="border-1 w-50 mx-auto">
			<div id="msgErr" style="display:none">
				<div class="alert alert-danger">Nom d'utilisateur ou mot de passe incorrect</div>
			</div>
			<form class="p-3" action="" method="post" onsubmit="return authentifier()">
				<h2 class="h4">Authentification</h2>
				<hr>
				<div class="mb-3 row">
					<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="staticEmail">
					</div>
				</div>
				<div class="mb-3 row">
					<label for="authPassword" class="col-sm-2 col-form-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="authPassword">
					</div>
				</div>

				<button type="submit" id="submitbtn" class="btn btn-primary btn-sm">Authentifier</button>
			</form>
		</div>
	</main>

	<script>
		function setCookie(cname, cvalue, exdays) {
			const d = new Date();
			d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
			let expires = "expires=" + d.toUTCString();
			document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
		}
		function authentifier() {
			
			document.getElementById("submitbtn").innerHTML = '<div class="spinner-border" role="status"><span class="sr-only"></span></div>'; 
			
			login = document.getElementById('staticEmail').value
			password = document.getElementById('authPassword').value
			
			var details = {
			    'username': login,
			    'password': CryptoJS.MD5(password).toString()
			};
			// préparation des paramètres 
			var formBody = [];
			
			for (var property in details) {
			  var encodedKey = encodeURIComponent(property);
			  var encodedValue = encodeURIComponent(details[property]);
			  formBody.push(encodedKey + "=" + encodedValue);
			}
			
			formBody = formBody.join("&");

			fetch("http://localhost:8080/medical5_jpa/", {
			  method: 'POST',
			  headers: {
			    'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
			  },
			  body: formBody
			})
			.then(res => {
	            return res.text(); // extraction du texte à partir de l'objet response de fetch API
	        })
			.then(function(data){ 
				console.log( data.indexOf("ok") );
				
				if( data.indexOf("ok") >=  0 ){
					window.location = 'listepatients'; 
				}else{
					document.getElementById('msgErr').style.display = "block";
				}
			})
			
			document.getElementById("submitbtn").innerHTML = 'Authentifier';
			
			return false; 
		}
	</script>

</body>
</html>
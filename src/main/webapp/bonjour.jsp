<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bonjour, ceci est ma première servlet</title>
</head>
<body>

<h1>Page Bonjour</h1>

<form name="test" action="" method="post">
	<input type="text" name="chaine"/>
	
	<input type="submit" value="Submit" id="button-1"/>
</form>

<%!
String s = null;
%>

<%
if ("POST".equalsIgnoreCase(request.getMethod())) {
	s = request.getParameter("chaine");
	out.println("form submited");
	out.println("number of words : " + s.split("\\s+").length);
} else {
	out.println("form not submited");
}
%>

</body>
</html>
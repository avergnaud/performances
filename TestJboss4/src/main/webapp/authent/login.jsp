<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<strong>Authentification (session)</strong>
	<form action="<%=request.getContextPath()%>/index.jsp" method="post">
		<label for="user">Utilisateur</label> <input type="text" name="user">
		<br> 
		<label for="password">Mot de passe</label> <input type="password" name="pwd">
		<br>
		<input type="submit" value="Authentification">
	</form>
	
</body>
</html>
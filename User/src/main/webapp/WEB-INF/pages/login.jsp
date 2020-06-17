<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<p style="color:red;">${message}</p>
	<form action="login" method=POST >
	  Username : <input type="text" name="username"/></br>
	  Password : <input type="password" name="password"/></br>
	  <input type="submit"/>
	</form>
	</center>
</body>
</html>
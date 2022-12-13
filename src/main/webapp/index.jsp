<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
			if (session.getAttribute("isLoggedIn") !=null) {
				response.sendRedirect("views/Profile.jsp");
			} 
		%>
		
		<h1>Welcome to the Login Program!</h1>
		<form action="<%=request.getContextPath() %>/SessionServlet" method="POST">
				<p>Username: </p>
				<input type ="text" name="username" required>
				<p>Password: </p>
				<input type="password" name="password" required>
				<br>
				<br>
				<input type="submit" value="Login">
		</form>
</body>
</html>
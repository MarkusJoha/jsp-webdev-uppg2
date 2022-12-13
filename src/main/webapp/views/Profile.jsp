<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "model.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<% 
		
		if (session.getAttribute("isLoggedIn") !=null) {
			UserBean user = (UserBean) session.getAttribute("isLoggedIn");
			out.print("<h1>Welcome to your profile " + user.getUserName() + "!</h1>");
			
			out.print("<form action=\"" + request.getContextPath() + "/RemoveSessionServlet\" method=\"POST\">");
			out.print("<input type=\"submit\" value=\"Log out\" />");
			out.print("</form>");
		} else {
			out.print("<h1>Error</h1>");
			response.sendRedirect("index.jsp");
		}
		%>

</body>
</html>
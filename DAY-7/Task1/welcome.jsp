<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%
    String user = (String) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("index.jsp"); // Redirect to login page if session is missing
        return; // Important to stop further execution
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome, <%= user %>!</h2>
    <p>Login successful.</p>
    <a href="logout.jsp">Logout</a> <!-- Clicking logout will clear session -->
</body>
</html>

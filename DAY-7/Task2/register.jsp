<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form action="RegisterServlet" method="post">
        <label>Name:</label>
        <input type="text" name="name1" required><br><br>

        <label>Email:</label>
        <input type="email" name="email1" required><br><br>

        <label>Password:</label>
        <input type="password" name="pass1" required><br><br>

        <label>Gender:</label>
        <input type="radio" name="gender1" value="Male" required> Male
        <input type="radio" name="gender1" value="Female" required> Female<br><br>

        <label>City:</label>
        <input type="text" name="city1" required><br><br>

        <input type="submit" value="Register">
    </form>

    <p>Already registered? <a href="login.jsp">Login Here</a></p>
</body>
</html>

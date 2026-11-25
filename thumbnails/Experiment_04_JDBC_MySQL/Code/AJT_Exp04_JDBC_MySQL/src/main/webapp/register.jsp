<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><title>User Registration</title></head>
<body>
    <h1>User Registration Form</h1>
    <% if (request.getAttribute("error") != null) { %>
        <p><strong><%= request.getAttribute("error") %></strong></p>
    <% } %>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <p><label>Name: <input type="text" name="name" required></label></p>
        <p><label>Email: <input type="email" name="email" required></label></p>
        <p><label>Password: <input type="password" name="password" required></label></p>
        <button type="submit">Register</button>
    </form>
    <p><a href="${pageContext.request.contextPath}/register">View registered users</a></p>
</body>
</html>


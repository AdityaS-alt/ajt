<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.dypatil.ajt.exp04.model.UserRecord" %>
<%!
    private String escapeHtml(String value) {
        return value == null ? "" : value.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><title>Registered Users</title></head>
<body>
    <h1>Registered Users</h1>
    <% if (request.getAttribute("message") != null) { %>
        <p><strong><%= escapeHtml(request.getAttribute("message").toString()) %></strong></p>
    <% } %>
    <table border="1" cellpadding="6">
        <thead><tr><th>ID</th><th>Name</th><th>Email</th></tr></thead>
        <tbody>
        <%
            List<UserRecord> users = (List<UserRecord>) request.getAttribute("users");
            if (users != null) {
                for (UserRecord user : users) {
        %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= escapeHtml(user.getName()) %></td>
                <td><%= escapeHtml(user.getEmail()) %></td>
            </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
    <p><a href="${pageContext.request.contextPath}/register.jsp">Register another user</a></p>
</body>
</html>


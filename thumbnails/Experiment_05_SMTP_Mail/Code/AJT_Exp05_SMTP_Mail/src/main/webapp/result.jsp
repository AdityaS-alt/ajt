<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%!
    private String escapeHtml(String value) {
        return value == null ? "" : value.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#39;");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><title>Email Result</title></head>
<body>
    <h1><%= Boolean.TRUE.equals(request.getAttribute("success")) ? "Email Sent" : "Email Not Sent" %></h1>
    <p><%= escapeHtml(String.valueOf(request.getAttribute("resultMessage"))) %></p>
    <p><a href="${pageContext.request.contextPath}/">Back to email form</a></p>
</body>
</html>


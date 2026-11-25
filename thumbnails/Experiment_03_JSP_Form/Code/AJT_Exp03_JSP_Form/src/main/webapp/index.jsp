<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%!
    private String escapeHtml(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSP Education Form</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String degree = request.getParameter("degree");
    String university = request.getParameter("university");
    boolean submitted = degree != null && university != null;

    if (!submitted) {
%>
    <h1>Enter Education Details</h1>
    <form action="index.jsp" method="post">
        <p><label>Degree: <input type="text" name="degree" required></label></p>
        <p><label>University: <input type="text" name="university" required></label></p>
        <button type="submit">Submit</button>
    </form>
<%
    } else {
%>
    <h1>Education Details Received</h1>
    <p><strong>Degree:</strong> <%= escapeHtml(degree) %></p>
    <p><strong>University:</strong> <%= escapeHtml(university) %></p>
    <p><a href="index.jsp">Go back</a></p>
<%
    }
%>
</body>
</html>


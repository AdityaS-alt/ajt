<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><title>Send Email</title></head>
<body>
    <h1>Send Email with Jakarta Mail</h1>
    <form action="${pageContext.request.contextPath}/send-mail" method="post">
        <p><label>Recipient email: <input type="email" name="recipient" required></label></p>
        <p><label>Subject: <input type="text" name="subject" value="AJT Lab Test" required></label></p>
        <p><label>Message:<br><textarea name="body" rows="6" cols="45" required>Hello from AJT Experiment 5.</textarea></label></p>
        <button type="submit">Send Email</button>
    </form>
</body>
</html>


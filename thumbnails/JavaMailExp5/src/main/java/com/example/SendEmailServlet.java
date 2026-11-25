
package com.example;

import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.*;

@WebServlet("/sendEmail")
public class SendEmailServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        final String username = "bitesfilm097@gmail.com";
        final String password = System.getenv("GMAIL_APP_PASSWORD");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(to)
            );

            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

            response.getWriter().println(
                "<h2>Email Sent Successfully!</h2>"
            );

        } catch (MessagingException e) {
            response.getWriter().println(
                "<h2>Error Sending Email</h2>"
            );
            response.getWriter().println(e.getMessage());
        }
    }
}
/* Click Start and search for Environment Variables.
Open Edit the system environment variables.
Click Advanced → Environment Variables.
Under User Variables, click New.
Enter:
- Variable Name: GMAIL_APP_PASSWORD
- Variable Value: Your App Password (stgvgcjhothonwuc).
Click OK → OK → OK.,Restart Eclipse.
Restart Tomcat and run the project.*/


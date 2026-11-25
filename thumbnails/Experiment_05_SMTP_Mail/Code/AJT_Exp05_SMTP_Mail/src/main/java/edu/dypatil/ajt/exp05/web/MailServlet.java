package edu.dypatil.ajt.exp05.web;

import java.io.IOException;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/send-mail")
public class MailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");
        String smtpUser = env("AJT_SMTP_USER", "");
        String smtpPassword = env("AJT_SMTP_PASSWORD", "");
        String fromAddress = env("AJT_SMTP_FROM", smtpUser);

        if (isBlank(recipient) || isBlank(subject) || isBlank(body)) {
            showResult(request, response, false, "Recipient, subject, and message are required.");
            return;
        }
        if (isBlank(smtpUser) || isBlank(smtpPassword) || isBlank(fromAddress)) {
            showResult(request, response, false,
                    "SMTP credentials are not configured. Set AJT_SMTP_USER, AJT_SMTP_PASSWORD, and AJT_SMTP_FROM in the Tomcat environment.");
            return;
        }

        Properties properties = new Properties();
        properties.put("mail.smtp.host", env("AJT_SMTP_HOST", "smtp.gmail.com"));
        properties.put("mail.smtp.port", env("AJT_SMTP_PORT", "587"));
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", env("AJT_SMTP_STARTTLS", "true"));
        properties.put("mail.smtp.starttls.required", env("AJT_SMTP_STARTTLS", "true"));
        properties.put("mail.smtp.ssl.enable", env("AJT_SMTP_SSL", "false"));
        properties.put("mail.smtp.connectiontimeout", "10000");
        properties.put("mail.smtp.timeout", "10000");
        properties.put("mail.smtp.writetimeout", "10000");

        try {
            Session mailSession = Session.getInstance(properties);
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(fromAddress, true));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient.trim(), true));
            message.setSubject(subject.trim(), "UTF-8");
            message.setText(body, "UTF-8");
            Transport.send(message, smtpUser, smtpPassword);
            showResult(request, response, true, "Email sent successfully to " + recipient.trim());
        } catch (MessagingException exception) {
            showResult(request, response, false,
                    "Email could not be sent. Check the SMTP host, port, encryption setting, username, password or app password, and network access. Server message: "
                            + safeMessage(exception.getMessage()));
        }
    }

    private void showResult(HttpServletRequest request, HttpServletResponse response, boolean success, String message)
            throws ServletException, IOException {
        request.setAttribute("success", success);
        request.setAttribute("resultMessage", message);
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    private String env(String name, String defaultValue) {
        String value = System.getenv(name);
        return value == null || value.isBlank() ? defaultValue : value;
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    private String safeMessage(String value) {
        if (value == null || value.isBlank()) {
            return "No additional details returned.";
        }
        return value.replace("<", "[").replace(">", "]");
    }
}


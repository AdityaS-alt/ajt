package edu.dypatil.ajt.exp02.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/education")
public class EducationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        String degree = request.getParameter("degree");
        String university = request.getParameter("university");
        String name = text(session.getAttribute("name"));
        String age = text(session.getAttribute("age"));
        String email = text(session.getAttribute("email"));
        String phone = text(session.getAttribute("phone"));
        session.invalidate();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Final User Information</title></head><body>");
        out.println("<h1>Final User Information</h1>");
        out.println("<p>Name: " + escapeHtml(name) + "</p>");
        out.println("<p>Age: " + escapeHtml(age) + "</p>");
        out.println("<p>Email: " + escapeHtml(email) + "</p>");
        out.println("<p>Phone: " + escapeHtml(phone) + "</p>");
        out.println("<p>Degree: " + escapeHtml(degree) + "</p>");
        out.println("<p>University: " + escapeHtml(university) + "</p>");
        out.println("<p><a href='" + request.getContextPath() + "/'>Start again</a></p>");
        out.println("</body></html>");
    }

    private String text(Object value) {
        return value == null ? "" : value.toString();
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;")
                .replace("\"", "&quot;").replace("'", "&#39;");
    }
}


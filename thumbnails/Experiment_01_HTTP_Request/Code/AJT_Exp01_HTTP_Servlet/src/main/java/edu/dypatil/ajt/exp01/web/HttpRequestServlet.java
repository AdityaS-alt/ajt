package edu.dypatil.ajt.exp01.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class HttpRequestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showResponse(request, response, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        showResponse(request, response, "POST");
    }

    private void showResponse(HttpServletRequest request, HttpServletResponse response, String method)
            throws IOException {
        String name = request.getParameter("name");
        if (name == null || name.isBlank()) {
            name = "Student";
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>HTTP Request Result</title></head><body>");
        out.println("<h1>Hello, " + escapeHtml(name) + "!</h1>");
        out.println("<p>The servlet handled an HTTP " + method + " request.</p>");
        out.println("<p>Request URI: " + escapeHtml(request.getRequestURI()) + "</p>");
        out.println("<p><a href='" + request.getContextPath() + "/'>Back to form</a></p>");
        out.println("</body></html>");
    }

    private String escapeHtml(String value) {
        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}


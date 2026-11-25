package edu.dypatil.ajt.exp04.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.dypatil.ajt.exp04.config.DbConfig;
import edu.dypatil.ajt.exp04.model.UserRecord;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INSERT_SQL = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
    private static final String SELECT_SQL = "SELECT id, name, email FROM users ORDER BY id DESC";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        showUsers(request, response, null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isBlank(name) || isBlank(email) || isBlank(password)) {
            request.setAttribute("error", "All fields are required.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        try (Connection connection = DbConfig.openConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_SQL)) {
            statement.setString(1, name.trim());
            statement.setString(2, email.trim());
            statement.setString(3, password);
            statement.executeUpdate();
            showUsers(request, response, "Registration saved successfully.");
        } catch (SQLException exception) {
            throw new ServletException("Database operation failed. Check MySQL setup and credentials.", exception);
        }
    }

    private void showUsers(HttpServletRequest request, HttpServletResponse response, String message)
            throws ServletException, IOException {
        List<UserRecord> users = new ArrayList<>();
        try (Connection connection = DbConfig.openConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_SQL);
                ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                users.add(new UserRecord(result.getInt("id"), result.getString("name"), result.getString("email")));
            }
        } catch (SQLException exception) {
            throw new ServletException("Could not read users. Check MySQL setup and credentials.", exception);
        }

        request.setAttribute("users", users);
        request.setAttribute("message", message);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }

    private boolean isBlank(String value) {
        return value == null || value.isBlank();
    }
}


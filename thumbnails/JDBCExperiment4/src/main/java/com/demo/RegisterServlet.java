
package com.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String course = request.getParameter("course");

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jdbc_demo",
                "root",
                "root"//passwordmysql
            );

            // Insert student details
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO student VALUES (?, ?, ?, ?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, course);

            ps.executeUpdate();

            response.setContentType("text/html");
            response.getWriter().println(
                "<h2>Student Registered Successfully!</h2>");

            ps.close();
            con.close();

        } catch (Exception e) {
            response.setContentType("text/html");
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}
/*
1. Login to MySQL
mysql -u root -p
2. Create Database
CREATE DATABASE jdbc_demo;
3. Select Database
USE jdbc_demo;
4. Create Table
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    course VARCHAR(50)
);
5. Insert Records
INSERT INTO student VALUES
(1, 'Vaishnavi', 20, 'CSE'),
(2, 'Rahul', 21, 'IT'),
(3, 'Priya', 20, 'CSE');
6. Display Records
SELECT * FROM student;
7. Check Table Structure
DESC student;
*/
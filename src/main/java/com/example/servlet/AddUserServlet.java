package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    //AddUserServlet should: navigate to /add page
    //when adding a new user should:
    //receive 2 params: firstName, lastName
    //save user in Warehouse
    //return request attribute "user"
    //navigate to /add page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = Instant.now().toString() + request.getParameter("firstName");
        String lastName = Instant.now().toString() + request.getParameter("lastName");

        User user = new User(firstName, lastName);
        Warehouse.addUser(user);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }
}

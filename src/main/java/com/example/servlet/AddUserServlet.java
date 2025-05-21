package com.example.servlet;

import com.example.User;

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
        String firstName = Instant.now().toString() + "firstName";
        String lastName = Instant.now().toString() + "lastName";

        User user = new User(firstName, lastName);
        Warehouse.addUser(user);

        request.setAttribute("user", user);
//        request
//                .getRequestDispatcher("/add.jsp")
//                .forward(request, response);

        javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        } else {
            // For test environments or fallback
            response.getWriter().println("User: " + user.getFirstName() + " " + user.getLastName());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    }
}

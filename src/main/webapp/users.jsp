<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="java.util.Set, com.example.User" %>
<%
    Set<User> users = (Set<User>) request.getAttribute("users");
%>
<html><body>
    <h2>All Users</h2>
    <ul>
        <% for (User user : users) { %>
            <li><%= user.getFirstName() %> <%= user.getLastName() %></li>
        <% } %>
    </ul>
</body></html>

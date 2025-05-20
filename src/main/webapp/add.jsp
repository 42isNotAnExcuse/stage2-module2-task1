<%@ page import="com.example.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<html><body>
    <h2>User Added</h2>
    <p><%= user.getFirstName() %> <%= user.getLastName() %></p>
    <a href="index.jsp">Back</a>
</body></html>
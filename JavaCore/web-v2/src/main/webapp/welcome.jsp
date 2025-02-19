<%--
  Created by IntelliJ IDEA.
  User: DOXUANTRUONG
  Date: 2/13/2025
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<%@ page import="model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
    }
%>
<h1>Welcome, <%= user.getUsername() %></h1>
<a href="logout">Logout</a>
<a href="product">Product</a>
</body>
</html>

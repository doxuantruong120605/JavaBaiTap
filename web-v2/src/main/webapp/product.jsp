<%--
  Created by IntelliJ IDEA.
  User: DOXUANTRUONG
  Date: 2/13/2025
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Page</title>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: Arial, sans-serif;--%>
<%--            margin: 0;--%>
<%--            padding: 0;--%>
<%--            background-color: #f8f9fa;--%>
<%--        }--%>
<%--        .container {--%>
<%--            width: 80%;--%>
<%--            margin: 20px auto;--%>
<%--        }--%>
<%--        .product-grid {--%>
<%--            display: flex;--%>
<%--            flex-wrap: wrap;--%>
<%--            gap: 20px;--%>
<%--            justify-content: center;--%>
<%--        }--%>
<%--        .product-card {--%>
<%--            width: 300px;--%>
<%--            border: 1px solid #ddd;--%>
<%--            border-radius: 10px;--%>
<%--            padding: 15px;--%>
<%--            text-align: center;--%>
<%--            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);--%>
<%--            background: white;--%>
<%--            transition: transform 0.3s ease-in-out;--%>
<%--        }--%>
<%--        .product-card:hover {--%>
<%--            transform: translateY(-5px);--%>
<%--        }--%>
<%--        .product-img {--%>
<%--            width: 100%;--%>
<%--            height: 200px;--%>
<%--            object-fit: cover;--%>
<%--            border-radius: 10px;--%>
<%--        }--%>
<%--        .product-description {--%>
<%--            font-size: 14px;--%>
<%--            color: #333;--%>
<%--            margin-top: 10px;--%>
<%--            white-space: normal;--%>
<%--            overflow: hidden;--%>
<%--            text-overflow: ellipsis;--%>
<%--            display: -webkit-box;--%>
<%--            -webkit-line-clamp: 3;--%>
<%--            -webkit-box-orient: vertical;--%>
<%--        }--%>
<%--    </style>--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-card {
            border: 1px solid #ddd;
            border-radius: 10px;
            margin-bottom: 22px;
            padding: 15px;
            text-align: center;
            box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.1);
        }
        .product-img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 10px;
        }
        .product-description {
            white-space: normal;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<%--<%@ page import="model.Product" %>--%>
<%--<%@ page import="java.util.List" %>--%>

<%--<%--%>
<%--    List<Product> products = (List<Product>) request.getAttribute("products");--%>
<%--%>--%>
<%--<div class="container">--%>
<%--    <h1 class="title">Danh sách sản phẩm</h1>--%>
<%--    <div class="product-grid">--%>
<%--        <% for (Product product : products) { %>--%>
<%--        <div class="product-card">--%>
<%--            <img src="<%= product.getPavatar() %>" alt="Product Image" class="product-img">--%>
<%--            <h5><%= product.getPname() %></h5>--%>
<%--            <p class="text-muted">Giá: $<%= product.getPrice() %></p>--%>
<%--            <p class="product-description"><%= product.getDescription() %></p>--%>
<%--        </div>--%>
<%--        <% } %>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>--%>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<a href="addProject.jsp">Add Project</a>
<div class="container mt-4">
    <div class="row">
        <% for (Product product : products) { %>
        <div class="col-md-2" style="width: 20%;" v-for="i in 5">
            <div class="product-card">
                <a href="productDetail?id=<%= product.getId() %>">
                    <img src="<%= product.getPavatar() %>" alt="Product Image" class="product-img">
                </a>
                <h5 class="mt-2"><%= product.getPname() %></h5>
                <p class="text-muted"><%= product.getPrice() %></p>
                <p class="product-description"><%= product.getDescription() %></p>
            </div>
        </div>
        <% } %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

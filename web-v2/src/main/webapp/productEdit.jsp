<%--
  Created by IntelliJ IDEA.
  User: DOXUANTRUONG
  Date: 2/14/2025
  Time: 2:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Edit Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@ page import="model.Product" %>

<%
    Product product = (Product) request.getAttribute("product");
%>

<div class="container mt-4">
    <h2>Edit Product</h2>
    <form action="product" method="post">
        <input type="hidden" name="id" value="<%= product.getId() %>">
        <div class="mb-3">
            <label for="pname" class="form-label">Product Name</label>
            <input type="text" class="form-control" id="pname" name="pname" value="<%= product.getPname() %>" required>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <textarea class="form-control" id="description" name="description" required><%= product.getDescription() %></textarea>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="number" class="form-control" id="price" name="price" value="<%= product.getPrice() %>" required>
        </div>
        <div class="mb-3">
            <label for="pavatar" class="form-label">Image URL</label>
            <input type="text" class="form-control" id="pavatar" name="pavatar" value="<%= product.getPavatar() %>" required>
        </div>
        <div class="mb-3">
            <label for="porigin" class="form-label">Origin</label>
            <input type="text" class="form-control" id="porigin" name="porigin" value="<%= product.getPorigin() %>" required>
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Category</label>
            <input type="text" class="form-control" id="category" name="category" value="<%= product.getCategory() %>" required>
        </div>
        <div class="mb-3">
            <label for="storage" class="form-label">Storage</label>
            <input type="text" class="form-control" id="storage" name="storage" value="<%= product.getStorage() %>" required>
        </div>
        <div class="mb-3">
            <label for="color" class="form-label">Color</label>
            <input type="text" class="form-control" id="color" name="color" value="<%= product.getColor() %>" required>
        </div>
        <button type="submit" class="btn btn-primary">Save Changes</button>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
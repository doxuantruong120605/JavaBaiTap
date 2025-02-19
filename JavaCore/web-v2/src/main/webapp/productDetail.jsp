<%--
  Created by IntelliJ IDEA.
  User: DOXUANTRUONG
  Date: 2/14/2025
  Time: 1:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Product Detail</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
  <style>
    body {
      background-color: #f8f9fa;
      font-family: 'Arial', sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }
    .container {
      max-width: 900px;
      margin-top: 20px;
      position: relative;
      padding: 20px;
    }
    .product-image {
      border-radius: 10px;
    }
    .price {
      font-size: 24px;
      font-weight: bold;
      color: #e60000;
    }
    .btn-buy {
      background-color: #ff5722;
      border: none;
      color: white;
      font-size: 18px;
    }
    .btn-buy:hover {
      background-color: #e64a19;
    }
    img {
      image-rendering: crisp-edges; /* Chrome, Edge */
      image-rendering: pixelated;   /* Firefox */
    }
    .icon-btn {
      background: none;
      border: none;
      cursor: pointer;
      font-size: 20px;
      color: #333;
    }
    .icon-btn:hover {
      color: #e60000;
    }
    .back-btn {
      position: absolute;
      top: 10px;
      left: 10px;
      font-size: 24px;
      color: #333;
      text-decoration: none;
    }
    .back-btn:hover {
      color: #e60000;
    }
  </style>
</head>
<body>
<%@ page import="model.Product" %>

<%
  Product product = (Product) request.getAttribute("product");
%>

<div class="container bg-white p-4 shadow rounded">
  <a href="product" class="back-btn"><i class="fas fa-arrow-left"></i></a>
  <div class="row">
    <!-- Hình ảnh sản phẩm -->
    <div class="col-md-6">
      <div id="productCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="<%= product.getPavatar()%>" class="d-block w-100 product-image" alt="Sản phẩm">
          </div>
          <div class="carousel-item">
            <img src="<%= product.getPavatar()%>" class="d-block w-100 product-image" alt="Sản phẩm">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#productCarousel" data-bs-slide="prev">
          <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#productCarousel" data-bs-slide="next">
          <span class="carousel-control-next-icon"></span>
        </button>
      </div>
    </div>
    <!-- Thông tin sản phẩm -->
    <div class="col-md-6">
      <div class="d-flex justify-content-between align-items-center">
        <h2 class="fw-bold"><%= product.getPname()%></h2>
        <div>
          <a href="productEdit?id=<%= product.getId() %>" class="icon-btn"><i class="fas fa-edit"></i></a>
          <form id="delete-form" action="product" method="post" style="display: none;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="id" value="<%= product.getId() %>">
          </form>
          <button class="icon-btn" onclick="document.getElementById('delete-form').submit();">
            <i class="fas fa-trash-alt"></i>
          </button>
        </div>
      </div>
      <p class="text-muted"><%= product.getPorigin()%></p>
      <p class="price"><%= product.getPrice()%></p>
      <p><strong>Tồn kho:</strong> <%= product.getPtotal()%></p>
      <p><strong>Bộ nhớ:</strong> <%= product.getStorage()%></p>
      <p><strong>Màu sắc:</strong> <%= product.getColor()%></p>
      <p><strong>Loại:</strong> <%= product.getCategory()%></p>
      <p><%= product.getDescription()%></p>
      <form id="buy-form" action="productDetail" method="post">
        <input type="hidden" name="action" value="buy">
        <input type="hidden" name="id" value="<%= product.getId() %>">
        <button type="submit" class="btn btn-buy w-100 p-3 mt-2">Mua ngay</button>
      </form>
      <button class="btn btn-outline-danger w-100 p-3 mt-2">Thêm vào giỏ hàng</button>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<%--<div class="product-detail">--%>
<%--  <img src="<%= product.getPavatar() %>" alt="Product Image" class="product-img">--%>
<%--  <h2><%= product.getPname() %></h2>--%>
<%--  <p><strong>Price:</strong> $<%= product.getPrice() %></p>--%>
<%--  <p><strong>Origin:</strong> <%= product.getPorigin() %></p>--%>
<%--  <p><strong>Category:</strong> <%= product.getCategory() %></p>--%>
<%--  <p><strong>Storage:</strong> <%= product.getStorage() %></p>--%>
<%--  <p><strong>Color:</strong> <%= product.getColor() %></p>--%>
<%--  <p><strong>Description:</strong> <%= product.getDescription() %></p>--%>
<%--</div>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

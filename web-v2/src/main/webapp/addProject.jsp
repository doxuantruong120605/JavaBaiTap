<%--
  Created by IntelliJ IDEA.
  User: DOXUANTRUONG
  Date: 2/14/2025
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Project Page</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f4f6f9;
      font-family: 'Poppins', sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
      overflow: hidden;
    }
    .container {
      max-width: 700px;
      background: #ffffff;
      padding: 20px;
      border-radius: 15px;
      box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
      overflow-y: auto;
      max-height: 90vh;
    }
    h2 {
      font-weight: 700;
      color: #2c3e50;
      text-align: center;
      margin-bottom: 15px;
    }
    .btn-primary {
      background: #007bff;
      border: none;
      font-weight: 600;
      transition: 0.3s;
    }
    .btn-primary:hover {
      background: #0056b3;
    }
    .form-control, .form-select {
      border-radius: 10px;
      padding: 8px;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Thêm Sản Phẩm Mới</h2>
  <form action="product" method="post" >
    <input type="hidden" name="action" value="add">
    <div class="row">
      <div class="col-md-6 mb-2">
        <label class="form-label">Tên sản phẩm</label>
        <input type="text" class="form-control"  name="pname" required>
      </div>
      <div class="col-md-6 mb-2">
        <label  class="form-label">Ảnh sản phẩm</label>
        <input type="text" class="form-control"  name="pavatar">
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-2">
        <label class="form-label">Số lượng tồn kho</label>
        <input type="number" class="form-control"  name="ptotal" required>
      </div>
      <div class="col-md-6 mb-2">
        <label class="form-label">Giá bán</label>
        <input type="number" class="form-control"  name="price" required>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-2">
        <label  class="form-label">Xuất xứ</label>
        <input type="text" class="form-control"  name="porigin">
      </div>
      <div class="col-md-6 mb-2">
        <label  class="form-label">Phân loại</label>
        <select class="form-select"  name="category" required>
          <option value="Smartphone">Smartphone</option>
          <option value="Tablet">Tablet</option>
          <option value="Laptop">Laptop</option>
          <option value="Accessory">Accessory</option>
        </select>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6 mb-2">
        <label  class="form-label">Bộ nhớ</label>
        <input type="text" class="form-control"  name="storage">
      </div>
      <div class="col-md-6 mb-2">
        <label class="form-label">Màu sắc</label>
        <input type="text" class="form-control"  name="color">
      </div>
    </div>
    <div class="mb-2">
      <label  class="form-label">Mô tả sản phẩm</label>
      <textarea class="form-control"  name="description" rows="2"></textarea>
    </div>
    <button type="submit" class="btn btn-primary w-100">Thêm sản phẩm</button>
  </form>
  <a href="product">Quay lại danh sách</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

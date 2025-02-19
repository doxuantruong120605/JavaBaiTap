<%--
  Created by IntelliJ IDEA.
  User: DOXUANTRUONG
  Date: 2/12/2025
  Time: 6:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product Page</title>
</head>
<body>
<%@ page import="model.ProductDAO, model.Product" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    ProductDAO productDAO = new ProductDAO();
    Product product = productDAO.getProductById(id);
%>
<html>
<head>
    <title>Sửa sản phẩm</title>
</head>
<body>
<h2>Sửa sản phẩm</h2>
<form action="product" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= product.getId() %>">

    <label>Tên sản phẩm:</label>
    <input type="text" name="pname" value="<%= product.getPname() %>" required><br>

    <label>Ảnh sản phẩm (URL):</label>
    <input type="text" name="pavarta" value="<%= product.getPavarta() %>" required><br>

    <label>Số lượng:</label>
    <input type="number" name="ptotal" value="<%= product.getPtotal() %>" required><br>

    <label>Xuất xứ:</label>
    <input type="text" name="porigin" value="<%= product.getPorigin() %>" required><br>

    <label>Mô tả:</label>
    <textarea name="discription" required><%= product.getDiscription() %></textarea><br>

    <button type="submit">Cập nhật</button>
</form>
<a href="product">Quay lại danh sách</a>
</body>
</html>

</body>
</html>

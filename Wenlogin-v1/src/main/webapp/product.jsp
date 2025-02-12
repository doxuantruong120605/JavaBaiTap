<%--
  Created by IntelliJ IDEA.
  User: DOXUANTRUONG
  Date: 2/12/2025
  Time: 5:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Page</title>
</head>
<body>
<%@ page import="java.util.List, model.Product" %>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<a href="add-product.jsp">Thêm sản phẩm</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Ảnh</th>
        <th>Số lượng</th>
        <th>Xuất xứ</th>
        <th>Mô tả</th>
        <th>Hành động</th>
    </tr>
    <% for (Product p : products) { %>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getPname() %></td>
        <td><img src="<%= p.getPavarta() %>" width="50"></td>
        <td><%= p.getPtotal() %></td>
        <td><%= p.getPorigin() %></td>
        <td><%= p.getDiscription() %></td>
        <td>
            <a href="edit-product.jsp?id=<%= p.getId() %>">Sửa</a> |
            <form action="product" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= p.getId() %>">
                <button type="submit" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>

</body>
</html>

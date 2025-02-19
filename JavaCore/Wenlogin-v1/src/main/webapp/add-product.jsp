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
    <title>Add Product Page</title>
</head>
<body>

<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm</h2>
<form action="product" method="post">
    <input type="hidden" name="action" value="add">
    <label>Tên sản phẩm:</label>
    <input type="text" name="pname" required><br>

    <label>Ảnh sản phẩm (URL):</label>
    <input type="text" name="pavarta" required><br>

    <label>Số lượng:</label>
    <input type="number" name="ptotal" required><br>

    <label>Xuất xứ:</label>
    <input type="text" name="porigin" required><br>

    <label>Mô tả:</label>
    <textarea name="discription" required></textarea><br>

    <button type="submit">Thêm</button>
</form>
<a href="product">Quay lại danh sách</a>
</body>
</html>

</body>
</html>

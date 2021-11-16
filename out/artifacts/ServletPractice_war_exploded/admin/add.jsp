<%--
  Created by IntelliJ IDEA.
  User: vuong
  Date: 11/15/2021
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body style="padding: 5% 10%">
    <form method="post" action="save">
            <input type="hidden" name="id" value="${product.id}">
        <div class="mb-3">
            <label for="name" class="form-label">Product Name</label>
            <input type="text" class="form-control" name="name" id="name" value="${product.name}" placeholder="Product Name">
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Product Price</label>
            <input type="text" class="form-control" name="price" id="price" value="${product.price}" placeholder="Product Price">
        </div>
        <div class="mb-3">
            <label for="amount" class="form-label">Product Amount</label>
            <input type="number" class="form-control" name="amount" id="amount" value="${product.amount}" placeholder="Product Amount">
        </div>
        <div class="mb-3">
            <label for="detail" class="form-label">Product Detail</label>
            <input type="text" class="form-control" name="detail" id="detail" value="${product.detail}" placeholder="Product Detail">
        </div>
        <button type="submit">Save</button>
    </form>
</body>
</html>

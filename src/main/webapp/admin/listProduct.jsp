<%--
  Created by IntelliJ IDEA.
  User: vuong
  Date: 11/15/2021
  Time: 1:14 PM
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
    <div class="row">
        <div class="col-6">
            <h3>List</h3>
        </div>
        <div class="col-6">
            <a  href="LoginController" class="btn btn-primary text-end">Logout</a>
        </div>
    </div>

    <a  class="btn btn-primary" href="add">Add New</a>
    <table class="table">
        <thead>
        <tr>
            <th width="10%" scope="col">#</th>
            <th width="15%" scope="col">Product</th>
            <th width="15%" scope="col">Price</th>
            <th width="15%" scope="col">Price</th>
            <th width="15%" scope="col">Price</th>
            <th width="30%" scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="product" varStatus="loop">
            <tr>
                <th scope="row">${loop.index + 1}</th>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.amount}</td>
                <td>${product.detail}</td>
                <td>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                            Dropdown button
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                            <li><a class="dropdown-item" href="edit?id=${product.id}">Edit</a></li>
                            <li><a class="dropdown-item" onclick="return confirm('Bạn có chắc muốn xóa?')" href="delete?id=${product.id}">Delete</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</body>
</html>

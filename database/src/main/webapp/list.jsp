<%--
  Created by IntelliJ IDEA.
  User: banuprakash
  Date: 09/03/26
  Time: 2:19 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
<%--        <%--%>
<%--            for(Product product : (List<Product>)request.getAttribute("products")) {--%>
<%--                --%>
<%--            }--%>
<%--            --%>
<%--        %>--%>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.qty}</td>
            </tr>
        </c:forEach>
    </table>

    <a href="/">Back</a>
</body>
</html>

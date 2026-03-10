<%@ page import="java.util.List" %>
<%@ page import="com.visa.prj.entity.Product" %><%--
  Created by IntelliJ IDEA.
  User: banuprakash
  Date: 09/03/26
  Time: 2:36 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Product List</h1>
<%
//  String user = (String) session.getAttribute("user");
//  if( user == null) {
//    response.sendRedirect("login.html");
//  }
%>
<div>Welcome ${user} ,  <a href="logout">Logout</a></div>
<table border="1">
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Price</th>
  </tr>
  <%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for(Product p: products) {
  %>
  <tr>
    <td><%= p.getId() %></td>
    <td><%= p.getName() %></td>
    <td><%= p.getPrice() %></td>
  </tr>

  <%
    }
  %>
</table>

<a href="/">Back</a>

</body>
</html>

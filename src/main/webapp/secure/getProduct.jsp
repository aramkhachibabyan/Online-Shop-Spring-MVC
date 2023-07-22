<%@ page import="com.smartCode.springMvc.util.constants.Keyword" %>
<%@ page import="com.smartCode.springMvc.model.Product" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<style>
  table, th, td {
    border: 1px solid black;
  }
</style>
<head>
  <meta charset="UTF-8">
  <title>Get Product</title>
</head>
<body>
<a style="display: flex;justify-content: right" href="http://localhost:8080/secure/logout">Log out</a><br><br>
<%= request.getAttribute(Keyword.MESSAGE) == null ? "" : request.getAttribute(Keyword.MESSAGE)%>
<% Product product =(Product) request.getAttribute(Keyword.PRODUCT);%>

<form method="post" action="/secure/getProduct">
  id: <input type="number" name="id"/><br><br>
  <input type="submit"/><br><br>
</form>
<%if (product != null) {%>
<table style="width:100%">
  <tr>
    <th>Id</th>
    <th>Category</th>
    <th>Name</th>
    <th>Published year</th>
    <th>Price</th>
  </tr>
  <tr>
    <td><%= product.getId()%></td>
    <td><%= product.getCategory()%></td>
    <td><%= product.getName()%></td>
    <td><%= product.getPublishedDate()%></td>
    <td><%= product.getPrice()%></td>
  </tr>
  <%}%>
</table><br><br>
<a href="http://localhost:8080/secure/product.jsp">Product Page</a><br><br>
</body>
</html>

<%@ page import="java.util.List" %>
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
    <title>Product Page</title>
</head>
<body>
<a style="display: flex;justify-content: right" href="http://localhost:8080/secure/logout">Log out</a><br><br>
<%= request.getAttribute(Keyword.MESSAGE) == null ? "" : request.getAttribute(Keyword.MESSAGE)%>


<% List<Product> list = (List) request.getAttribute(Keyword.LIST);%>

<a href="http://localhost:8080/secure/createProduct.jsp">Create Product</a><br><br>
<a href="http://localhost:8080/secure/updateProduct.jsp">Update Product</a><br><br>
<a href="http://localhost:8080/secure/getProduct.jsp">Get Product</a><br><br>
<a href="http://localhost:8080/secure/deleteProduct.jsp">Delete Product</a><br><br>
<% if (list == null) {%>
<a href="http://localhost:8080/secure/productList">Open products</a><br><br>
<%} else {%>
<a href="http://localhost:8080/secure/product.jsp">Close products</a><br><br>
<table style="width:100%">
    <tr>
        <th>Id</th>
        <th>Category</th>
        <th>Name</th>
        <th>Published year</th>
        <th>Price</th>
    </tr>
    <%for (Product product : list) {%>
    <tr>
        <td><%= product.getId()%>
        </td>
        <td><%= product.getCategory()%>
        </td>
        <td><%= product.getName()%>
        </td>
        <td><%= product.getPublishedDate()%>
        </td>
        <td><%= product.getPrice()%>
        </td>
    </tr>
    <% }
    }%>
</table>
<a href="http://localhost:8080/secure/home.jsp">Home Page</a><br><br>
</body>
</html>

<%@ page import="com.smartCode.springMvc.util.constants.Keyword" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body style="background-color: limegreen">

<a style="display: flex;justify-content: right" href="http://localhost:8080/logout">Log out</a><br><br>

<h1>
    Home Page
</h1>

<%= request.getSession().getAttribute(Keyword.EMAIL) == null ? "" : "Welcome dear " + request.getSession().getAttribute(Keyword.EMAIL)%>
<br><br>


<a href="http://localhost:8080/secure/deleteAccaunt.jsp">Delete account</a><br><br>
<a href="http://localhost:8080/secure/changePassword.jsp">Change password</a><br><br>
<a href="http://localhost:8080/secure/product.jsp">Product page</a><br><br>

</body>
</html>

<%@ page import="com.smartCode.springMvc.util.constants.Keyword" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Accaunt</title>
</head>
<body>

<%= request.getAttribute(Keyword.MESSAGE) == null ? "" : request.getAttribute(Keyword.MESSAGE)%>

<form method="post" action="/secure/deleteAccaunt">
    Please verify your password: <input type="password" name="password"/><br><br>
    <input type="submit"/><br><br>

    <a href="http://localhost:8080/secure/home.jsp">Home Page</a><br><br>
</form>

</body>
</html>

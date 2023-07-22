<%@ page import="com.smartCode.springMvc.util.constants.Keyword" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Register</title>
</head>
<body>
<%= request.getAttribute(Keyword.MESSAGE) == null ? "" : request.getAttribute(Keyword.MESSAGE)%>


<h1>Please enter your information</h1>

<form method="post" action="/register">
  Name: <input type="text" name="name"/><br><br>
  Lastname: <input type="text" name="lastname"/><br><br>
  Email: <input type="text" name="email"/><br><br>
  Password: <input type="password" name="password"/><br><br>
  Age: <input type="number" name="age"/><br><br>
  <input type="submit"/>

</form>

</body>
</html>

<%@ page import="com.smartCode.springMvc.util.constants.Keyword" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
<a style="display: flex;justify-content: right" href="http://localhost:8080/secure/logout">Log out</a><br><br>
<%= request.getAttribute(Keyword.MESSAGE) == null ? "" : request.getAttribute(Keyword.MESSAGE)%>

<form method="post" action="/secure/changePassword">
  New password: <input type="password" name="newPassword"/><br><br>
  Repeat password: <input type="password" name="repeatPassword"/><br><br>
  <input type="submit"/><br><br>
</form>
<a href="http://localhost:8080/secure/home.jsp">Home Page</a><br><br>


</body>
</html>

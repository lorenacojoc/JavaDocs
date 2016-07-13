<%--
  Created by IntelliJ IDEA.
  User: Lorena
  Date: 7/13/2016
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HTTP Session</title>
</head>
<body>

<form name="login" method="post" action="<%=request.getContextPath() %>/login">

    <label for="username">Username:</label>
    <input type="text" id="username" name="username"/>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password"/>

    <input type="submit" id="submitButton"/>
</form>


</body>
</html>

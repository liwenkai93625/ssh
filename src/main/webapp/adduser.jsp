<%--
  Created by IntelliJ IDEA.
  User: lianjia
  Date: 2017-5-2
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<!-- 获取相关路径 -->
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() +
            ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add New User</title>
</head>
<body>
<center>
    <h1> Add User</h1><br>
    user id cannot be null or same as others

    <form action="user!addUser.action" method="post">
        user id<input type="text" name="user.id"/><br>
        user name<input type="text" name="user.name"/><br>
        company<input type="text" name="user.company"/><br>
        <input type="submit" value="Add"/>
    </form>
</center>
</body>
</html>

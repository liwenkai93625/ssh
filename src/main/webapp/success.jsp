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

<!-- c标签，后面会使用到 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome</title>

    <style type="text/css">
        td {
            text-align: center;
            width: 100px;
        }
    </style>

</head>
<body>
<!-- checkUser Action返回user1,这里就可以得到用户名 -->
<div align="right">
    Welcome,${user1.name } | <a href="logout.jsp">Exit</a>
</div>
<center>
    <table border="1">
        <tr>
            <td>user id</td>
            <td>user name</td>
            <td>company</td>
            <td colspan="2" style="center">Options</td>
        </tr>

        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.company}</td>
                <td><a href="user!deleteUser.action?user.id=${u.id}">Delete</a></td>
                <td><a href="user!updateUser.action?user.id=${u.id}">Modify</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>

    <!-- 添加用户按钮 -->
    <input type="submit" value="Add User" onclick="window.location.href='adduser.jsp'"/>
</center>
<br>
<br>
<br>
<br>

<center>
    <form action="user!queryUser.action" method="post">
        user name<input type="text" name="user.name"/>&nbsp;&nbsp;&nbsp;&nbsp;
        company<input type="text" name="user.company"/>&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit" value="Search"/>
    </form>
</center>
<br>
<br>
<br>
<br>

<!-- tag>0表示查询结果正常 -->
<c:if test="${tag > 0}">
    <center>
        <table border="1">
            <!-- 查询结果也以表格形式展现 -->
            <tr>
                <td>user id</td>
                <td>user name</td>
                <td>company</td>
            </tr>
            <!-- users2就是UserAction中的queryUser()返回的结果，
             同样是遍历 -->
            <c:forEach items="${users2}" var="u">
                <tr>
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>${u.company}</td>
                </tr>
            </c:forEach>
        </table>
    </center>
</c:if>
</body>
</html>

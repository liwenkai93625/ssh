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
session.invalidate();
response.sendRedirect("login.jsp");
%>


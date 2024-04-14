<%@ page import="pojo.Userinfo" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/6
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Userinfo> list = (List<Userinfo>) request.getAttribute("list");
%>
<%for(Userinfo userInfo:list){%>
<%=userInfo%><a href="user.do?p=delbyusername&username=<%=userInfo.getUsername()%>">删除</a><br>
<%}%>
</body>
</html>

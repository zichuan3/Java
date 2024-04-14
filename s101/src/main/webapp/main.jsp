<%@ page import="pojo.Userinfo" %>
<%@ page import="java.util.List" %>
<%@ page import="pojo.Goods" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/9
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    List<Goods> list = (List<Goods>) request.getAttribute("list");
%>
<%for(Goods goods:list){%>
<%=goods.getGoodsid()%>
<%=goods.getGoodsname()%>
<img style="width: 200px;height: 200px" src="image/<%=goods.getGoodspic()%>">
<%}%>
</body>
</html>

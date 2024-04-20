<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/19
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <tr>
    <td>商品编号</td>
    <td>商品名称</td>
    <td>购买数量</td>
    <td>商品价格</td>
    <td>操作</td>
  </tr>
  <c:forEach items="${map}" var="m" >
    <tr>
      <td>${m.value.goodsid}</td>
      <td>${m.value.goodsname}</td>
      <td>${m.value.goodscount}</td>
      <td>${m.value.goodsprice}</td>
      <td>
        <a>删除</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

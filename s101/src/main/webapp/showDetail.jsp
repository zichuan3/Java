<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/19
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${goods.goodsid}
${goods.goodsname}
${goods.goodspic}
${goods.goodsdesc}
<img src="image/${goods.goodspic}">
<input type="text" value="1" id="num">
<a href="javascript:void(0)" onclick="addCar()">加入购物车</a>
</body>
</html>
<script>
  function addCar(){
    var num = document.getElementById("num").value ;
    location = "goods.do?p=addCar&goodsid=${goods.goodsid}&num="+num ;
  }
</script>
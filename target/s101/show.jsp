<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/6
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
名称:<input type="text" value="${map.goodsname}" id="name">
价格:<input type="text" value="${map.bottom}" id="bottom">-<input type="text" value="${map.top}" id="top">
<input type="button" value="搜索" onclick="querys()"><br>
<c:forEach items="${map.list}" var="goods">
    ${goods.goodsid}${goods.goodsname}
    <a href="goods.do?p=findbyid&goodsid=${goods.goodsid}" title="查看详情"><img src="image/${goods.goodspic}"></a>
    <br>
</c:forEach>
<a href="goods.do?p=query&page=1&size=${map.size}">首页</a>
<a href="goods.do?p=query&page=${map.page==1?map.page:map.page-1}&size=${map.size}">上一页</a>
<a href="goods.do?p=query&page=${map.page==map.pageCount?map.page:map.page+1}&size=${map.size}">下一页</a>
<a href="goods.do?p=query&page=${map.pageCount}&size=${map.size}">尾页</a>
</body>
</html>

<script>
    function querys(){
        var name = document.getElementById("name").value;
        var bottom = document.getElementById("bottom").value ;
        var top = document.getElementById("top").value ;
        location = "goods.do?p=query&page=1&goodsname="+name+"&bottom="+bottom+"&top="+top;
    }
</script>
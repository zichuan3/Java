<%@ page import="pojo.Userinfo" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="pojo.Goods" %>
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
    Map map = (Map) request.getAttribute("map");
    List<Goods> list = (List<Goods>) map.get("list");
%>
<%
    for(Goods goods:list){
%>
<%=goods.getGoodspic()%>
<%=goods.getGoodsid()%>


<%}%>
<a href="goods.do?p=getpage&page=1&size=<%=map.get("size")%>">首页</a>
<a href="goods.do?p=getpage&page=<%=(int)map.get("page")==1?(int)map.get("page"):(int)map.get("page")-1%>&size=<%=map.get("size")%>">上一页</a>
<a href="goods.do?p=getpage&page=<%=map.get("page")==map.get("pagecount")?(int)map.get("page"):(int)map.get("page")+1%>&size=<%=map.get("size")%>">下一页</a>
<a href="goods.do?p=getpage&page=<%=(int)map.get("pagecount")%>&size=<%=map.get("size")%>">尾页</a>
</body>
</html>

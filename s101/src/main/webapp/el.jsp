<%@ page import="pojo.Userinfo" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/19
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Userinfo userinfo = new Userinfo();
    userinfo.setUsername("sunjob");
    userinfo.setPassword("sunjob");
    request.setAttribute("userinfo" , userinfo);
%>
<%
    request.setAttribute("a", 10);
    session.setAttribute("a", 20);
    application.setAttribute("a", 30);
%>
${a}<br>
${sessionScope.a}<br>
${userinfo}<br>
${userinfo.username}<br>
${userinfo.getUsername()}<br>
<%
    String[] strings = {"aa" , "bb" , "cc"};
    request.setAttribute("strings" , strings);
%>

${strings[0]}
<%
Map map = new HashMap();
map.put("age" , "18");
map.put("gender" , "男");
map.put("first-name" , "jack");
request.setAttribute("sex" , "gender");
request.setAttribute("map" , map);
%>

${map.age}
${map["age"]}
${map["first-name"]}
${map[sex]}
</body>
</html>

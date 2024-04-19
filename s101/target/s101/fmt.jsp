<%@ page import="java.util.Date" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    Date date = new Date();
    request.setAttribute("date" , date);
    float f = 1.23456f ;
    request.setAttribute("f" , f);
%>

<body>
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd hh:mm:ss" ></fmt:formatDate>
<fmt:formatNumber value="${f}" pattern=".###"></fmt:formatNumber>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/19
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    .odd{
        background-color: green;
    }
    .even{
        background-color: red;
    }

</style>
<%
    String[] strings = {"aa" , "bb" , "cc"};
    request.setAttribute("strings" , strings);
%>
<body>
<c:set var="x" value="10" scope="session"></c:set>
${x}
<c:out value="${x}"></c:out>
<c:remove var="x"></c:remove>
${x}
<c:set value="1" var="gender"></c:set>
<c:if test="${gender==1}" var="flag">
    男
</c:if>
<c:if test="${not flag}">
    女
</c:if>
<c:set var="score" value="80"></c:set>
<c:choose>
    <c:when test="${score>=90 && score<=100}">优秀</c:when>
    <c:when test="${score>=60 && score<90}">及格</c:when>
    <c:otherwise>不及格</c:otherwise>
</c:choose>
<c:forEach begin="1" end="100" step="1" var="i">
    ${i}
</c:forEach>

<c:forEach items="${strings}" var="s" varStatus="sta">
    ${s}${sta.index}
</c:forEach>
<table>
    <c:forEach items="${strings}" var="s" varStatus="sta">
        <tr class="${sta.index%2==0 ? 'even':'odd'}">
            <td>${s}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

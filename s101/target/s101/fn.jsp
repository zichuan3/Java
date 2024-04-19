<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    String s = "abcdefg";
    request.setAttribute("s", s);
%>

<body>
${fn:length(s)}
${fn:substring(s,3 , 5)}
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/5/14
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img id="img" src="image.do" title="看不起,换一张" onclick="changes()">
</body>
</html>
<script>
    var x = 0;
    function changes(){
        document.getElementById("img").src = "image.do?x="+x;
        x++;
    }
</script>

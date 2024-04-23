<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/23
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form >
    用户名:<input type="text" name="username" onblur="checkusername(this)"><span id="flag"></span><br>
</form>
</body>
</html>
<script>
    function checkusername(txt){
        var username = txt.value ;
        var request = new XMLHttpRequest();//通过js创建一个请求对象
        request.open("get" , "user.do?p=checkusername&username="+username);
        request.send(null);
        request.onreadystatechange = function(){
            //  request.readyState==4 表示请求正确的发出
            //  request.status==200   收到了正确的响应
            if(request.readyState==4 && request.status==200){
                var ret = request.responseText ;//接受服务器返回的结果
                if(ret.trim()=="true"){
                    document.getElementById("flag").innerText = "√";
                }else{
                    document.getElementById("flag").innerText = "×";
                }
            }
        }
    }
</script>
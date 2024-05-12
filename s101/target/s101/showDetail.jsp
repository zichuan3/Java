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
<button onclick="collection()" value="收藏" style="height: 20px;width: 80px;" name="收藏2">收藏</button>
</body>
</html>
<script>
    function addCar() {
        var num = document.getElementById("num").value;
        location = "goods.do?p=addCar&goodsid=${goods.goodsid}&num=" + num;
    }
    function collection() {
        var request = new XMLHttpRequest();
        request.open("get", "user.do?p=collection&goodsid=${goods.goodsid}");
        request.send(null);
        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                var ret = request.responseText;
                console.log("ret::::",ret);
                if (ret == null || ret == ""){
                    console.log("收藏成功")
                }else {
                    ret = JSON.parse(ret);
                    console.log(ret)
                    let gooodsid = ret["goodsid"];
                    if (gooodsid!=null){
                        console.log("没有登录，先进入登录页面")
                        location = "login.jsp";
                    }
                }
            }
        }

    }
</script>
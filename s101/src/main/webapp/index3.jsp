<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/4/23
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
部门:<select id="dep" onchange="findEmpByDid()">
</select>
员工:<select id="emp">
</select>
</body>
</html>
<script>
    //界面加载事件
    onload = function () {
        var request = new XMLHttpRequest();
        //同步实现
        request.onreadystatechange = function () {
            if (request.readyState == 4 && request.status == 200) {
                var ret = request.responseText;//获取响应待会来的文本
                var json = JSON.parse(ret);
                console.log(ret, json)
                for (var i = 0; i < json.length; i++) {
                    var option = new Option(json[i].depname, json[i].depid);
                    document.getElementById("dep").appendChild(option);
                }
            }
        }
        // ajax  通过js  向服务器发起请求
        request.open("get", "dep.do?p=findall",false);
        request.send(null);

        findEmpByDid();
        // 异步实现
        // request.onreadystatechange = function(){
        //     if(request.readyState==4 && request.status==200){
        //         var ret = request.responseText;//获取响应待会来的文本
        //         var json = JSON.parse(ret);
        //         console.log(ret,json)
        //         for(var i = 0 ;i<json.length ;i++){
        //             var option = new Option(json[i].depname , json[i].depid);
        //             document.getElementById("dep").appendChild(option);
        //         }
        //         findEmpByDid();//调用函数查找员工
        //     }
        // }
    }
    function findEmpByDid() {
        var request = new XMLHttpRequest();
        var depid = document.getElementById("dep").value;
        console.log(depid)
        request.open("get", "emp.do?p=findEmpByDepid&depid=" + depid);
        request.send(null);

        function selectemp() {
            if (request.readyState == 4 && request.status == 200) {
                var ret = request.responseText;//获取响应待会来的文本
                document.getElementById("emp").innerHTML = "";
                console.log("清除emp")
                console.log(ret, "查询emp");
                var json = JSON.parse(ret);
                for (var i = 0; i < json.length; i++) {
                    var option = new Option(json[i].empname, json[i].empid);
                    document.getElementById("emp").appendChild(option);
                }
            }
        }
        request.onreadystatechange = selectemp
    }
</script>

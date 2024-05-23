<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2024/5/15
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="user.do?p=register" id="registerFrom">
    用户名:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="text" id="captchaInput" placeholder="验证码">
    <img id="img" src="image.do?x=0" title="看不起,换一张" onclick="changes()">
    <p id="errorMessage"></p>
    <input id="register" type="submit" value="注册" disabled>
</form>
</body>
</html>
<script>
    x = Math.random();
    onload = changes;
    function changes() {
        document.getElementById("img").src = "image.do?x=" + x;
        x++;
    }

    document.getElementById('captchaInput').addEventListener('input', function () {
        var captcha = this.value.trim();
        var registerButton = document.getElementById('register');

        if (captcha) {
            registerButton.removeAttribute('disabled');
        } else {
            registerButton.setAttribute('disabled', 'disabled');
        }
    });
    document.getElementById("registerFrom").addEventListener("submit", function (event) {
        event.preventDefault();
        let captchaInput = document.getElementById("captchaInput").value.trim();
        if (!captchaInput) {
            document.getElementById("errorMessage").innerText = "验证码不能为空";
            return;
        }
        fetch('image.do', {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: "captcha=" + encodeURIComponent(captchaInput)
        }).then(response => response.json())
            .then(data => {
                if (data.success)
                    this.submit();
                else {
                    document.getElementById("errorMessage").innerText = data.message || "验证码错误"
                }

            })
            .catch(error => {
                console.error("Error:"+ error);
                document.getElementById("errorMessage").innerText = "服务器错误";
            })
    })
</script>
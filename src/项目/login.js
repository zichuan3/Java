var username ;
var password ;
var regex = /^1[23456789]\d{9}$/;

function check() {
    username = document.getElementsByClassName("username")[0].value
    password = document.getElementsByClassName("password")[0].value
    var t = regex.test(username)
    console.log(username)
    console.log(t)
    if (!t) {
        document.getElementById("flag").innerText = "×";
        document.getElementById("flag").style.color = "red";
    } else {
        document.getElementById("flag").innerText = "√";
        document.getElementById("flag").style.color = "green";
    }
}

function login() {
    if (username.trim().length===11){
        alert("登录成功")
        document.getElementById("my_form").submit();
    }else {
        alert("用户名或密码错误，请重新登录")
        return;
    }
}
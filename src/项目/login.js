var username;
var password;
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
    var num = document.getElementById("verification_code").innerText;
    var input = document.getElementById("input_num").value;
    console.log("num:::", num);
    console.log("input:::", input);
    if (username.trim().length === 11) {
        if (num == input) {
            document.getElementById("my_form").submit();
        } else {
            document.getElementById("code_verification").innerText += "验证码错误";
        }
    } else {
        document.getElementById("code_verification").innerText += "用户名或密码错误，请重新登录"
        return;
    }
}
document.getElementById("q5").addEventListener("click", function () {
    let image_eye = document.getElementById("q5");
    let input_password = document.getElementsByClassName("password")[0];
    if (image_eye.classList.contains("icon-buchakan")) {
        input_password.type = "text";
        image_eye.classList.remove("icon-buchakan");
        image_eye.classList.add("icon-chakan");
    } else {
        input_password.type = "password";
        image_eye.classList.remove("icon-chakan");
        image_eye.classList.add("icon-buchakan");
    }
});
document.getElementById('input_num').onmouseover = function () {
    var math = Math.floor(Math.random() * 9000) + 1000;
    document.getElementById('verification_code').innerText = `${math}`; // 替换'123'为你想要的数字
};
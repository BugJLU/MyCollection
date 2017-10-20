function check() {
    var warning = document.getElementById("warning");
    warning.innerHTML = "";
    var id = document.getElementById("email").value;
    var name = document.getElementById("name").value;
    var pwdele = document.getElementById("password");
    var cpele = document.getElementById("cfmpassword");
    var pwd = pwdele.value;
    var pwd1 = cpele.value;
    var age = document.getElementById("age").value;
    if (id === "" || name === "" || pwd === "" || pwd1 === "") {
        warning.innerHTML = "任何带有*的必填字段都不能为空！";
    } else if (id.length > 255) {
        warning.innerHTML = "E-mail长度需小于255！";
    } else if (name.length > 40) {
        warning.innerHTML = "用户名长度需小于40！";
    } else if (pwd.length > 40 || pwd.length  < 6) {
        warning.innerHTML = "密码长度需在6～40位之间！";
    } else if (pwd !== pwd1) {
        warning.innerHTML = "两次密码输入不符！";
    } else if (age !== "" && isNaN(parseInt(age))) {
        warning.innerHTML = "年龄需为数字！";
    } else {
        var hash = md5(pwd);
        pwdele.value = hash;
        cpele.value = hash;
        document.getElementById("regform").submit();
    }

}
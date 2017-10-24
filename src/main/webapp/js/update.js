function check() {
    var warning = document.getElementById("warning");
    warning.innerHTML = "";
    var name = document.getElementById("name").value;
    var age = document.getElementById("age").value;
    if (name === "") {
        warning.innerHTML = "用户名不能为空！";
    } else if (name.length > 40) {
        warning.innerHTML = "用户名长度需小于40！";
    } else if (age !== "" && isNaN(parseInt(age))) {
        warning.innerHTML = "年龄需为数字！";
    } else {
        document.getElementById("updateform").submit();
    }

}
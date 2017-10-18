function check() {
    var pwdele = document.getElementById('password');
    pwdele.value = md5(pwdele.value);
    document.getElementById('logform').submit();
}
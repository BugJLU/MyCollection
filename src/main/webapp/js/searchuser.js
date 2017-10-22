function changenav() {
    var w = document.body.clientWidth;
    var brand = document.getElementById("brand");
    var form = document.getElementById("formdiv");
    if (w < 768) {
        brand.className = "hidden";
        form.style.width = "100%";
    } else {
        brand.className = "navbar-brand collapse navbar-collapse autoheightbrand";
        form.style.width = "40%";
    }
}
//
// function clickres(id) {
//     var realurl = "account.html?id="+id;
//     window.open(realurl, "_blank");
// }

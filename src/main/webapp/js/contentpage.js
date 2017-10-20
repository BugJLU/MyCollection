function resize() {
    var w = document.body.clientWidth;
    // var h = document.body.clientHeight;
    var main = document.getElementById("maincontainer");
    if (w > 1096) {
        main.style.width = "1096px";
    } else if (w > 832) {
        main.style.width = "832px";
    } else if (w > 568) {
        main.style.width = "568px";
    } else {
        main.style.width = "304px";
    }
}
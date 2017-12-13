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

function addContent() {
    var hidbg = document.getElementById("hidden-background");
    hidbg.style.display="";
    // var card = document.createElement("div");
    // card.setAttribute("id", "addCard");
    // card.setAttribute("onclick", "javascript:void(0)");
    // card.style.width="400px";
    // card.style.height="300px";
    // card.className="layer-foreground";
    // hidbg.appendChild(card);
}

function closeCard() {
    var hidbg = document.getElementById("hidden-background");
    hidbg.style.display="none";
    // hidbg.removeChild(hidbg.childNodes[0]);
}

function doAdd() {
    var url = document.getElementById("url").value;
    if (url === "") {
        alert("网址不能为空！");
    } else {
        var form = document.getElementById("addform");
        form.submit()
    }
}

function doDelete(cid) {
    var b = confirm("确认删除此内容？");
    if (b) {
        window.location.href="delete_content.html?id="+cid;
    }
}
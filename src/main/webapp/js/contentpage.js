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




function updateContent(id) {
    var hidbg = document.getElementById("addCard");
    hidbg.style.display="";
}




function chooseTag(id) {
    var currentTag = document.getElementById(id);
    var nameInput = document.getElementById("form-control");
    if (currentTag.style.backgroundColor == "#e6e6e6")
    {
        nameInput.value += "," + currentTag.innerHTML;
        currentTag.style.backgroundColor = "#0099aa";
    } else{
        var newNames = ""
        var names = nameInput.value.split(",");
        for (var i = 0; i < names.length; i++)
        {
            if (names[i] != currentTag.innerHTML)
            {
                newNames += names[i]
            }
        }
        nameInput.value = newNames;
        currentTag.style.backgroundColor = "#e6e6e6"
    }

}
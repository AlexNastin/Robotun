var cost;
function someFunc(){
cost = document.getElementById("cost").value;
}
var btn = document.getElementById("btn");
btn.onclick = someFunc;
btn.addEventListener("click", defineText, false);

function defineText(evt) {
    
    var json = JSON.stringify({
        "cost": cost,
        "idUser": idUser,
        "idLot": id
        
    });
    printText(json);
        sendText(json);
}

function printText(json) {
	if("true" == json) {
		var content = document.getElementById("output").innerHTML;
	    document.getElementById("output").innerHTML = "<div>"+"Время истекло!"+"</div>" + content;
	} else {
		var json = JSON.parse(json);
	    var content = document.getElementById("output").innerHTML;
	    document.getElementById("output").innerHTML = "<div id=\"ttt\">"+json.cost+"</div>" + content;
	}
}
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
        "idLot": id,
        "nickname": nickname
        
    });
    printText(json);
        sendText(json);
}

function printText(json) {
	if("true" == json) {
		var content = document.getElementById("wallmessages").innerHTML;
	    document.getElementById("wallmessages").innerHTML = "<div>"+"Время истекло!"+"</div>" + content;
	} else {
		var date = new Date();
		var formated_date = date.format("yyyy-mm-dd HH:mm:ss.l");
		var json = JSON.parse(json);
	    var content = document.getElementById("wallmessages").innerHTML;
	    document.getElementById("wallmessages").innerHTML = "<div class=\"message-item\" id=\"m16\"><div class=\"message-inner\"><div class=\"message-head clearfix\"><div class=\"avatar pull-left\"><a href=\"/webapp/viewUserProfile?id=" + json.idUser +"\"><img style=\"min-height: 40px; max-height: 40px;\" src=\"/webapp/resources/images/avatar_2x.png\"></a></div><div class=\"user-detail\"><h5 class=\"handle\">" + json.nickname + "</h5><div class=\"post-meta\"><div class=\"asker-meta\"><span class=\"qa-message-what\"></span><span class=\"qa-message-when\"><span class=\"qa-message-when-data\">" + formated_date + " </span></span><span class=\"qa-message-who\"><span class=\"qa-message-who-pad\">by </span><span class=\"qa-message-who-data\"><a href=\"/webapp/viewUserProfile?id=" + json.idUser + "\">" + json.nickname + "</a></span></span></div></div></div></div><div class=\"qa-message-content\">" + json.cost + "</div></div></div>" + content;
	    var countBet = parseInt(document.getElementById("countBet").innerHTML);
	    document.getElementById("countBet").innerHTML = countBet+=1;
	}
}
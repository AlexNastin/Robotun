var cost;
function someFunc(){
cost = document.getElementById("cost").value;
}
//var btn = document.getElementById("btn");
//btn.onclick = someFunc;
//btn.addEventListener("click", defineText, false);

function defineText(evt) {
    
    var json = JSON.stringify({
        "cost": cost,
        "idUser": idUser,
        "idLot": id,
        "nickname": nickname
        
    });
    printText(json, isICall);
        sendText(json);
}

function printText(json, isICall) {
	if("true" == json) {
		var content = document.getElementById("wallmessages").innerHTML;
	    document.getElementById("wallmessages").innerHTML = "<div>"+"Время истекло!"+"</div>" + content;
	} else {
		var scope = angular.element(document.getElementById("wallmessages")).scope();
		var json = JSON.parse(json);
		var date = new Date().getTime();
		var user = {nickname: json.nickname}
		var bet = {
				cost: json.cost,
				idUser: json.idUser,
				idLot: json.idLot,
				user: user,
				date: date
		}
		scope.$apply(function () {
			scope.betCtrl.bets.push(bet);
		});
	    var countBet = parseInt(document.getElementById("countBet").innerHTML);
	    document.getElementById("countBet").innerHTML = countBet+=1;
	    if(json.idUser == idUser) {
	    	drawButtonPhoneOwner();
	    }
	}
}
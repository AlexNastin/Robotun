var cost;
function someFunc(){
cost = document.getElementById("cost").value;
}

function defineText(evt) {
    
    var json = JSON.stringify({
        "cost": cost,
        "idUser": idUser,
        "idLot": id,
        "nickname": nickname,
        "avatarPath": avatarPath 
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
		var url = '/jobster.by/getVoting?idCandidate=' + json.idUser;
		var rating;
		$.get(url,function(data){
			var user = {
					nickname: json.nickname,
					avatar: {
						path: json.avatarPath
					},
					rating: data
			}
			var bet = {
					cost: json.cost,
					idUser: json.idUser,
					idLot: json.idLot,
					user: user,
					date: date
			}
			scope.$apply(function () {
				console.log(bet)
				scope.betCtrl.bets.push(bet);
			});
		    var countBet = parseInt(document.getElementById("countBet").innerHTML);
		    document.getElementById("countBet").innerHTML = countBet+=1;
		    if(json.idUser == idUser) {
		    	drawButtonPhoneOwner();
		    }
	    	  
	   });
		
	}
}
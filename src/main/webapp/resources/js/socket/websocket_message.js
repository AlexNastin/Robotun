var wsUri = "ws://" + document.location.host + "/jobster.by/messagesocket/"+id;
var websocket = new WebSocket(wsUri);

websocket.onerror = function(evt) {
	console.log("onerror");
	onError(evt) 
};

websocket.onopen = function() {
	console.log("onopen");
};

function onError(evt) {
	console.log("error");
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

websocket.onmessage = function(evt) { onMessage(evt) };

function sendText(json) {
	console.log("send");
    websocket.send(json);
}
                
function onMessage(evt) {
	console.log("message");
    printText(evt.data, isICall);
}
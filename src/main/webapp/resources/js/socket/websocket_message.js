var wsUri = "ws://" + document.location.host + "/webapp/messagesocket/"+id;
var websocket = new WebSocket(wsUri);

websocket.onerror = function(evt) { onError(evt) };

function onError(evt) {
    writeToScreen('<span style="color: red;">ERROR:</span> ' + evt.data);
}

websocket.onmessage = function(evt) { onMessage(evt) };

function sendText(json) {
    websocket.send(json);
}
                
function onMessage(evt) {
    printText(evt.data, isICall);
}
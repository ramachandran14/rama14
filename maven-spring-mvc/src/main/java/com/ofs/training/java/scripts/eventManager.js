var eventManager = {}

var listener = [];
var handler;

eventManager.subscribe = function(eventName, action) {
    listener[eventName] = action;
}


eventManager.broadcast = function(eventName, data) {
    handler = listener[eventName];
    handler(data);
}
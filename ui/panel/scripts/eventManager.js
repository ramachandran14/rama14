var eventManager = {};
eventManager.subscribers = [];

eventManager.broadcast = function(eventName, data) {
    var toFunction = eventManager.subscribers[eventName];
    // for (handler : handler) {
        // handler(data);
    // }
    toFunction(data);
}


eventManager.subscribe = function (eventName, functionName) {
    eventManager.subscribers[eventName] = functionName;
}
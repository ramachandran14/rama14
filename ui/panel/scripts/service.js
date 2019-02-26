var service = {};
var RESPONSE_READY = 4;
var OK_RESPONSE_STATUS = 200; 

service.doGet = function (url) {
    var content;
    var xhttpRequest = new XMLHttpRequest();
    xhttpRequest.onreadystatechange = function () {
        if (this.readyState === RESPONSE_READY && this.status === OK_RESPONSE_STATUS) {
          content = this.responseText;
        }
    };
    xhttpRequest.open("GET", url, false);
    xhttpRequest.send();
    return content;
}
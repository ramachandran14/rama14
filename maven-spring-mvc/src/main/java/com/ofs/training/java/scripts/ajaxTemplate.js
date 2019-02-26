var ajaxTemplate = {};
var response;
var method;
var url;
var asynchronous;

ajaxTemplate.doRead = function(method, url, asynchronous) {
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            response =  this.responseText;
        }
    };
    httpRequest.open(method, url, asynchronous);
    httpRequest.send();
    return response;
}

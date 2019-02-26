var app_script = {};
var child = '';

app_script.init = function () {
    app_script.createChildren();
    app_script.createView();
    app_script.prePopulate();
    app_script.listenEvents();
};

app_script.createChildren = function() {
    lsp.createChildren();
    rsp.createChildren();
};

app_script.createView = function () {

    lsp.createView();
    alert(child);
    document.getElementById('app').innerHTML += child;
    rsp.createView();
    document.getElementById('app').innerHTML += child;
};

app_script.prePopulate = function () {
    lsp.prePopulate();
    rsp.prePopulate();
};

app_script.listenEvents = function () {
    lsp.listenEvents();
    rsp.listenEvents();
};

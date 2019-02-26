var app = {}

app.init = function() {
    app.createChildren();
    app.createView();
    app.prePopulate();
    app.listenEvents();
    app.setDefaults();
}

app.createChildren = function() {
    lsp.createChildren();
    rsp.createChildren();
}

app.createView = function() {
    lsp.createView();
    rsp.createView();
    document.getElementById('app').innerHTML = lspView;
    document.getElementById('app').innerHTML += rspView;
}

app.prePopulate = function() {
    lsp.prePopulate();
    rsp.prePopulate();
}

app.listenEvents = function() {
    lsp.listenEvents();
    rsp.listenEvents();
}

app.setDefaults = function() {
    lsp.setDefaults();
    rsp.setDefaults();
}
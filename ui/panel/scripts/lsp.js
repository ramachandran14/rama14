var lsp = {};
lsp.display;

lsp.createChildren = function () {
}

lsp.createView = function () {
    lsp.display = service.doGet("..lsp.html");
    app.display.innerHTML = lsp.display;
}

lsp.listenEvents = function () {
    document.getElementById('personItem')
            .addEventListener ('click', function () {
                eventManager.broadcast('selectItem', 'person');
            }
        );
    document.getElementById('addressItem')
            .addEventListener ('click', function () {
                eventManager.broadcast('selectItem', 'address');
            }
        );
}

lsp.setDefault = function () {
    eventManager.broadcast('selectItem', 'person');
}
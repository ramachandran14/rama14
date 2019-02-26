var lsp = {}
var lspView;

lsp.createChildren = function() {}

lsp.createView = function() {
    lspView = ajaxTemplate.doRead('GET', 'templates/lsp.html', false);
}

lsp.prePopulate = function() {}

lsp.listenEvents = function() {
    document.getElementById("person").addEventListener('click', onPersonSelect);
    document.getElementById("address").addEventListener('click', onAddressSelect);
}

lsp.setDefaults = function() {
    eventManager.broadcast('entitySelected', 'person');
}

var onPersonSelect = function() {
    eventManager.broadcast('entitySelected', 'person');
}

var onAddressSelect = function() {
    eventManager.broadcast('entitySelected', 'address');
}

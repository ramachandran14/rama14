var rsp = {}
var rspView;
var personPanelView;

rsp.createChildren = function() {}

rsp.createView = function() {
    rspView = ajaxTemplate.doRead('GET', 'templates/rsp.html', false);
}

rsp.prePopulate = function() {}

rsp.listenEvents = function() {
  eventManager.subscribe('entitySelected', onEntitySelect);
}

rsp.setDefaults = function() {}

var onEntitySelect = function(entity) {
    if (entity == 'person') {
        createPersonPanelView();
        document.getElementById('rspView').innerHTML = personPanelView;
        personPanel.init();
    } else {
        addressPanel.init();
    }
}

var createPersonPanelView = function() {
    personPanelView = ajaxTemplate.doRead('GET', 'templates/personPanel.html', false);
}
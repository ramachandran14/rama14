var personPanel = {};

personPanel.init = function() {
    personPanel.createChildren();
    personPanel.createView();
    personPanel.prePopulate();
    personPanel.listenEvents();
    personPanel.setDefaults();
}

personPanel.createChildren = function() {
    personListPanel.createChildren();
    personInfoPanel.createChildren();
}

personPanel.createView = function() {
    personListPanel.createView();
    document.getElementById("person-panel").innerHTML += personListPanelView;
    personInfoPanel.createView();
    document.getElementById("person-panel").innerHTML += personInfoView;
}

personPanel.prePopulate = function() {
    personListPanel.prePopulate();
    personInfoPanel.prePopulate();
}

personPanel.listenEvents = function() {
    personListPanel.listenEvents();
    personInfoPanel.listenEvents();
}

personPanel.setDefaults = function() {
    personListPanel.setDefaults();
    personInfoPanel.setDefaults();
}
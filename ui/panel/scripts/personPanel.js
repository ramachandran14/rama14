var personPanel = {};
personPanel.display;

personPanel.onload = function () {
    personPanel.createChildren();
    personPanel.createView();
    personPanel.prePopulate();
    personPanel.listenEvents();
    personPanel.setDefault();
}


personPanel.createChildren = function () {
    // var rspId = document.getElementById('rsp');
    personListPanel.createChildren();
    personInfoPanel.createChildren();
}

personPanel.createView = function () {
    personPanel.display = service.doGet('..personPanel.html');
    rsp.display.innerHTML = personPanel.display;

    personPanel.display = document.getElementById('personPanel');
    personListPanel.createView();
    personInfoPanel.createView();
}

personPanel.prePopulate = function () {
    personListPanel.prePopulate();
}

personPanel.listenEvents = function () {
    personListPanel.listenEvents();
    personInfoPanel.listenEvents();
}

personPanel.setDefault = function () {
    personListPanel.setDefault();
    personInfoPanel.setDefault();
}
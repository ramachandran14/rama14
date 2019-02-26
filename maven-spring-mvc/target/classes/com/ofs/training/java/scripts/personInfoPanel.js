var personInfoPanel = {};
var personInfoView;
var keyList = ['id', 'firstname', 'lastname', 'email', 'birthdate', 'createddate', 'isadmin'];

personInfoPanel.createChildren = function() {}

personInfoPanel.createView = function() {
    personInfoView = ajaxTemplate.doRead('GET', 'templates/personInfoPanel.html', false);
}

personInfoPanel.prePopulate = function() {}

personInfoPanel.listenEvents = function() {
    eventManager.subscribe('rowSelected', populateInForm);
    eventManager.subscribe('addSelected', clearFields);
    document.getElementById('submit').addEventListener('click', submitSelected);
    // document.getElementById('reset').addEventListener('click', onResetSelect);
}

personInfoPanel.setDefaults = function() {}

var submitSelected = function () {
    var temp = {};
    var person = [];
    for(i = 0; i< keyList.length; i++) {
        temp[keyList[i]] = document.getElementById(keyList[i]).value;
    }
    person.push(temp);
    eventManager.broadcast('submitSelected', person);
};

// var onResetSelect = function () {};

var populateInForm = function(tableRow) {
    for(i = 0; i< keyList.length; i++) {
        var rr = keyList[i]
        document.getElementById(rr).value = tableRow.cells[i].innerHTML;
    }
};

var clearFields = function () {
    for(i = 0; i< keyList.length; i++) {
        document.getElementById(keyList[i]).value = '';
    }
};

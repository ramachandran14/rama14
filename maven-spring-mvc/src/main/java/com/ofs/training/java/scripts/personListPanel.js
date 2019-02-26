var personListPanel = {};
var personListPanelView;
var personJson;
var personListItem;
var isCreate;

personListPanel.createChildren = function() {}

personListPanel.createView = function() {
    personListPanelView = ajaxTemplate.doRead('GET', 'templates/personListPanel.html', false);
}

personListPanel.prePopulate = function() {
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function() {
       if (this.readyState == 4 && this.status == 200) {
            personJson = JSON.parse(this.responseText);
            constructList(personJson);
        }
    };
    httpRequest.open('GET', 'assets/person.json', false);
    httpRequest.send();
}


personListPanel.listenEvents = function() {
    document.getElementById('table').addEventListener('click', onRowSelected);
    document.getElementById('person-adder').addEventListener('click', onAddSelected);
    // document.getElementById('del').addEventListener('click', onDeleteSelected);.
    eventManager.subscribe('submitSelected', onSubmit);
}

personListPanel.setDefaults = function() {
    var table = document.getElementById('table');
    eventManager.broadcast('rowSelected', table.rows[1]);
}

var onSubmit = function(data) {
  if (isCreate === true) {
      constructList(data);
  } else {
      update();
  }
}

var onAddSelected = function() {
    isCreate = true;
    eventManager.broadcast('addSelected', '');
}

var onRowSelected = function() {
    isCreate = false;
    eventManager.broadcast('rowSelected', this);
}

// var onDeleteSelected = function() {
    // eventManager.broadcast('deleteSelected', this);
// }

var constructList = function (Json) {

    getPersonTemplate();
    var personValues = Object.keys(Json[0]);
    var listItem = '';
    for (var i = 0; i < Json.length; i++) {
        listItem += personListItem.replace(/%id%/, Json[i][personValues[0]])
                                  .replace(/%firstname%/, Json[i][personValues[1]])
                                  .replace(/%lastname%/, Json[i][personValues[2]])
                                  .replace(/%email%/, Json[i][personValues[3]])
                                  .replace(/%birthdate%/, Json[i][personValues[4]])
                                  .replace(/%createddate%/, Json[i][personValues[5]])
                                  .replace(/%admin%/, Json[i][personValues[6]])
    }
    document.getElementById('table').innerHTML += listItem;
}

var getPersonTemplate = function () {
    personListItem = ajaxTemplate.doRead('GET', 'templates/personListTemplate.html', false);
}
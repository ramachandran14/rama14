var personListPanel = {};
personListPanel.display;
personListPanel.personsList;
personListPanel.columns;
personListPanel.row;

personListPanel.createChildren = function () {
}

personListPanel.createView = function () {
    personListPanel.display = service.doGet('..personListPanel.html');
    personPanel.display.innerHTML = personListPanel.display;
}

personListPanel.prePopulate = function () {
    var tableRecord = service.doGet('..assets/tableRecord.txt');
    personListPanel.row = tableRecord;

    var personData = JSON.parse(service.doGet('..assets/person.json'));
    personListPanel.personsList = personData;

    var table = document.getElementById('personTable');
    var headers = Object.keys(personData[0]);
    personListPanel.columns = headers;

    for (var i = 0; i < personData.length; i ++) {
        var newTableRecord = tableRecord.replace(/%id%/, personData[i][headers[0]])
                                   .replace(/%firstName%/, personData[i][headers[1]])
                                   .replace(/%lastName%/, personData[i][headers[2]])
                                   .replace(/%emailId%/, personData[i][headers[3]])
                                   .replace(/%birthDate%/, personData[i][headers[4]])
                                   .replace(/%deleteId%/, 'delete' + personData[i][headers[0]])
                                   .replace(/%rowId%/, personData[i][headers[0]]);
        table.innerHTML += newTableRecord;
    }
}

personListPanel.listenEvents = function () {
    var personsList = personListPanel.personsList;
    var column = personListPanel.columns;
    var personTable = document.getElementById('personTable');

    for (var i = 0; i < personsList.length; i++) {

        var rowId = personsList[i][column[0]];
            
        var deleteId = 'delete' + (i+1);

        document.getElementById(rowId)
                .addEventListener('click', function() { 
                    personListPanel.fetchRecord(this);
                }
            );
        document.getElementById(deleteId)
                .addEventListener('click', function() { 
                    personListPanel.onDelete(this);
                }
            );
        document.getElementById('addPerson')
                .addEventListener('click', function() {
                    eventManager.broadcast('addRow');
                }
            );
    }
    // eventManager.subscribe('submitPerson', onSubmitPerson);
}

personListPanel.setDefault = function () {
    var data = [];
    var column = personListPanel.columns;
    var personTable = document.getElementById('personTable');
    for (var j = 0; j < column.length; j++) {
        data[column[j]] = personTable.rows[1].cells[j].innerHTML;
    }
    eventManager.broadcast('selectRow', data);
}

var onSubmitPerson = function (details) {
    var tableRecord = personListPanel.row;
    var personData = personListPanel.personsList;
    var headers = personListPanel.columns;
    var personTable = document.getElementById('personTable');
    var personId = details[headers[0]];
    if (personId === '') {
        personId = personData.length + 1;
    }

    var invalidDetails = personListPanel.validate(details);
    if (invalidDetails) {
        return;
    } else {
        for (var i = 0; i < personData.length; i++) {
            for (var j = 1; j < headers.length; j++) {
                if (personData[i][headers[0]] == personId) {
                    console.log(i);
                    personTable.rows[i + 1].cells[j].innerHTML = details[headers[j]];
                }
            }
            console.log(personId);
        }

        if (personId > personData.length) {
            var personTable = document.getElementById('personTable');
            var newTableRecord = tableRecord.replace('pId', personId)
                                  .replace('firstName', details[headers[1]])
                                  .replace('lastName', details[headers[2]])
                                  .replace('mailId', details[headers[3]])
                                  .replace('birthDate', details[headers[4]])
                                  .replace('deleteId', 'delete' + details[headers[0]])
                                  .replace('idName', details[headers[1]] 
                                                   + details[headers[2]]);
            personTable.innerHTML += newTableRecord;
        }
    }
}

personListPanel.fetchRecord = function (selectedRecord) {
    var data = [];
    var column = personListPanel.columns;
    for (var i = 0; i < column.length; i++) {
            data[column[i]] = selectedRecord.cells[i].innerHTML;
    }
    eventManager.broadcast('selectRow', data);
}

personListPanel.validate = function (details) {
    var headers = personListPanel.columns;
    for (var j = 1; j < headers.length; j++) {
        if (details[headers[j]] === '') {
            window.alert('enter all the details');
            return false;
        }
    }
}

personListPanel.onDelete = function (selectedRecord) {
    var deletePerson = document.getElementById(selectedRecord);
    var personTable = document.getElementById('personTable');
    console.log(deletePerson);
    console.log(selectedRecord);
    personTable.deleteRow(selectedRecord);
}


var onSubmitSelect = function (person) {
    if(isCreate === true) {
        constructList(person);
    } else {
        updatePerson(person);
    }
};

var onDeleteSelected = function () {
};

var updatePerson = function (person) {

    var id = person[0].id;
    var table = document.getElementById('person-table' );
    var tr = table.rows;
    for (i = 1; i < tr.length; i++) {
        var td = tr[i].getElementsByTagName('td')[0].innerHTML;

        if (td == id) {
            for(j = 0; j < keyList.length; j++ ) {
                var inputData = person[0][keyList[j]];
                tr[i].cells[j].innerHTML = inputData;
            }
        }
    }
};

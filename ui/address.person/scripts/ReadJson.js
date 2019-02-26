function CreateTableFromJSON() {
    var address = [
        {
            "street": "ajith nagar",
            "city": "chennai",
            "postcode": "682682",
        },
        {
            "street": "samnagar",
            "city": "salem",
            "postcode": "737677",
        },
        {
            "street": "gowthamnagar",
            "city": "tirupur",
            "postcode": "277166",
        }
    ]

    var col = [];
    for (var i = 0; i < address.length; i++) {
        for (var key in address[i]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }

    var table = document.createElement("table");

    var tr = table.insertRow(-1);                   

    for (var i = 0; i < col.length; i++) {
        var th = document.createElement("th");
        th.innerHTML = col[i];
        tr.appendChild(th);
    }

    for (var i = 0; i < address.length; i++) {

        tr = table.insertRow(-1);

        for (var j = 0; j < col.length; j++) {
            var tabCell = tr.insertCell(-1);
            tabCell.innerHTML = address[i][col[j]];
        }
    }

    var divContainer = document.getElementById("showData");
    divContainer.innerHTML = "";
    divContainer.appendChild(table);
}
 function getTableDataAJAX() {

	var getTableData = new XMLHttpRequest();

	getTableData.onreadystatechange = function() {
		if(getTableData.readyState === 4) {
			var tableInfo     = JSON.parse(getTableData.responseText);
			var tableHeading  = tableInfo.tableHeading;
			var Street   = tableInfo.Street;
			var city   = tableInfo.city;
            var postalcode = tableInfo.postalcode;

			var createTable = function() {
                
				var newTable = document.createElement('table');
                newTable.setAttribute("id", "addressTable");
				var tableHeadingRow = document.createElement('tr');
				var tableHeader = document.createElement('th');
				tableHeadingRow.appendChild(tableHeader);

				var tableRowFirst = document.createElement('tr');
				var tableRowFirstHead = document.createElement('th');
				tableRowFirst.appendChild(tableRowFirstHead);

				for (i = 1; i < Street.length; i++) {
					var petData = document.createElement('td');
					tableRowFirst.appendChild(petData);

					petData.textContent = Street[i];
				}

				var tableRowSecond = document.createElement('tr');
				var tableRowSecondHead = document.createElement('th');
				tableRowSecond.appendChild(tableRowSecondHead);

				for (i = 1; i < city.length; i++) {
					var peopleData = document.createElement('td');
					tableRowSecond.appendChild(peopleData);

					peopleData.textContent = city[i];
				}
                
                var tableRowThird = document.createElement('tr');
				var tableRowThirdHead = document.createElement('th');
				tableRowThird.appendChild(tableRowThirdHead);

				for (i = 1; i < postalcode.length; i++) {
					var petData = document.createElement('td');
					tableRowThird.appendChild(petData);

					petData.textContent = postalcode[i];
				}

				newTable.classList.add('jsTable');
				tableHeader.classList.add('jsTableHead');
				tableRowFirstHead.classList.add('jsTableRowHead');
				tableRowSecondHead.classList.add('jsTableRowHead');
				tableRowThirdHead.classList.add('jsTableRowHead');

				tableHeader.textContent = tableHeading;
				tableHeader.setAttribute("colspan", "4");

				tableRowFirstHead.textContent = Street[0]
				tableRowSecondHead.textContent = city[0];
				tableRowThirdHead.textContent = postalcode[0];

				document.body.appendChild(newTable);

				newTable.appendChild(tableHeadingRow);
				newTable.appendChild(tableRowFirst);
				newTable.appendChild(tableRowSecond);
				newTable.appendChild(tableRowThird);
                
                function addAddress() {
  
  var textbox = document.createElement('textbox');
  
  var street = document.createElement('input');
  var city = document.createElement('input');
  var postalcode = document.createElement('input');
  
  street.setAttribute("placeholder",'street');
  city.setAttribute("placeholder",'city');
  postalcode.setAttribute("placeholder",'postalcode');
  
  textbox.appendChild(street);
  textbox.appendChild(city);
  textbox.appendChild(postalcode);
  
  document.body.appendChild(textbox);
}
			}();
		};
	};
	getTableData.open("GET", "Address.json", true);
	getTableData.send();


var wrapperDiv = document.querySelector('div');
var AJAXbutton = document.getElementById('button');

AJAXbutton.addEventListener('click', getTableDataAJAX);
var textbox = document.createElement('textbox');
  
  var street = document.createElement('input');
  var city = document.createElement('input');
  var postalcode = document.createElement('input');
  
  street.setAttribute("placeholder",'street');
  city.setAttribute("placeholder",'city');
  postalcode.setAttribute("placeholder",'postalcode');
  
  textbox.appendChild(street);
  textbox.appendChild(city);
  textbox.appendChild(postalcode);
  
  document.body.appendChild(textbox);
}


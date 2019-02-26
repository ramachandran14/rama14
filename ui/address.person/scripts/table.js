var get = function () {

    getAddress();
    getPerson();
}

var getAddress = function () {

    var req = new XMLHttpRequest();
    req.open('GET', '../assets/address.json', true);
    req.send();
    req.onreadystatechange = function() {

        var obj = JSON.parse(this.response);
        if(this.readyState == 4 && this.status == 200) {

            for(var index = 0; index < obj.length; index ++) {

                var parameter = document.createElement('tr');
                var element = document.getElementById('address-table');
                element.appendChild(parameter);
                parameter.setAttribute('id', index);
                parameter.setAttribute('onClick', 'loadData(' + index + ')');

                var parameter1 = document.createElement('td');
                var node1 = document.createTextNode(obj[index].id);
                parameter1.appendChild(node1);
                parameter.appendChild(parameter1);

                var parameter2 = document.createElement('td');
                var node2 = document.createTextNode(obj[index].street);
                parameter2.appendChild(node2);
                parameter.appendChild(parameter2);

                var parameter3 = document.createElement('td');
                var node3 = document.createTextNode(obj[index].city);
                parameter3.appendChild(node3);
                parameter.appendChild(parameter3);

                var parameter4 = document.createElement('td');
                var node4 = document.createTextNode(obj[index].postal_code);
                parameter4.appendChild(node4);
                parameter.appendChild(parameter4);

                if(index == 0) {
                    show(obj[index]);
                }
            }
        }
    };
}

var show = function(obj) {

    var label1 = document.createElement('label');
    var node1 = document.createTextNode('Id :');
    label1.appendChild(node1);
    var element1 = document.getElementById('form-address');
    element1.appendChild(label1);
    var input1 = document.createElement('input');
    var box1 = document.getElementById('form-address');
    box1.appendChild(input1);
    input1.setAttribute('id', 'a1');
    document.getElementById('a1').value = obj.id;

    var label2 = document.createElement('label');
    var node2 = document.createTextNode('Street :');
    label2.appendChild(node2);
    var element2 = document.getElementById('form-address');
    element2.appendChild(label2);
    var input2 = document.createElement('input');
    var box2 = document.getElementById('form-address');
    box2.appendChild(input2);
    input2.setAttribute('id', 'a2');
    document.getElementById('a2').value = obj.street;

    var label3 = document.createElement('label');
    var node3 = document.createTextNode('City :');
    label3.appendChild(node3);
    var element3 = document.getElementById('form-address');
    element3.appendChild(label3);
    var input3 = document.createElement('input');
    var box3 = document.getElementById('form-address');
    box3.appendChild(input3);
    input3.setAttribute('id', 'a3');
    document.getElementById('a3').value = obj.city;

    var label4 = document.createElement('label');
    var node4 = document.createTextNode('Postal Code :');
    label4.appendChild(node4);
    var element4 = document.getElementById('form-address');
    element4.appendChild(label4);
    var input4 = document.createElement('input');
    var box4 = document.getElementById('form-address');
    box4.appendChild(input4);
    input4.setAttribute('id', 'a4');
    document.getElementById('a4').value = obj.postal_code;
}

function loadData(position) {

    var Id =document.getElementById('address-table').rows[position+1]
                                                    .cells[0].innerHTML;
    var Street =document.getElementById('address-table').rows[position+1]
                                                        .cells[1].innerHTML;
    var City =document.getElementById('address-table').rows[position+1]
                                                      .cells[2].innerHTML;
    var PostalCode =document.getElementById('address-table').rows[position+1]
                                                            .cells[3].innerHTML;

    document.getElementById('a1').value = Id;
    document.getElementById('a2').value = Street;
    document.getElementById('a3').value = City;
    document.getElementById('a4').value = PostalCode;
}

var getPerson = function () {

    var req2 = new XMLHttpRequest();
    req2.open('GET', '../assets/person.json', true);
    req2.send();
    req2.onreadystatechange = function() {

        var obj = JSON.parse(this.response);
        if(this.readyState == 4 && this.status == 200) {

            for(var index = 0; index < obj.length; index ++) {

                var parameter = document.createElement('tr');
                var element = document.getElementById('person-table');
                element.appendChild(parameter);
                parameter.setAttribute('id', index);
                parameter.setAttribute('onClick', 'loadPerson( ' + index + ')');

                var parameter1 = document.createElement('td');
                var node1 = document.createTextNode(obj[index].id);
                parameter1.appendChild(node1);
                parameter.appendChild(parameter1);

                var parameter2 = document.createElement('td');
                var node2 = document.createTextNode(obj[index].first_name);
                parameter2.appendChild(node2);
                parameter.appendChild(parameter2);

                var parameter3 = document.createElement('td');
                var node3 = document.createTextNode(obj[index].last_name);
                parameter3.appendChild(node3);
                parameter.appendChild(parameter3);

                var parameter4 = document.createElement('td');
                var node4 = document.createTextNode(obj[index].email);
                parameter4.appendChild(node4);
                parameter.appendChild(parameter4);

                var parameter5 = document.createElement('td');
                var node5 = document.createTextNode(obj[index].address_id);
                parameter5.appendChild(node5);
                parameter.appendChild(parameter5);

                var parameter6 = document.createElement('td');
                var node6 = document.createTextNode(obj[index].birth_date);
                parameter6.appendChild(node6);
                parameter.appendChild(parameter6);

                if(index == 0) {
                    showPerson(obj[index]);
                }
            }
        }
    };
}

var showPerson = function(obj) {

    var label1 = document.createElement('label');
    var node1 = document.createTextNode('Id :');
    label1.appendChild(node1);
    var element1 = document.getElementById('form-person');
    element1.appendChild(label1);
    var input1 = document.createElement('input');
    var box1 = document.getElementById('form-person');
    box1.appendChild(input1);
    input1.setAttribute('id', 'b1');
    document.getElementById('b1').value = obj.id;

    var label2 = document.createElement('label');
    var node2 = document.createTextNode('First Name :');
    label2.appendChild(node2);
    var element2 = document.getElementById('form-person');
    element2.appendChild(label2);
    var input2 = document.createElement('input');
    var box2 = document.getElementById('form-person');
    box2.appendChild(input2);
    input2.setAttribute('id', 'b2');
    document.getElementById('b2').value = obj.first_name;

    var label3 = document.createElement('label');
    var node3 = document.createTextNode('Last Name :');
    label3.appendChild(node3);
    var element3 = document.getElementById('form-person');
    element3.appendChild(label3);
    var input3 = document.createElement('input');
    var box3 = document.getElementById('form-person');
    box3.appendChild(input3);
    input3.setAttribute('id', 'b3');
    document.getElementById('b3').value = obj.last_name;

    var label4 = document.createElement('label');
    var node4 = document.createTextNode('Email :');
    label4.appendChild(node4);
    var element4 = document.getElementById('form-person');
    element4.appendChild(label4);
    var input4 = document.createElement('input');
    var box4 = document.getElementById('form-person');
    box4.appendChild(input4);
    input4.setAttribute('id', 'b4');
    document.getElementById('b4').value = obj.email;

    var label5 = document.createElement('label');
    var node5 = document.createTextNode('Address Id :');
    label5.appendChild(node5);
    var element5 = document.getElementById('form-person');
    element5.appendChild(label5);
    var input5 = document.createElement('input');
    var box5 = document.getElementById('form-person');
    box5.appendChild(input5);
    input5.setAttribute('id', 'b5');
    document.getElementById('b5').value = obj.address_id;

    var label6 = document.createElement('label');
    var node6 = document.createTextNode('Date of Birth :');
    label6.appendChild(node6);
    var element6 = document.getElementById('form-person');
    element6.appendChild(label6);
    var input6 = document.createElement('input');
    var box6 = document.getElementById('form-person');
    box6.appendChild(input6);
    input6.setAttribute('id', 'b6');
    document.getElementById('b6').value = obj.birth_date;
}

function loadPerson(position) {

    var Id =document.getElementById('person-table').rows[position+1]
                                                    .cells[0].innerHTML;
    var FirstName =document.getElementById('person-table').rows[position+1]
                                                        .cells[1].innerHTML;
    var LastName =document.getElementById('person-table').rows[position+1]
                                                      .cells[2].innerHTML;
    var Email =document.getElementById('person-table').rows[position+1]
                                                            .cells[3].innerHTML;
    var AddressId =document.getElementById('person-table').rows[position+1]
                                                            .cells[4].innerHTML;
    var DateofBirth =document.getElementById('person-table').rows[position+1]
                                                            .cells[5].innerHTML;

    document.getElementById('b1').value = Id;
    document.getElementById('b2').value = FirstName;
    document.getElementById('b3').value = LastName;
    document.getElementById('b4').value = Email;
    document.getElementById('b5').value = AddressId;
    document.getElementById('b6').value = DateofBirth;
}

var addressTable = document.getElementById('address-table');
var personTable = document.getElementById('person-table');
var addressEdit = document.getElementById('form-address');
var personEdit = document.getElementById('form-person');

var btnAddressTable = document.getElementById('showAddressTable');
var btnPersonTable = document.getElementById('showPersonTable');

btnAddressTable.onclick = function () {

    addressTable.style.display = "table";
    personTable.style.display = "none";
    addressEdit.style.display = "block";
    personEdit.style.display = "none";
}

btnPersonTable.onclick = function () {

    personTable.style.display = "table";
    addressTable.style.display = "none";
    addressEdit.style.display = "none";
    personEdit.style.display = "block";
}

var search = function () {

  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("address-table");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {

    td = tr[i].getElementsByTagName("td")[0];
    if (td) {

      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {

        tr[i].style.display = "";
      } else {

        tr[i].style.display = "none";
      }
    }
  }
}



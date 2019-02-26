var rsp = {};
rsp.display;

rsp.createChildren = function () {
}

rsp.createView = function () {
    rsp.display = service.doGet("..rsp.html");
    app.display.innerHTML += rsp.display;

    rsp.display = document.getElementById('rsp');
}

rsp.listenEvents = function () {
    eventManager.subscribe('selectItem', onSelectItem);
}

var onSelectItem = function (data) {
    if (data === 'person') {
        personPanel.onload();
    } else if (data === 'address') {
        addressPanel.onload();
    }
}



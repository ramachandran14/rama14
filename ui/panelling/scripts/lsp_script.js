var lsp ={};
lsp.createChildren = function () {
    
};
lsp.createView = function () {
    var appLspChildren = new XMLHttpRequest();

    appLspChildren.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        child+= this.responseText;
        console.log(child);
    }
};
    appLspChildren.open('GET', '../html/lsp_panel_view.html', false);
    appLspChildren.send();
}

lsp.prePopulate = function () {
    
};

lsp.listenEvents = function () {

    document.getElementById('person-entity').addEventListener('click', onSelectPerson);
    document.getElementById('address-entity').addEventListener('click', onSelectPerson);
}

 var onSelectPerson = function () {

 };
var rsp = {};
rsp.createChildren = function () {

};
rsp.createView = function () {
    var appRspChildren = new XMLHttpRequest();
    appRspChildren.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
        child+= this.responseText;
        console.log(child);
    }
};
    appRspChildren.open('GET', '../html/rsp_panel_view.html', false);
    appRspChildren.send();
}

rsp.prePopulate = function () {
    
};

rsp.listenEvents = function () {
    
}

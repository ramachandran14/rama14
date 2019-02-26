var personpanel = {};

personpanel.init() {
    personPanel.createChildren();
    personPanel.createView();
    personPanel.prePopulate();
    personPanel.listenEvent();
    personPanel.setDefault();
}

personPanel.createChildren = function () {
    plpView.createChildren();
    pipView.createChildren();
}

personPanel.createView = function () {
    plpView.createView();
    document.getElementById('container').innerHTML = ListPanelView;
    document.getElementById('container').innerHTML = InfoPanelView;
    pipView.createView();
}

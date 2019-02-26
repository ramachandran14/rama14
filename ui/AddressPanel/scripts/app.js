var app = {};

app.init() {
  app.createChildren();
  app.createView();
  app.listenEvent();
};

app.createChildren = function () {
  lsp.createChildren();
  rsp.createChildren();
};

app.createView = function () {
  lsp.createView();
  document.getElementById('app').innerHTML = ListPanelView;
  rsp.createView();
  document.getElementById('app').innerHTML = InfoPanelView;
};

app.listenEvent = function() {
  lsp.listenEvent();
  rsp.listenEvent();
}

document.getElementById('app').innerHTML = 5 + 4;
  







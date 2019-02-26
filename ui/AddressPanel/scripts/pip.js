var pipView = {};

pipView.createView = function() {
    var xhttp = new XMLHttpRequest();
    var xhttp.onreadystatechange = function() {
            if(readyState == 4 && status == 200){
            InfoPanelView  = this.responseText;
            }
            xhttp.open('GET', '../html/pip.html', false);
            xhttp.send();
        }
}
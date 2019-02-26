var plpView = {};

    plpView.createView = function () {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if( readyState == 4 && status == 200) {
           ListPanelView = this.responseText; 
        }
    xhttp.open('GET', '../html/plp.html', false);
    xhttp.send();
    }   
}
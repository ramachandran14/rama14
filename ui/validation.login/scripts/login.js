function validate() {
    var username = window.document.getElementById("Username").value;
    var password = window.document.getElementById("Password").value;
    if (username.length === 0) {
        if (password.length === 0) {
            window.alert("Please enter the username and password");
        }else{
            window.alert("please enter the username");
        }
    }else if(password.length ===0) {
        window.alert("Please enter the password");
    }else{
        window.alert("login successfull");
    }
}

var time = 0;
function timer() {
    var num = document.getElementById("number");
    document.getElementById("increase").innerHTML = ++time
}


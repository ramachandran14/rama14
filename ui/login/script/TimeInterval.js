var time = 0;
// var num = document.getElementById('number');

function myTimer() {
    document.getElementById('increase').innerHTML = ++time;
}

function validation()
{
var a = document.form.password.value;
if(a=='')
{
    alert('Please Enter Your Password');
    document.form.password.focus();
    return false;
} 
}
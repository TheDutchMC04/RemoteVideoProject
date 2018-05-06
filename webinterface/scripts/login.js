var username = 'nee';
var password = 'pass';

function check(form)
{
 if(form.userid.value == username && form.pswrd.value == password)
  {
	window.open('target.html')
  }
 else
 {
   alert("Incorrect password or username")
  }
}
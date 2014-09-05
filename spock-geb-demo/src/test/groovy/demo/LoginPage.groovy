package demo

import geb.Page

class LoginPage extends Page{
	static url = "login.html"
	
	static content = {
		username {$(name: 'j_username')}
		password {$(name: 'j_password')}
		submit {$('#submit')}
	}
	
	def login(uname, pass){
		username.value uname
		password.value pass
		submit.click()
	}
}

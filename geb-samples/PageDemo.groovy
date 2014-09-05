@Grapes([
    @Grab("org.gebish:geb-core:0.9.3"),
    //@Grab(group='commons-codec', module='commons-codec', version='1.9'),
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.42.2"),
	//@Grab("org.seleniumhq.selenium:selenium-chrome-driver:2.42.0"),
    //@Grab("org.seleniumhq.selenium:selenium-support:2.42.0")
])

import geb.Browser
import geb.Page
import org.openqa.selenium.firefox.FirefoxDriver

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

class DashboardPage extends Page{
	static at = { title == 'Dashboard' }
	
	static content = {
		pageTitle {$('h1').text()}
	}
}

Browser.drive() {
	to LoginPage
	login('user1', 'secret')
	at DashboardPage
	assert pageTitle == 'Dashboard'
}.quit()

println "Complete.."
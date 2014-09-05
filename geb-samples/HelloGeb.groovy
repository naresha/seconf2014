@Grapes([
    @Grab("org.gebish:geb-core:0.9.3"),
    //@Grab(group='commons-codec', module='commons-codec', version='1.9'),
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.42.2"),
	//@Grab("org.seleniumhq.selenium:selenium-chrome-driver:2.42.0"),
    //@Grab("org.seleniumhq.selenium:selenium-support:2.42.0")
])

import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver

/*
Browser browser = new Browser()
browser.go "http://localhost:8080/sedemo1/login/"
browser.$(name: 'j_username') << 'user1'
browser.$(name: 'j_password') << 'secret'
browser.$('#submit').click()
browser.quit()
*/
 

Browser.drive() {
	go "login.html"
	$(name: 'j_username') << 'user1'
	$(name: 'j_password') << 'secret'
	$('#submit').click()
	title == 'Dashboard'
	assert $('h1').text() == 'Dashboard'
}.quit()

println "Complete.."
@Grapes([
    @Grab("org.gebish:geb-core:0.9.3"),
    //@Grab(group='commons-codec', module='commons-codec', version='1.9'),
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.42.2"),
	//@Grab("org.seleniumhq.selenium:selenium-chrome-driver:2.42.0"),
    //@Grab("org.seleniumhq.selenium:selenium-support:2.42.0")
])

import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver

Browser.drive() {
	go "navigator.html"
	assert $('h2').text() == 'Introduction'
	assert $('h2', 1).text() == 'Navigator'
	assert $('h2', 0..2)*.text() == 
		['Introduction', 'Navigator', 'Page Objects']
	assert $('h2').size() == 4
	
	assert $('h2', duration: '5').size() == 2
	assert $('h2', text: 'Summary').size() == 1
	
	assert $('h2', text: contains('o')).size() == 2
	assert $('h2', text: iContains('o')).size() == 3
	
	assert $('h2', duration: contains('5')).size() == 3
	//assert $('h2', duration: contains(~/\d/)).size() == 3
	
	println "-- Acess attribute --"
	$('h2').each { 
		println it.attr('duration') 
	} 
	
	println "-- Find --"
	$('div.languages').find('.jvm').each{ element ->
		println element.text()
	}
	
	println "-- filter --"
	$('.language').filter('.jvm').each{ element ->
		println element.text()
	}
	
	$('.language').not('.clr').each{ element ->
		println element.text()
	}
	
	//waitFor { $('#dynamic').text()}
	
}.quit()

println "Complete.."
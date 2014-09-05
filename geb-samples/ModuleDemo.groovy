@Grapes([
    @Grab("org.gebish:geb-core:0.9.3"),
    //@Grab(group='commons-codec', module='commons-codec', version='1.9'),
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.42.2"),
	//@Grab("org.seleniumhq.selenium:selenium-chrome-driver:2.42.0"),
    //@Grab("org.seleniumhq.selenium:selenium-support:2.42.0")
])

import geb.Browser
import geb.Page
import geb.Module
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.Keys

class SearchModule extends Module {
	static content = {
		searchBox(to: SearchResultPage) { $('#query') }
	}
	
	void search(String query){
		searchBox << query
		searchBox << Keys.ENTER
	}
}

class DashboardPage extends Page {
	static url = 'dashboard.html'
	static at = { title == 'Dashboard' } 
	
	static content = {
		pageTitle {$('h1').text()}
		searchBar {module SearchModule}
	}
}

class SearchResultPage extends Page{
	static at = { title == 'Search Result' }
	
	static content = {
		pageTitle {$('h1').text()}
	}
}

Browser.drive() {
	to DashboardPage
	searchBar.search("my query")
	//at SearchResultPage
	assert pageTitle == 'Search Result'
}.quit()

println "Complete.."
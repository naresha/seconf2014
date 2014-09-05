package demo

import geb.Page

class DashboardPage extends Page{
	static url = 'dashboard.html'
	static at = {waitFor { title == 'Dashboard'}}
	
	static content = {
		header { module HeaderModule}
		searchBar {module SearchModule}
	}
}

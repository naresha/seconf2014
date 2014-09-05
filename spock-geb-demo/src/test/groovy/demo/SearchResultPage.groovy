package demo

import geb.Page

class SearchResultPage extends Page{
	static at = {waitFor { title == 'Search Result'}}
	
	static content = {
		header { module HeaderModule}
	}
}
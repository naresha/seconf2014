package demo

import geb.Module
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

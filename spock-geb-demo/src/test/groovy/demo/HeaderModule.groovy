package demo

import geb.Module

class HeaderModule extends Module{
	static content = {
		pageTitle {$('h1').text()}
	}
}
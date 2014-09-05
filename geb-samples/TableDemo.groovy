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

class Record extends Module{
	static content = {
		column {index -> $('td', index)}
		productCode {column(1).text()}
		price { column(2).text().toInteger()}
	}
}

class ProductPage extends Page{
	static url = 'table.html'
	static content = {
		products {moduleList Record, $('table tbody tr')}
	}
}

Browser.drive() {
	to ProductPage
	products.each{ product ->
		println "${product.productCode} -> ${product.price}"
	}
}.quit()

println "Complete.."
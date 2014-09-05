@Grapes([
    @Grab("org.gebish:geb-core:0.9.3"),
    //@Grab(group='commons-codec', module='commons-codec', version='1.9'),
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.42.2"),
	//@Grab("org.seleniumhq.selenium:selenium-chrome-driver:2.42.0"),
    //@Grab("org.seleniumhq.selenium:selenium-support:2.42.0")
])

import geb.Browser
import org.openqa.selenium.firefox.FirefoxDriver

Browser browser = new Browser()

// driver.get("http://seleniumconf.org/")
browser.go 'http://seleniumconf.org/'
browser.quit()



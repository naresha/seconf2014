@Grapes([
    //@Grab("org.gebish:geb-core:0.9.3"),
    //@Grab(group='commons-codec', module='commons-codec', version='1.9'),
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.42.2"),
	//@Grab("org.seleniumhq.selenium:selenium-chrome-driver:2.42.0"),
    //@Grab("org.seleniumhq.selenium:selenium-support:2.42.0")
])

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By


WebDriver driver  = new FirefoxDriver()
driver.get("http://localhost:8000/app/login.html")
WebElement username = driver.findElement(By.name("j_username"))
username.sendKeys("user1")
WebElement password = driver.findElement(By.name("j_password"))
password.sendKeys("secret")
WebElement submit = driver.findElement(By.id("submit"))
submit.click()
driver.quit()
println "done"
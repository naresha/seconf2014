import org.openqa.selenium.firefox.FirefoxDriver

driver = { 
	def driverInstance = new FirefoxDriver() 
	driverInstance.manage().window().maximize() 
	driverInstance 
}

baseUrl = "http://localhost:8000/app/" 

/*
environments{
	chrome{
		driver = {
			
		}
	}
}
*/
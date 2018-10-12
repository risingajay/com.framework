package com.framework.test.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest { //created as abstract as we dont want anyone to create object of this class

	 private WebDriver driver;
	 
	 @BeforeMethod
	 public void beforeMethod() {
//		  System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		 System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
//	
//		 this.driver = new ChromeDriver();
		 this.driver = BrowserFactory.getInstance();
			
	 }
	
	 @AfterMethod
	 public void cleanUp() {
		 if(driver != null) {
		 driver.quit();
		 }
	 }
	 
	 protected WebDriver driver() {
		 return driver;
	 }
	
}

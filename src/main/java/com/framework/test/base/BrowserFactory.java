package com.framework.test.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.javafx.PlatformUtil;

public class BrowserFactory {
	

	
	public static WebDriver getInstance() {
		WebDriver driver = null;
		if(Constants.BROWSER_NAME.equalsIgnoreCase("Chrome")){
			switch (Constants.BROWSER_NAME.toUpperCase()) {
			case "CHROME":
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;
			case "FIREFOX":
				System.out.println("FireFox");
				break;
			default:
				new RuntimeException("Invalid Brower:" + Constants.BROWSER_NAME);
				break;
			}
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;
	}

}

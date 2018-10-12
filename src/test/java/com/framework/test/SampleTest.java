package com.framework.test;
//clean test -Dtest=SampleTest command to run from maven to run specific c

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.uncommons.reportng.HTMLReporter;

import com.framework.page.GoogleHomePage;
import com.framework.page.GoogleSearchResultPage;
import com.framework.test.base.BaseTest;

@Listeners(value=HTMLReporter.class)
public class SampleTest extends BaseTest {

	/* Without page object Model */
	@Test
	public void testCase1() {
		driver().get("http://www.google.com");
		driver().findElement(By.name("q")).sendKeys("Test Framework");
		driver().findElement(By.name("q")).submit();
		String pageUrl = driver().getCurrentUrl();
		Assert.assertTrue(pageUrl.startsWith("https://www.google.com/search"),"pageurl :"+ 
		                  driver().getCurrentUrl()+ "was not starting with http://www.google.co.in/search");
	}
	
	/* page object Model */
	@Test
	public void testCase2() {
		driver().get("http://www.google.com");
		// Now home page is opened... Now create object of googleHome page
		
	//	GoogleHomePage HomePage = new GoogleHomePage(driver());
		// Elements are not initialized
	//	PageFactory.initElements(driver(), HomePage); //Initialze elements init elements is static method
		GoogleHomePage HomePage = PageFactory.initElements(driver(), GoogleHomePage.class);
		HomePage.performSearch("Test");
	//	Assert.assertTrue(HomePage.getUrl());
	}
	@Test(invocationCount =3)
	public void testCase3() {
		driver().get("http://www.google.com");
		// Now home page is opened... Now create object of googleHome page
		
		GoogleHomePage HomePage = PageFactory.initElements(driver(), GoogleHomePage.class);
//		HomePage.performSearch("Test");
		GoogleSearchResultPage resultPage = HomePage.performSearch("Test");
		Assert.assertTrue(resultPage.getUrl().startsWith("https://www.google.com/search"),"pageurl :"+ 
				resultPage.getUrl()+ "was not starting with http://www.google.co.in/search");

		Assert.assertEquals(resultPage.getSearchedtext(), "Test","Test Did not matched");
		
	}
		
		
	
}

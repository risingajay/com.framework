package com.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.test.base.BasePage;
import com.framework.test.util.SyncUtil;

public class GoogleHomePage extends BasePage  {
	
	public GoogleHomePage(WebDriver driver) {
		super(driver);
	}
	
	//Data Member
	@FindBy(name = "q") // uses java reflection
	WebElement txtQueryBox;

	@FindBy(name = "btnk")
	WebElement btnGoogleSearch;

	//Method
	public GoogleSearchResultPage performSearch(String txtToSearch) {
		txtQueryBox.sendKeys(txtToSearch);
		txtQueryBox.submit();
		SyncUtil.wait(3);
		//btnGoogleSearch.click();
	return PageFactory.initElements(driver(), GoogleSearchResultPage.class);
	}
//public String getUrl(WebDriver driver) {
//	return driver.getCurrentUrl();
//}
}

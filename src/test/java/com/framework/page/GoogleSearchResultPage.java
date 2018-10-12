package com.framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.test.base.BasePage;

public class GoogleSearchResultPage extends BasePage  {

	public GoogleSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "resultsets")
	WebElement divResultSets;
	
	@FindBy(name = "q")
	WebElement txtSearchBox;
	
	public String getSearchedtext() {
		return txtSearchBox.getAttribute("value");
	}
}

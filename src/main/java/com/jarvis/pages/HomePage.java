package com.jarvis.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jarvis.keywords.Keyword;

public class HomePage {
	
//	Logger LOG = org.apache.logging.log4j.LogManager.getLogger(HomePage.class);
	
	org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(HomePage.class);
	
	//WebElement
	@FindBy(css="input.desktop-searchBar")
	public WebElement searchComponent;
	@FindBy(css="a.desktop-submit")
	public WebElement clickSearchComponent;
	
	//WebElements
//	public List<WebElement> searchComponent;

	public HomePage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	//Actions
	public void enterProductToSearch(CharSequence...productName) {
		searchComponent.sendKeys(productName);
		LOG.info("Entered product:"+productName+" to search");	
	}

	public void clickOnSearchMagnifier() {
		clickSearchComponent.click();
		LOG.info("Clicked On Search Magnifier");
	}
}

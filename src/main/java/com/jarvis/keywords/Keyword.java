package com.jarvis.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.jarvis.errors.InvalidBrowserError;
import com.jarvis.exceptions.InvalidSelectorException;

public class Keyword {
	
//	private static final Logger LOG = LogManager.getLogger(Keyword.class);
	
	private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.getLogger(Keyword.class);
	
	private static RemoteWebDriver driver = null;
	
	/**
	 * This method return the driver instance. make sure, before calling this method 
	 * one should call {@code openBrowser(String browserName)} method so that it can initialize driver instance
	 * @return driver instance
	 */
	public static RemoteWebDriver getDriver() {
		return driver;
	}
	
	public void openBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			LOG.info("Opeing Chrome Browser");
		}else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			LOG.info("Opening Firefox Browser");
		}else if(browserName.equalsIgnoreCase("InternetExplorer")) {
			driver= new InternetExplorerDriver();
			LOG.info("Opening IE Browser");
		}else {
			throw new InvalidBrowserError(browserName);
		}
	}
	
	/**
	 * This method will launch specified browser
	 * @param browserName to launch
	 */
	public void openUrl(String url) {
		driver.get(url);
		LOG.info("Luanching Url");
	}
	
	public void closeBrowser() {
		driver.close();
		LOG.info("Closing browser window");
	}
	
	public void quiteAllWindows() {
		driver.quit();
	}
	
	public void clickOn(WebElement element) {
		element.click();
	}
	
	public WebElement getWebElement(String locatorType, String locatorValue) {
		
		if(locatorType.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		}else if(locatorType.equalsIgnoreCase("css")){
			return driver.findElement(By.cssSelector(locatorValue));		
		}else if(locatorType.equalsIgnoreCase("xpath")){
			return driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equalsIgnoreCase("name")) {
			return driver.findElement(By.name(locatorValue));
		}else if(locatorType.equalsIgnoreCase("tagName")) {
			return driver.findElement(By.tagName(locatorValue));
		}else if(locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElement(By.linkText(locatorValue));
		}else if(locatorType.equalsIgnoreCase("partialLinkText")) {
			return driver.findElement(By.partialLinkText(locatorValue));
		}else if(locatorType.equalsIgnoreCase("className")) {
			return driver.findElement(By.className(locatorValue));
		}else {
			throw new InvalidSelectorException(locatorType);
		}
	}
	
	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		if(locatorType.equalsIgnoreCase("id")) {
			return driver.findElements(By.id(locatorValue));
		}else if(locatorType.equalsIgnoreCase("css")){
			return driver.findElements(By.cssSelector(locatorValue));		
		}else if(locatorType.equalsIgnoreCase("xpath")){
			return driver.findElements(By.xpath(locatorValue));
		}else if(locatorType.equalsIgnoreCase("name")) {
			return driver.findElements(By.name(locatorValue));
		}else if(locatorType.equalsIgnoreCase("tagName")) {
			return driver.findElements(By.tagName(locatorValue));
		}else if(locatorType.equalsIgnoreCase("linkText")) {
			return driver.findElements(By.linkText(locatorValue));
		}else if(locatorType.equalsIgnoreCase("partialLinkText")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		}else if(locatorType.equalsIgnoreCase("className")) {
			return driver.findElements(By.className(locatorValue));
		}else {
			throw new InvalidSelectorException(locatorType);
		}
	}
	
	public void clickOn(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}
	
	//Make it private
	private void enterText(String locatorType, String locatorValue, CharSequence...text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}
	
	public void enterText(String locator, CharSequence...text) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		enterText(locatorType, locatorValue, text);
	}
	
	public void hitkey(int keycode) {
		Robot robo;
		try {
			robo = new Robot();
			robo.keyPress(keycode);
			robo.keyRelease(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	// Make it private
	public List<String> getTexts(String locatorType, String locatorValue) {
		
		List<String> texts = new ArrayList<String>();
		List<WebElement> elements = new ArrayList<WebElement>();
		elements = getWebElements(locatorType, locatorValue);
		for(WebElement element : elements) {
			texts.add(element.getText());
		}
		return texts;
	}
	
	public List<String> getTexts(String locator) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		return getTexts(locatorType, locatorValue);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();	
	}

	public List<String> getTexts(List<WebElement> items) {
		List<String> texts = new ArrayList<String>();
		for(WebElement item : items) {
			texts.add(item.getText());
		}
		return texts;
	}

}

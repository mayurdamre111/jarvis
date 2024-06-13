package com.jarvis.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.jarvis.exceptions.InvalidSelectorException;
import com.jarvis.keywords.Keyword;

public class WaitFor {
	//Make it PRIVATE Method
	private static FluentWait<WebDriver> wait = null;
	static {
		wait = new FluentWait<WebDriver>(Keyword.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
	}
	
	public static void numberOfElementsToBeMoreThan(String locatorType, String locatorValue, int count) {
		By element = null;
		if(locatorType.equalsIgnoreCase("id")) {
			element = By.id(locatorValue);
		}else if(locatorType.equalsIgnoreCase("css")){
			element = By.cssSelector(locatorValue);		
		}else if(locatorType.equalsIgnoreCase("xpath")){
			element = By.xpath(locatorValue);
		}else if(locatorType.equalsIgnoreCase("name")) {
			element = By.name(locatorValue);
		}else if(locatorType.equalsIgnoreCase("tagName")) {
			element = By.tagName(locatorValue);
		}else if(locatorType.equalsIgnoreCase("linkText")) {
			element = By.linkText(locatorValue);
		}else if(locatorType.equalsIgnoreCase("partialLinkText")) {
			element = By.partialLinkText(locatorValue);
		}else if(locatorType.equalsIgnoreCase("className")) {
			element = By.className(locatorValue);
		}else {
			throw new InvalidSelectorException(locatorType);
		}
		
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(element, count));
	}

	public static void numberOfElementsToBeMoreThan(String locator, int count) {
		String locatorType = locator.split("##")[0];
		String locatorValue = locator.split("##")[1];
		numberOfElementsToBeMoreThan(locatorType, locatorValue, count);
	}

	public static void numberOfElementsToBeMoreThan(By productTitle, int count) {
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitle, count));
		
	}
}

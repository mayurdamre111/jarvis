package jarvis;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.jarvis.base.Locator;
import com.jarvis.base.TestBase;
import com.jarvis.keywords.Keyword;
import com.jarvis.pages.HomePage;
import com.jarvis.pages.SearchResultPage;
import com.jarvis.waits.WaitFor;

public class TestCases extends TestBase{

	@Test
	public void m1() {
		
		Keyword.getDriver().get("https://www.myntra.com/");
		Keyword.getDriver().manage().window().maximize();
		
		// EXPLICIT WAIT
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Keyword.getDriver());
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withTimeout(Duration.ofSeconds(60));
		wait.ignoring(NoSuchElementException.class);
		
		Keyword.getDriver().findElement(By.cssSelector("input.desktop-searchBar")).sendKeys("Levis",Keys.ENTER);
		List<WebElement> productTitles = Keyword.getDriver().findElements(By.cssSelector("h3.product-brand"));
		
		SoftAssert Softly = new SoftAssert();
		for(WebElement productTitle : productTitles) {
			String text = productTitle.getText();
			System.out.println(text);
			Softly.assertTrue(text.contains("Levis"));
		}
		Softly.assertAll();
	}
	
	@Test
	public void m2() {
		Keyword keyword = new Keyword();
		keyword.enterText(Locator.searchComponent, "Levis", Keys.ENTER);
//		keyword.hitkey(KeyEvent.VK_ENTER);
		
//		WaitFor.numberOfElementsToBeMoreThan(Locator.PRODUCTTITLE, 1);
		List<String> productTitles = keyword.getTexts(Locator.PRODUCTTITLE);
		
		SoftAssert softly = new SoftAssert();
		for(String productTitle : productTitles) {
			System.out.println("Checking : "+productTitle);
			softly.assertTrue(productTitle.contains("Levis"));
		}
		softly.assertAll();
	}
	
	@Test
	public void usingPageObjectModel() {
		
		HomePage onHomePage = new HomePage();
		onHomePage.enterProductToSearch("Levis", Keys.ENTER);
		SearchResultPage resultPage= new SearchResultPage();
		resultPage.verifyProductTitleContains("Levis");
	}
	
}

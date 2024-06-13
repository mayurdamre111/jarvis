package com.jarvis.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.jarvis.keywords.Keyword;

public class TestBase {
	
//	@Parameters("env")
	@BeforeMethod
	public void setUp() throws Exception {
		Keyword keyword = new Keyword();
		keyword.openBrowser(Config.getBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl("dev"));
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Keyword keyword = new Keyword();
		keyword.closeBrowser();
	}

}

package com.jarvis.stepdefinitions;

import com.jarvis.base.Config;
import com.jarvis.keywords.Keyword;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void setUp() {
		Keyword keyword = new Keyword();
		keyword.openBrowser(Config.getBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl("dev"));
	}
	
	@After
	public void tearDown() {
		Keyword keyword = new Keyword();
		keyword.quiteAllWindows();
	}

}

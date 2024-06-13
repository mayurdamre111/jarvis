package com.jarvis.stepdefinitions;

import com.jarvis.pages.HomePage;
import com.jarvis.pages.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {
	
	@Given("Enter Levis in search component")
	public void enterProductToSearch(){
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Levis");
	}
	
	@When("User click on search magnifier")
	public void clickOnSeaechMagnifier() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();
	}
	
	@Then("All results populated must contain word Levis in it.")
	public void assertResults() {
		SearchResultPage resultPage = new SearchResultPage();
		resultPage.verifyProductTitleContains("Levis");
	}

}

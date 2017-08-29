package com.fourstay.step_definitions;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebElement;

import com.fourstay.pages.SearcResultPage;
import com.fourstay.utilities.BrowserUtilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class staytest_37_StepDefinition {
	SearcResultPage searchPage = new SearcResultPage();

	@Given("^I enter beds \"([^\"]*)\"$")
	public void i_enter_beds(String numberOfBeds) throws Throwable {
		searchPage.bedsNum.sendKeys(numberOfBeds);
	}

	@Then("^the results should contain \"([^\"]*)\"$")
	public void the_results_should_contain(String expectedDate) throws Throwable {
		BrowserUtilities.switchTab("search");
		BrowserUtilities.waitForPageLoad();

		Set<String> actualDate = new HashSet<>();
		for (WebElement dates : searchPage.availableDates) {
			actualDate.add(dates.getText().replaceAll("FROM: ", ""));
		}
		System.out.println(actualDate);

		if (actualDate.contains(expectedDate)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}

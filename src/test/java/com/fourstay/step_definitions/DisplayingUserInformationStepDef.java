package com.fourstay.step_definitions;

import static org.testng.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearcResultPage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.BrowserUtilities;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DisplayingUserInformationStepDef {
	HomePage homePage = new HomePage();

	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		homePage.loginButton.click();
	}

	@Given("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String email) throws Throwable {
		Thread.sleep(2222);
		homePage.email.sendKeys(email);
	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String password) throws Throwable {
		homePage.pswd.sendKeys(password);
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		Thread.sleep(2222);
		homePage.signInButton.click();
	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String expectedName) throws Throwable {
		UserAccountPage useraccountPage = new UserAccountPage();
		String actual = useraccountPage.accountholder.getText();
		assertEquals(actual, expectedName);

	}

	// =========== stay_125

	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String school) throws Throwable {
		homePage.schoolName.sendKeys(school);
	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String start, String end) throws Throwable {

		homePage.startDate.sendKeys(start);
		homePage.endDate.sendKeys(end);
		Thread.sleep(2000);

	}

	@Given("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		Driver.getInstance().manage().window().maximize();
		Thread.sleep(2000);
		WebElement iframe = Driver.getInstance().findElement(By.xpath("//iframe[@class='intercom-launcher-frame']"));
		Driver.getInstance().switchTo().frame(iframe);

		Driver.getInstance().findElement(By.xpath("//div[@class='intercom-launcher-close-icon']")).click();
		Driver.getInstance().findElement(By.xpath("//div[@class='intercom-launcher-close-icon']")).click();
		Driver.getInstance().switchTo().defaultContent();
		homePage.search.click();
		Thread.sleep(2000);

	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
		BrowserUtilities.switchTab("search");
		BrowserUtilities.waitForPageLoad();

		SearcResultPage searcResultPage = new SearcResultPage();
		Set<String> actualStates = new HashSet<>();

		Thread.sleep(2000);
		for (WebElement element : searcResultPage.allstates) {
			actualStates.add(element.getText());

		}
		System.out.println("==========" + actualStates);
		Assert.assertTrue(actualStates.containsAll(states));
	}

	@When("^I enter this search criteria$")
	public void i_enter_this_search_criteria(List<Map<String, String>> searchCriteria) throws Throwable {
		Map<String, String> input = searchCriteria.get(0);
		homePage.schoolName.sendKeys(input.get("school"));
		homePage.startDate.sendKeys(input.get("start"));
		homePage.endDate.sendKeys(input.get("end"));
		homePage.search.click();

	}

}

package com.fourstay.step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserTypeLoginStepDefs {

	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
		HomePage homePage = new HomePage();
		homePage.loginButton.click();
		Thread.sleep(2000);
		homePage.email.sendKeys(ConfigurationReader.getProperty("host.username"));
		Thread.sleep(2000);

		homePage.pswd.sendKeys(ConfigurationReader.getProperty("host.password"));
		homePage.signInButton.click();
	}

	@Then("^I should be able verify I am logged in$")
	public void i_should_be_able_verify_I_am_logged_in() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 5000);
		wait.until(ExpectedConditions.urlContains("dashboard"));
	}

	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
		HomePage homePage = new HomePage();
		Thread.sleep(1000);

		homePage.loginButton.click();
		Thread.sleep(2000);
		homePage.email.sendKeys(ConfigurationReader.getProperty("guest.username"));
		Thread.sleep(2000);

		homePage.pswd.sendKeys(ConfigurationReader.getProperty("guest.password"));
		homePage.signInButton.click();
		Thread.sleep(1000);
		Assert.assertTrue(Driver.getInstance().getCurrentUrl().contains("dashboard/"));

	}

}

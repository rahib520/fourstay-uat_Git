package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class PageObject {
	WebDriver driver;

	public PageObject(WebDriver driver) {
		this.driver = Driver.getInstance();

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[@data-target='#modal-login']")
	public WebElement loginButton;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "key")
	public WebElement pswd;

	@FindBy(id = "btn-login")
	public WebElement signInButton;

	@FindBy(xpath = "//h3[@class='user-name ng-binding']")
	public WebElement hostName;

}

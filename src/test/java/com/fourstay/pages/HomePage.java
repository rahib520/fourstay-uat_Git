package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class HomePage {

	public HomePage() {
		PageFactory.initElements(Driver.getInstance(), this);

	}

	// login
	@FindBy(xpath = "//li[@data-target='#modal-login']")
	public WebElement loginButton;

	// email

	@FindBy(id = "email")
	public WebElement email;
	// pswd
	@FindBy(id = "key")
	public WebElement pswd;

	// login
	@FindBy(id = "btn-login")
	public WebElement signInButton;

	@FindBy(xpath = "//span[.='LOGOUT']")
	public WebElement logOut;

	// Stay test_125

	@FindBy(id = "iLocName")
	public WebElement schoolName;

	@FindBy(id = "rentoutfrom2")
	public WebElement startDate;

	@FindBy(id = "rentoutto2")
	public WebElement endDate;

	@FindBy(id = "search")
	public WebElement search;

}

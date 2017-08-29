package com.fourstay.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class SearcResultPage {
	public SearcResultPage() {
		PageFactory.initElements(Driver.getInstance(), this);

	}

	@FindBy(css = ".col-md-12>p")
	public List<WebElement> allstates;

	@FindBy(id = "themates")
	public static WebElement bedsNum;

	@FindBy(css = "span[class='ng-binding']")
	public List<WebElement> availableDates;

	@FindBy
	public WebElement refreshPageByBedNum;

}

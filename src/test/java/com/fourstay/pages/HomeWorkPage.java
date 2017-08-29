package com.fourstay.pages;

import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class HomeWorkPage {

	public HomeWorkPage() {

		PageFactory.initElements(Driver.getInstance(), this);

	}

}

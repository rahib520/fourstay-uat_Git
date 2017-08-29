package com.heroakuapp;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

public class EmployeeTableTest {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = Driver.getInstance();
		driver.get(ConfigurationReader.getProperty("herokuURL"));
	}

	@Test
	public void test() {
		WebElement webtable1 = driver.findElement(By.id("table1"));
		List<WebElement> rows = webtable1.findElements(By.tagName("tr"));
		System.out.println("First Table Size" + rows.size());

		WebElement webtable2 = driver.findElement(By.id("table2"));
		List<WebElement> rows2 = webtable2.findElements(By.tagName("tr"));
		System.out.println("Second Table Size" + rows2.size());

		List<WebElement> cells = rows.get(0).findElements(By.tagName("th"));

		System.out.println(cells.get(0).getText());

	}

}

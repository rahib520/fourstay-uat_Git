package com.fourstay.step_definitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.utilities.ConfigurationReader;
import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class HomeWork {

	WebDriver driver = Driver.getInstance();

	@Given("^Wait for the webtable to be visible$")
	public void wait_for_the_webtable_to_be_visible() throws Throwable {
		driver.get(ConfigurationReader.getProperty("HWURL"));
	}

	@When("^Assert that headers size is (\\d+)\\.$")
	public void assert_that_headers_size_is(int arg1) throws Throwable {
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='example']/thead/tr/th"));
		int size = table.size();
		System.out.println(size);
		assertEquals(size, 6);
	}

	@When("^Assert headers are “Name, Position,Office,Extn\\., Start Date, Salary$")
	public void assert_headers_are_Name_Position_Office_Extn_Start_Date_Salary() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> table = driver.findElements(By.xpath("//table[@id='example']/thead/tr/th"));
		List<String> actual = Arrays.asList("Name", "Position", "Office", "Extn.", "Start date", "Salary");
		List<String> expected = new ArrayList<>();
		for (WebElement t : table) {
			expected.add(t.getText());
		}
		System.out.println(actual);
		System.out.println(expected);
		assertTrue(actual.equals(expected));
	}

	@When("^Find Bruno Nash in the table then verify that he is a Software Engineer and works in London$")
	public void find_Bruno_Nash_in_the_table_then_verify_that_he_is_a_Software_Engineer_and_works_in_London()
			throws Throwable {

		// === THIS WAY WORKS TOO ====
		// String RowBruno = driver.findElement(By.id("row_43")).getText();
		// assertTrue(RowBruno.contains("Software Engineer"));
		// assertTrue(RowBruno.contains("London"));

		WebElement bru = driver.findElement(By.id("row_43"));
		List<WebElement> cells = bru.findElements(By.tagName("td"));
		List<String> brunoinfo = new ArrayList<>();
		for (WebElement cell : cells) {
			brunoinfo.add(cell.getText());

		}
		assertTrue(brunoinfo.get(0).equals("Bruno Nash"));
		assertTrue(brunoinfo.get(1).equals("Software Engineer"));
		assertTrue(brunoinfo.get(2).equals("London"));

	}

	@When("^Print all webtable content in a similar looking format$")
	public void print_all_webtable_content_in_a_similar_looking_format() throws Throwable {

		WebElement table = driver.findElement(By.xpath("//table[@id='example']"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));
		for (WebElement row : rows) {
			System.out.println(row.getText());
		}

	}

	@When("^Click on NEW button$")
	public void click_on_NEW_button() throws Throwable {
		driver.findElement(By.xpath("//a[.='New']")).click();
	}

	@When("^Add new Employee information$")
	public void add_new_Employee_information() throws Throwable {
		driver.findElement(By.id("DTE_Field_first_name")).sendKeys("Rahib");
		driver.findElement(By.id("DTE_Field_last_name")).sendKeys("Asadov");
		driver.findElement(By.id("DTE_Field_position")).sendKeys("SDET");
		driver.findElement(By.id("DTE_Field_office")).sendKeys("Washington Dc");
		driver.findElement(By.id("DTE_Field_extn")).sendKeys("00001");
		driver.findElement(By.id("DTE_Field_start_date")).sendKeys("2017-08-01");
		driver.findElement(By.id("DTE_Field_salary")).sendKeys("111111");
		driver.findElement(By.xpath("//button[@class='btn']")).click();

	}

	@When("^Search for the employee$")
	public void search_for_the_employee() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^Verify All data displayed in the webtable matched the data you entered in step (\\d+)\\.$")
	public void verify_All_data_displayed_in_the_webtable_matched_the_data_you_entered_in_step(int arg1)
			throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}

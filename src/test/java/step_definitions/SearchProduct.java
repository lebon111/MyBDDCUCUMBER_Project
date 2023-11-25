package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.bdd.learning.DriverLogic.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {
	
	public WebDriver driver;
	
	

	@Given("User opens the application")
	public void user_opens_the_application() {
		driver = DriverFactory.getDriver();
		
	}

	

	@When("User enters the valid product {string}")
	public void user_enters_the_valid_product(String validProductText) {
	  driver.findElement(By.name("search")).sendKeys(validProductText); 
	}
	
	@Given("User clicks on the search button")
	public void user_clicks_on_the_search_button() {
	   driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
	}

	@Then("User gets valid product info display in SearchPage")
	public void user_gets_valid_product_info_display_in_search_page() {
		driver.findElement(By.linkText("HP LP3065")).isDisplayed();
	  
	}

	@When("User enters the invalid product {string}")
	public void user_enters_the_invalid_product(String invalidProductText) {
		  driver.findElement(By.name("search")).sendKeys(invalidProductText); 
	}

	@Then("User gets warning message")
	public void user_gets_warning_message() {
	  Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]")).isDisplayed());
	}



}

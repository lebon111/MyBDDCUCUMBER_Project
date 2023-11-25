package step_definitions;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.bdd.learning.DriverLogic.DriverFactory;
import com.tutorialsninja.bdd.qa.Utilities.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	
	public WebDriver driver;
	

	@Given("User navigates to RegisterPage")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();
	    driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@Given("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	  
	}

	@When("User enters below mandatory fields")
	public void user_enters_below_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String>dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	}
	
	@When("User enters below all fields")
	public void user_enters_below_all_fields(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String>dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	}
	
	@When("User enters below all fields with existing email")
	public void user_enters_below_all_fields_with_existing_email(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String>dataMap = dataTable.asMap(String.class, String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	}

	@When("User selects PrivacyPolicy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		  driver.findElement(By.xpath("//input[@name = 'agree' and @value = '1']")).click(); 
	}

	@Then("User account gets created successfully")
	public void user_account_gets_created_successfully() {
	 Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")).isDisplayed());
	}

	@When("User selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		 driver.findElement(By.xpath("//input[@name = 'newsletter' and @value = '1']")).click();
	}

	@Then("User gets warning message of duplicate email")
	public void user_gets_warning_message_of_duplicate_email() {
	  String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
      String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
      Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	@Then("User gets warning message for mandatory fields")
	public void user_gets_warning_message_for_mandatory_fields() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText().contains("Warning:You must agree to the Privacy Policy!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")).getText().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")).getText().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")).getText().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")).getText().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Password must be between 4 and 20 characters!')]")).getText().contains("Password must be between 4 and 20 characters!"));
	}
}

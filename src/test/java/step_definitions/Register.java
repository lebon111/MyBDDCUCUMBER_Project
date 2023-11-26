package step_definitions;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.bdd.learning.DriverLogic.DriverFactory;
import com.bdd.learning.Pages.AccountSuccessPage;
import com.bdd.learning.Pages.HomePage;
import com.bdd.learning.Pages.LoginPage;
import com.bdd.learning.Pages.RegisterPage;
import com.tutorialsninja.bdd.qa.Utilities.Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Register {
	
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public RegisterPage registerpage;
	public Map<String, String>dataMap;
	public AccountSuccessPage accountsuccesspage;
	

	@Given("User navigates to RegisterPage")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();	
		homepage = new HomePage(driver);
        homepage.clickOnMyAccount();
		//driver.findElement(By.linkText("My Account")).click();
        registerpage = homepage.selectRegisterOption();
		//driver.findElement(By.linkText("Register")).click(); - this leads to RegisterPage
	}

	

	@When("User enters below mandatory fields")
	public void user_enters_below_mandatory_fields(io.cucumber.datatable.DataTable dataTable) {
		dataMap = dataTable.asMap(String.class, String.class);
		//registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("lastname"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	}
	
	@When("User enters below all fields")
	public void user_enters_below_all_fields(io.cucumber.datatable.DataTable dataTable) {
		dataMap = dataTable.asMap(String.class, String.class);
		//registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("lastname"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(Util.emailWithDateTimeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	}
	
	@When("User enters below all fields with existing email")
	public void user_enters_below_all_fields_with_existing_email(io.cucumber.datatable.DataTable dataTable) {
		dataMap = dataTable.asMap(String.class, String.class);
		//registerpage = new RegisterPage(driver);
		registerpage.enterFirstName(dataMap.get("firstname"));
		registerpage.enterLastName(dataMap.get("lastname"));
		registerpage.enterEmail(dataMap.get("email"));
		registerpage.enterTelephone(dataMap.get("telephone"));
		registerpage.enterPassword(dataMap.get("password"));
		registerpage.enterConfirmPassword(dataMap.get("confirmpassword"));
		
		//driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		//driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		//driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("confirmpassword"));
	}
	
	@When("User selects Yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		//registerpage = new RegisterPage(driver);
		registerpage.clickOnNewsLetterYesOptionRadioButton();
	    //driver.findElement(By.xpath("//input[@name = 'newsletter' and @value = '1']")).click();
	}

	@When("User selects PrivacyPolicy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		//registerpage = new RegisterPage(driver);
		registerpage.clickOnPrivacyPolicyCheckBox();
		//driver.findElement(By.xpath("//input[@name = 'agree' and @value = '1']")).click(); 
	}
	
	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		//registerpage = new RegisterPage(driver);
		accountsuccesspage = registerpage.clickOnContinueButton(); 
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click(); this will take us to AccountSuccessPage
	  
	}

	@Then("User account gets created successfully")
	public void user_account_gets_created_successfully() {
	 //accountsuccesspage = new AccountSuccessPage(driver);
	 Assert.assertTrue(accountsuccesspage.verifyDisplayStatusOfAccountSuccessMessage());
	 //Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Congratulations! Your new account has been successfully created!')]")).isDisplayed());
	}



	@Then("User gets warning message of duplicate email")
	public void user_gets_warning_message_of_duplicate_email() {
	  //registerpage = new RegisterPage(driver);
	  String actualWarningMessage = registerpage.retrieveDuplicateEmailWarning();
	  //String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
      String expectedWarningMessage = "Warning: E-Mail Address is already registered!";
      Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
	}
	
	@Then("User gets warning message for mandatory fields")
	public void user_gets_warning_message_for_mandatory_fields() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")).getText().contains("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")).getText().contains("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'E-Mail Address does not appear to be valid!')]")).getText().contains("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")).getText().contains("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Password must be between 4 and 20 characters!')]")).getText().contains("Password must be between 4 and 20 characters!"));
	}
}

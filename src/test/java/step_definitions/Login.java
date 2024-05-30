package step_definitions;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialNinja.DriverLogic.DriverFactory;
import com.tutorialNinja.Pages.AccountPage;
import com.tutorialNinja.Pages.HomePage;
import com.tutorialNinja.Pages.LoginPage;
import com.tutorialsninja.Utilities.Util;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	public WebDriver driver;
	public HomePage homepage;
	public LoginPage loginpage;
	public AccountPage accountpage;
	public Properties dataprop;

	@Given("^User ([a-zA-Z]{1,}) to LoginPage$")
	public void user_navigates_to_loginpage(String navigationMode) {
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		//driver.findElement(By.linkText("My Account")).click();
		loginpage = homepage.selectLoginOption(); //this takes us to LoginPage
		//driver.findElement(By.linkText("Login")).click(); //this takes us to LoginPage

	}

	@When("^User enters valid email (.+) into email textbox field$")
	public void user_enters_valid_email_into_email_textbox_field(String validEmailText) {
		loginpage.enterEmail(validEmailText);
		//driver.findElement(By.id("input-email")).sendKeys(validEmailText);
	}

	@And("^User enters valid password (.+) into password textbox field$")
	public void user_enters_valid_password_into_password_textbox_field(String validPasswordText) {
		loginpage.enterPassword(validPasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(validPasswordText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
	
		accountpage = loginpage.clickOnLoginButton();
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click();       //will take us to AccountPage
	}

	@Then("User is navigated to AccountPage")
	public void user_is_navigated_to_accountpage() {
		accountpage.validateDisplayStatusOfEditAccountInfoLink();
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}

	@When("User enters invalid email into email textbox field")
	public void user_enters_invalid_email_into_email_textbox_field() {
		loginpage.enterEmail(Util.emailWithDateTimeStamp());
		//driver.findElement(By.id("input-email")).sendKeys(invalidEmailText);
	}

	@And("User enters invalid password {string} into password textbox field")
	public void user_enters_invalid_password_into_password_textbox_field(String invalidPasswordText) {
		loginpage.enterPassword(invalidPasswordText);
		//driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
	}

	@Then("User gets warning message about credentials mismatch")
	public void user_gets_warning_message_about_credentials_mismatch() {
		//dataprop = new Properties();
		String actualWarningMessage = loginpage.retrieveCredentialsMismatchWarningMessage();
		String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password."; //dataprop.getProperty("emailPasswordNoMatchWarningMessage");
		//String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
		//String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

	}
	
}

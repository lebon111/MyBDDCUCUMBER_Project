package step_definitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.tutorialNinja.DriverLogic.DriverFactory;
import com.tutorialNinja.Pages.AccountPage;
import com.tutorialNinja.Pages.AddToCartPage;
import com.tutorialNinja.Pages.HomePage;
import com.tutorialNinja.Pages.LoginPage;
import com.tutorialNinja.Pages.LogoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOut {
	public WebDriver driver;
	public  HomePage homepage;
	public  LoginPage loginpage;
	public  AccountPage accountpage;
	public LogoutPage logoutpage; 
	public Properties dataprop;
	
	@Given("I am logged in to the Tutorialsninja demo website")
	public void i_am_logged_in_to_the_tutorialsninja_demo_website() {
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.LoginInn();	
		}

	@When("I click on the Logout link")
	public void i_click_on_the_link() {
		logoutpage = new LogoutPage(driver);
	    logoutpage.logoutOptionClick();
	}

	@Then("I should see a message indicating that I have been logged out successfully")
	public void i_should_see_a_message_indicating_that_i_have_been_logged_out_successfully() {
		logoutpage = new LogoutPage(driver);
	    logoutpage.retrieveAccountLogoutText();
	}

	@When("I click on the Logout link from the My Account dropdown")
	public void i_click_on_the_link_from_the_my_account_dropdown() {
		logoutpage = new LogoutPage(driver);
	    logoutpage.myAccountDropDownClick();
	    logoutpage.logoutDropDownClick();
	    
	}


}

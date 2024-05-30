package step_definitions;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tutorialNinja.DriverLogic.DriverFactory;
import com.tutorialNinja.Pages.AddToCartPage;
import com.tutorialNinja.Pages.HomePage;
import com.tutorialNinja.Pages.LoginPage;
import com.tutorialNinja.Pages.LogoutPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {
	
	public WebDriver driver;
	public  HomePage homepage;
	public  LoginPage loginpage;
	public  AddToCartPage addToCart;
	public LogoutPage logoutpage;
	public Properties dataprop;
	
	@Given("User is on the Homepage")
	public void user_is_on_the_homepage() {
		driver = DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.LoginIn();
		
	    
	}

	@When("User click on Iphone link")
	public void user_click_on_link() {
		homepage = new HomePage(driver);
		homepage.clickIphoneLink();
    
	}

	@When("User enters quantity using the Select class")
	public void user_enters_quantity_using_the_select_class() {
		addToCart = new AddToCartPage(driver);
		addToCart.quantityTextBox();
	    
	}

	@When("User clicks on the Add To Cart button")
	public void user_clicks_on_the_button() {
		addToCart = new AddToCartPage(driver);
		addToCart.clickAddToCardButton();
	    
	}

	@Then("the message should be displayed")
	public void the_message_should_be_displayed() {
		Assert.assertTrue(addToCart.successMessageText());
	    
	}

	@When("User clicks on Phones & PDAs link")
	public void user_clicks_on_link() {
		homepage = new HomePage(driver);
		homepage.clickPhonesPDAs();
	    
	}

	@When("User search for product")
	public void user_search_for_product() {
		homepage = new HomePage(driver);
		homepage.searchValidProduct();
		
	    
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		homepage = new HomePage(driver);
		homepage.clickOnSearchIcon();
	    
	}

	@When("Select product")
	public void select_product() {
		homepage = new HomePage(driver);
		homepage.searchProduct_Link();
	    
	}

	@When("Verify the Text")
	public void verify_the_text() {
		addToCart = new AddToCartPage(driver);
		addToCart.successMessageText();
	    
	}

	@When("Select Delivery Date")
	public void select_delivery_date() {
		addToCart = new AddToCartPage(driver);
		addToCart.selectDeliveryDate();
	    
	}

	@When("Verify the Message Success")
	public void verify_the_message_success(String string) {
		addToCart = new AddToCartPage(driver);
		addToCart.successMessageText();
	    
	}
	
	

	
	
	
	

}

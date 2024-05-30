package com.tutorialNinja.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CheckOutPage {
	public WebDriver driver;
	
	
	@FindBy(xpath = "//span[normalize-space()='Checkout']")
	private WebElement checkOut;
	
	@FindBy (xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
	private WebElement emptyShoppingCartMessage;
	
	@FindBy(css = "input[value='existing']")
	private WebElement existingAddress;
	
	@FindBy(xpath="input[value='new']")
	private WebElement newAddress;

	@FindBy(id="input-payment-firstname")
	private WebElement firstnameTextBox;

	@FindBy(id="input-payment-lastname")
	private WebElement lastnameTextBox;

	@FindBy(id="input-payment-address-1")
	private WebElement address1TextBox;

	@FindBy(id="input-payment-city")
	private WebElement cityTextBox;

	@FindBy(id="input-payment-postcode")
	private WebElement postcodeTextBox;

	@FindBy(id="input-payment-country")
	private WebElement countryDropdownBox;

	@FindBy(id="input-payment-zone")
	private WebElement stateDropdownBox;

	@FindBy(id="button-payment-address")
	private WebElement step2Continue;

	@FindBy(id="button-shipping-address")
	private WebElement step3Continue;
	
	@FindBy(id="button-shipping-method")
	private WebElement step4Continue;
	
	@FindBy(id="button-payment-method")
	private WebElement step5Continue;
	
	@FindBy(id="button-confirm")
	private WebElement confirm;

	@FindBy(css="input[name='agree']")
	private WebElement termsCheckBox;
	
	//**********Warning Messages**********//
	@FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'Address 1 must be between 3 and 128 characters!')]")
	private WebElement address1WarningMessage;
	
	@FindBy(xpath = "//div[contains(text(),'City must be between 2 and 128 characters!')]")
	private WebElement cityWarningMessage;
	
	
	
	public CheckOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void enterBillingDetails(String firstName,String lastName,String address1,String city,String postcode, String country,String state) {
		try {
			int countryIndex,stateIndex;
			try{
				countryIndex = Integer.parseInt(country);
				stateIndex = Integer.parseInt(state);
			}catch(NumberFormatException e){
				countryIndex = 0;
				stateIndex = 0;
			}
			firstnameTextBox.sendKeys(firstName);
			lastnameTextBox.sendKeys(lastName);
			this.address1TextBox.sendKeys(address1);
			this.cityTextBox.sendKeys(city);
			Select countrySelect = new Select(this.countryDropdownBox);
			countrySelect.selectByIndex(countryIndex);
			Thread.sleep(3000);
			Select stateSelect = new Select(this.stateDropdownBox);
			stateSelect.selectByIndex(stateIndex);
			step2Continue.click();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	public void selectExistingAddress() {
		existingAddress.click();
	}
	public void selectNewAddress() {
		newAddress.click();
	}
	public void clickStep2Continue() {
		step2Continue.click();
	}
	public void clickStep3Continue() {
		step3Continue.click();
	}
	public void clickStep4Continue() {
		step4Continue.click();
	}
	public void clickStep5Continue() {
		step5Continue.click();
	}
	public void clickTermsCheckBox() {
		termsCheckBox.click();
	}
	public void confirmOrder() {
		confirm.click();
	}
	
	public void enterDeliveryDetails() {
		driver.findElement(By.cssSelector("input[value='existing'][name='shipping_address']")).click();
		step3Continue.click();
	
	}	
	public void enterDeliveryMethod() {
		step4Continue.click();		
	}
	public void clickTermsAndCondition() throws InterruptedException{		
		driver.findElement(By.xpath("//input[@name='shipping_method']")).click();
		clickStep5Continue();
		Thread.sleep(3000);
		confirmOrder();
		Thread.sleep(3000);
	}
	public void enterPaymentMethod() {
		step5Continue.click();		
	}
	//**********Warning Messages**********//
	
	public String retrieveFirstnameWarningMessage() {
		String text = firstNameWarningMessage.getText();
		return text;
	}
	
	public String retrieveLastnameWarningMessage() {
		String text = lastNameWarningMessage.getText();
		return text;
	}
	
	public String retrieveAddress1WarningMessage() {
		String text = address1WarningMessage.getText();
		return text;
	}
	
	public String retrieveCityWarningMessage() {
		String text = cityWarningMessage.getText();
		return text;
	}
	
	
	
	
}

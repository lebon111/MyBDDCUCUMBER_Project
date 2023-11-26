package com.bdd.learning.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameTextBox;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameTextBox;
	
	@FindBy(id = "input-email")
	private WebElement emailTextBox;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneTextBox;

	@FindBy(id = "input-password")
	private WebElement passwordTextBox;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
	private WebElement newsLetterYesRadioButton;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFirstName(String firstnametext) {
		firstNameTextBox.sendKeys(firstnametext);
	}
	
	public void enterLastName(String lastnametext) {
		lastNameTextBox.sendKeys(lastnametext);
	}
	
	public void enterEmail(String emailtext) {
		emailTextBox.sendKeys(emailtext);
	}
	
	public void enterTelephone(String telephonetext) {
		telephoneTextBox.sendKeys(telephonetext);
	}
	
	public void enterPassword(String passwordtext) {
		passwordTextBox.sendKeys(passwordtext);
	}
	
	public void enterConfirmPassword(String confirmpasswordtext) {
		confirmPasswordTextBox.sendKeys(confirmpasswordtext);
	}
	
	public void clickOnNewsLetterYesOptionRadioButton() {
		newsLetterYesRadioButton.click();
	}
	
	public void clickOnPrivacyPolicyCheckBox() {
		privacyPolicyCheckBox.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public String retrieveDuplicateEmailWarning() {
		String duplicateEmailWarning = duplicateEmailWarningMessage.getText();
		return duplicateEmailWarning;
		
	}
}

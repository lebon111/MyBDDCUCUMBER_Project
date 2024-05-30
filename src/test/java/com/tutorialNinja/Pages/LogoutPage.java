package com.tutorialNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	
	public WebDriver driver;
	
	@FindBy (css = "div[id='content'] h1")
	private WebElement accountLogout;
	
	@FindBy (css = ".btn.btn-primary")
	private WebElement continueBtn;
	
	@FindBy (linkText = "Logout")
	private WebElement logoutOption;
	
	@FindBy (css = "//div[@id='top-links']//a[@title='My Account']/span[.='My Account']")
	private WebElement myAccountDropDown;
	
	@FindBy (css = "/.list-inline  ul > li:nth-of-type(5) > a")
	private WebElement logoutDropDown;
	
	
	
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String retrieveAccountLogoutText() {
		String accountLogoutText = accountLogout.getText();
		return accountLogoutText;
		
	}
	public void clickContinueBtn() {
		continueBtn.click();
	}
	public void myAccountDropDownClick() {
		myAccountDropDown.click();
	}
	public void logoutOptionClick() {
		logoutOption.click();
	}
	
	public void logoutDropDownClick() {
		logoutDropDown.click();
	}
	

}

package com.tutorialNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	

	public WebDriver driver;
	
	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInfoLink;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutLink;
	
	@FindBy(css = ".list-inline  ul > li:nth-of-type(5) > a")
	private WebElement logoutOption;
	

	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateDisplayStatusOfEditAccountInfoLink() {
		boolean displayStatus = editAccountInfoLink.isDisplayed();
		return displayStatus;
	}
	
	public boolean logoutLinkClick() {
		boolean displayStatlogL = logoutLink.isDisplayed();
		return displayStatlogL;
	}
	public void  logoutLinkOption() {
		 logoutOption.click();
		
	
	}
}

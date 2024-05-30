package com.tutorialNinja.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddToCartPage {
	public WebDriver driver;
	public Select select;
	
	
	
	@FindBy(css = "div[id='content'] h1")
	private WebElement itemCartText;
	
	@FindBy(css = "button.btn.btn-primary.btn-lg.btn-block")
	private WebElement addToCartButton;
	
	@FindBy(xpath = "//div[@id='product-product']/div[1]")
	private WebElement getAddedItemSuccessMessage;
	
	@FindBy(css = "#input-option225")
	private WebElement deliveryDateTextBox;
	
	@FindBy(xpath = "//div[@class='input-group date']//button[@type='button']")
	private WebElement calendarButton;
	
	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement qtyTextBox;
	
	@FindBy(css = ".alert.alert-dismissible.alert-success > a:nth-of-type(2)")
	private WebElement shoppingCardLink;
	
	@FindBy(xpath = "//div[@id='product-product']//div[@class='btn-group']//button[1]")
	private WebElement wishListButton;
	
	@FindBy(css = "//div.alert.alert-danger.alert-dismissible']")
	private WebElement warningMessageNotInStock;
	
	
	
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	private WebElement addedItemToWishListSuccessMessage;
	
	@FindBy(xpath = "//span[normalize-space()='Wish List (1)']")
	private WebElement wishListCart;
	
	
	
	@FindBy(xpath = "//h1[normalize-space()='HP LP3065']")
	private WebElement itemCartTextSP;
	
	@FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
	private WebElement monthAndYearText;
	
	
	@FindBy (xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
	private WebElement datePicker;
	
	@FindBy (xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
	private WebElement allDates;
	 
	
	
	
	
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean getAddedItemText() {
		boolean itemName = itemCartText.isDisplayed();
		return itemName;
		
	}
	
	public void clickAddToCardButton() {
		addToCartButton.click();
		
	}
	public void deliveryDateTextBox() {
		deliveryDateTextBox.clear();
		
	}
	
	 public void selectDeliveryDate()
	    {
	        String year = "2024";
	        String month = "july";
	        String date = "30";
	        calendarButton.click();
	        while(true)
	        {
	            String monthAndYear1 = monthAndYearText.getText();
	            String arr[] = monthAndYear1.split(" ");
	            String mon = arr[0] ;
	            String yer = arr[1];
	            if(mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year))
	            {
	                break;
	            }
	            else
	            {
	                datePicker.click();;
	            }


	        }
	        List<WebElement> allDates1 = allDates.findElements(null);
	        for(WebElement dateList:allDates1)
	        {
	            if(dateList.getText().equalsIgnoreCase(date))
	            {
	                dateList.click();
	                break;
	            }
	        }
    }
	public void calendarButtonDate() {
		calendarButton.click();
		select = new Select(driver.findElement(By.cssSelector(".datepicker-years [colspan] .year:nth-of-type(6)")));
		select.selectByVisibleText("");
		
		
		
		
		select = new Select(driver.findElement(By.cssSelector(".datepicker-months [colspan] .month:nth-of-type(7)")));
		select.selectByVisibleText("");
		
		
		select = new Select(driver.findElement(By.cssSelector( ".datepicker-days tr:nth-of-type(2) td:nth-of-type(4)")));
		select.selectByVisibleText("");
		
	}
	
	public void quantityTextBox() {
		
		//WebElement qtyField = driver.findElement(By.cssSelector("input#input-quantity"));

	    //qtyField.clear();

	    //qtyField.sendKeys(qty);
		
		driver.findElement(By.id("input-quantity")).clear();
		driver.findElement(By.id("input-quantity")).sendKeys("1");
	}
	
	public boolean successMessageText() {
		boolean successMsgTxt = getAddedItemSuccessMessage.isDisplayed();        
		return successMsgTxt;

    }
		
	
	public void shoppingCLink() {
		shoppingCardLink.click();
	}
	
	
	public String retrieveWarningMessageNotInStock() {
		String notAvailbleNotonStock = warningMessageNotInStock.getText();
		return notAvailbleNotonStock;
		
	}

	public String successMessageTextWishList() {
	String successMsgTxtWL =  addedItemToWishListSuccessMessage.getText();
	return successMsgTxtWL ;
	}
	
	
	public void clickWishListButton() {
		wishListButton.click();
		
		
	}
	
	public String retrieveItemCartTextSP() {
		String retrieveTextSP = itemCartTextSP.getText();
		return retrieveTextSP;
				
		
	}
	
	

}

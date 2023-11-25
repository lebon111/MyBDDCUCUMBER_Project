package com.bdd.learning.Hooks;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import com.bdd.learning.DriverLogic.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
	
	public WebDriver driver;
	
	
	@Before
	public void setup() {
		DriverFactory.initializeBrowser("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(1000));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}

}

package com.bdd.learning.Hooks;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.bdd.learning.DriverLogic.DriverFactory;
import com.tutorialsninja.bdd.qa.Utilities.ConfigReader;
import com.tutorialsninja.bdd.qa.Utilities.DataPropReader;
import com.tutorialsninja.bdd.qa.Utilities.Util;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class MyHooks {
	
	public WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	
	
	@Before
	public void setup() throws Exception {
		prop = ConfigReader.initializeConfigPropertiesFile();
		dataprop = DataPropReader.initializeDataPropPropertiesFile();
		DriverFactory.initializeBrowser(prop.getProperty("browser"));
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Util.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Util.PAGE_LOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Util.SCRIPT_TIME));
		//driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}
	
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	
	@BeforeStep(order = 1)
	public void checksBeforeEachStepPriority1() {
		System.out.println("Checking before every step everything working fine or not - Prioritized 1");
	}
	
	@BeforeStep(order = 2)
	public void checksBeforeEachStepPriority2() {
		System.out.println("Checking before every step everything working fine or not - - Prioritized 2");
	}
	
	@AfterStep(order = 2)
	public void checksAfterEachStepPriority1() {
		System.out.println("Checking after every step everything is working fine or not - Priority 1");
	}
	
	@AfterStep(order = 1)
	public void checksAfterEachStepPriority2() {
		System.out.println("Checking after every step everything is working fine or not - Priority 2");
	}

}

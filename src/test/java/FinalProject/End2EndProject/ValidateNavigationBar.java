package FinalProject.End2EndProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPages;

import org.apache.logging.log4j.*;

public class ValidateNavigationBar extends BaseClass{
	
	//public static Logger log =  LogManager.getLogger(ValidateNavigationBar.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initializeDriver() throws IOException{
		driver = mainDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void NavigationBarValidation() throws IOException{		
		LandingPages landingPages = new LandingPages(driver);
		Assert.assertTrue(landingPages.getnavBar().isDisplayed());		
	}
	
	@AfterTest
	public void CloseDriver(){
		driver.close();
		log.info("Driver is Closed");
	}

}

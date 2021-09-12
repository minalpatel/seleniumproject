package FinalProject.End2EndProject;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPages;

public class ValidateMovingURL extends BaseClass {
	
	//public static Logger log =  LogManager.getLogger(ValidateMovingURL.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initializeDriver() throws IOException{
		driver = mainDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void ValidateURLContent() throws IOException{
		LandingPages landingPages = new LandingPages(driver);
		String getURL = landingPages.getMovingUrl().getText();
		Assert.assertEquals(getURL.toString() , "www.RahulShettyAcademy.com");
	}
	
	@AfterTest
	public void CloseDriver(){
		driver.close();
		log.info("Driver is Closed");
	}
}

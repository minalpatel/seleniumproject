package FinalProject.End2EndProject;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPages;

public class ValidateTitle extends BaseClass {
	public WebDriver driver;
	//public static Logger log =  LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initializeDriver() throws IOException{
		driver = mainDriver();
		logDriverStatus("Open", ValidateTitle.class.getName());
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void TitleValidation() throws IOException{
		LandingPages landingPages = new LandingPages(driver);
		String title = landingPages.getTitle().getText();
		Assert.assertEquals(title, "FEATURED COURSES11");
		//Assert.assertTrue(landingPages.getnavBar().isDisplayed());
	}
	
	@AfterTest
	public void CloseDriver(){
		driver.close();
		logDriverStatus("Close", Object.class);
	}
	
}

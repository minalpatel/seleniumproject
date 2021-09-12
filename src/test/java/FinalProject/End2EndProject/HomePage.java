package FinalProject.End2EndProject;

import java.io.IOException;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPages;
import pageObjects.LoginPage;

public class HomePage extends BaseClass{
	
	//public static Logger log =  LogManager.getLogger(HomePage.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initializeDriver() throws IOException{
		driver = mainDriver();		
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void basepageNavigation(String username, String password, String text) throws IOException, InterruptedException{
		driver.get(prop.getProperty("url"));
		LandingPages landingPages = new LandingPages(driver);
		Actions A = new Actions(driver);
	//	landingPages.getLogin().click();	
		A.moveToElement(landingPages.getLogin()).click().build().perform();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailID().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		//System.out.println(text);
		log.info(text);
		loginPage.getLoginClick().click();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "1234560";
		data[0][2] = "Non Restricted user";
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "1234560";
		data[1][2] = "Restricted user";
		
		return data;
	}
	
	@AfterTest
	public void CloseDriver(){
		driver.close();
		log.info("Driver is Closed");
	}
}

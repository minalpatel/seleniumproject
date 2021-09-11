package FinalProject.End2EndProject;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPages;
import pageObjects.LoginPage;

public class HomePage extends BaseClass{
	
	@Test(dataProvider="getData")
	public void basepageNavigation(String username, String password, String text) throws IOException{
		driver = mainDriver();
		driver.get("https://qaclickacademy.com");
		LandingPages landingPages = new LandingPages(driver);
		landingPages.getLogin().click();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmailID().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		System.out.println(text);
		loginPage.getLoginClick().click();
		//driver.close();
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "1234560";
		data[0][2] = "Non Restriced user";
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "1234560";
		data[1][2] = "Restriced user";
		
		return data;
	}
}

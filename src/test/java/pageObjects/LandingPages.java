package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPages {

	public WebDriver driver;
	
	By sign_in = By.cssSelector("a[href*='sign_in']");
	
	public LandingPages(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getLogin(){
		return driver.findElement(sign_in);
	}
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPages {

	public WebDriver driver;
	
	private By sign_in = By.cssSelector("a[href*='sign_in']");
	private By title = By.cssSelector(".text-center > h2");
	private By nav_bar = By.cssSelector(".nav.navbar-nav>li>a");
	private By moving_URL = By.cssSelector(".newz>strong");
	
	public LandingPages(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public LoginPage getLogin(){
		 driver.findElement(sign_in).click();;
		 LoginPage loginPage = new LoginPage(driver);
		 return loginPage;
	}
	
	public WebElement getTitle(){
		return driver.findElement(title);
	}
	
	public WebElement getnavBar(){
		return driver.findElement(nav_bar);
	}
	
	public WebElement getMovingUrl(){
		return driver.findElement(moving_URL);
	}
}

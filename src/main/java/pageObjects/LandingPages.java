package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPages {

	public WebDriver driver;
	
	By sign_in = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center > h2");
	By nav_bar = By.cssSelector(".nav.navbar-nav>li>a");
	By moving_URL = By.cssSelector(".newz>strong");
	
	public LandingPages(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getLogin(){
		return driver.findElement(sign_in);
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

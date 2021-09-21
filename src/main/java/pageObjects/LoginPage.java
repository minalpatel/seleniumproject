package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By email_id = By.name("email");
	private By login_password = By.name(" password");
	private By login_click = By.name("commit");
	private By forgot_password = By.cssSelector("a[href*='password/new']");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getEmailID(){
		return driver.findElement(email_id);
	}
	
	public WebElement getPassword(){
		return driver.findElement(login_password);
	}
	
	public WebElement getLoginClick(){
		return driver.findElement(login_click);
	}
	
	public ForgotPassword forgotPassword(){
		driver.findElement(forgot_password).click();
		return new ForgotPassword(driver);		
	}
	
	
}

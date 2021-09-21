package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	WebDriver driver;
	private By email_id = By.name("email");
	private By send_instructions = By.name("commit");

	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getEmailID(){
		return driver.findElement(email_id);
	}
	
	public WebElement sendInstructions(){
		return driver.findElement(send_instructions);
	}

}

package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email_id = By.name("email");
	By login_password = By.name(" password");
	By login_click = By.name("commit");
	
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
	
	
}

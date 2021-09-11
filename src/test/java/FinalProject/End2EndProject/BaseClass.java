package FinalProject.End2EndProject;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	
	public WebDriver driver;
	
	public WebDriver mainDriver() throws IOException{
		Properties prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\minal\\workspace\\End2EndProject\\src\\test\\java\\FinalProject\\End2EndProject\\data.properties");
		prop.load(fileInputStream);
		String browserName = prop.getProperty("browser");
		
		//for Chrome browser web driver
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\minal\\Downloads\\chromedriver_win32\\chromedriver.exe");
			this.driver = new ChromeDriver();
		}
		
		//for Firefox browser web driver
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\minal\\Videos\\Selenium\\Firefox Gecko Driver\\geckodriver.exe");
			this.driver = new FirefoxDriver();
		}
		
		// for Internet Explorer web driver
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\minal\\Videos\\Selenium\\Internet Explorer Web Driver\\ServerIEDriverServer.exe");
			this.driver=new InternetExplorerDriver();
			
		}		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

}

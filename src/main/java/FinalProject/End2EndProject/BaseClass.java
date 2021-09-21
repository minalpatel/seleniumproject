package FinalProject.End2EndProject;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public static Logger log =  LogManager.getLogger(BaseClass.class.getName());
	public WebDriver mainDriver() throws IOException{
		prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\minal\\workspace\\End2EndProject\\src\\main\\java\\FinalProject\\End2EndProject\\data.properties");
		prop.load(fileInputStream);
		
		//using maven to send browser value
		String getBrowserName = System.getProperty("browser");
		
		String browserName = prop.getProperty("browser");
		
		//for Chrome browser web driver
		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\minal\\Downloads\\chromedriver_win32\\chromedriver.exe");
			this.driver = new ChromeDriver();
			System.out.println("Chrome Browser");
		}
		
		//for Firefox browser web driver
		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\minal\\Videos\\Selenium\\Firefox Gecko Driver\\geckodriver.exe");
			this.driver = new FirefoxDriver();
			System.out.println("Firefox Browser");
		}
		
		// for Internet Explorer web driver
		else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.ie.driver", "C:\\Users\\minal\\Videos\\Selenium\\Internet Explorer Web Driver\\ServerIEDriverServer.exe");
			this.driver=new InternetExplorerDriver();
			System.out.println("Internet Explorer Browser");			
		}		
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		return driver;
	}
	
	public void logDriverStatus(String Value, Object className){
		
		if(Value.equalsIgnoreCase("open")){
			log.info("Driver is Initialized of " + className.toString() + " Class " );
		}
		
		else if(Value.equalsIgnoreCase("close")){
			log.info("Driver is Closed of " + className.toString() + " Class ");
		}		
	}
	
	public String TakeScreenshots(String TestCaseName, WebDriver driver	) throws IOException{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\reports\\" + TestCaseName+".png";
		// Dependency Apache Common IO from maven in POM.xml
		FileUtils.copyFile(source, new File(destinationPath));
		return destinationPath;
		
	}

}

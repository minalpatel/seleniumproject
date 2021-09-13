package FinalProject.End2EndProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseClass implements ITestListener {
	
	public WebDriver driver;
	ExtentReports extent = ExtentReportNG.getReportObject();
	ExtentTest extentTest = null;
	
	//It stores all test Objects so that they can run parallely together
	ThreadLocal<ExtentTest> threadLocal_ExtentTest = new ThreadLocal<ExtentTest>();
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		// get the extent returned and create a test named initial demo		
		//extentTest = extent.createTest("Initial Demo");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		// Get Method Name which failed
		threadLocal_ExtentTest.get().fail(result.getThrowable());
		String TestCaseName = result.getMethod().getMethodName();
		
		try {
			// Get Current Web Driver Used
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			// Method in base class 
			String destinationPath = TakeScreenshots(TestCaseName, driver );
			threadLocal_ExtentTest.get().addScreenCaptureFromPath(destinationPath, TestCaseName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest = extent.createTest(result.getMethod().getMethodName());
		threadLocal_ExtentTest.set(extentTest);
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		threadLocal_ExtentTest.get().log(Status.PASS, "Test Passed");
	}

}

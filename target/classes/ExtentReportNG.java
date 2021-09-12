package FinalProject.End2EndProject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	// Get Extent report Dependency From Maven
	static ExtentReports extentReports;
	
	public static ExtentReports getReportObject(){
		
		String path  = System.getProperty("user.dir") + "\\reports\\index.html";
		
		ExtentSparkReporter extentSparkReporter =  new ExtentSparkReporter(path);
		extentSparkReporter.config().setReportName("Web Automation results");
		extentSparkReporter.config().setDocumentTitle("Test Results");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Tester", "Minal Patel");
		return extentReports;
	}

}

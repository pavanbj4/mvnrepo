package uitilites;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {

	public WebDriver driver;
	static ExtentReports extent;
 
public static ExtentReports report() {
	
	
	
	
	
   String reportpath = System.getProperty("user.dir")+"\\reports\\index.html";

  ExtentSparkReporter reporter = new ExtentSparkReporter(reportpath);


  reporter.config().setReportName("practicereport");

  reporter.config().setDocumentTitle("report of test");

   extent = new ExtentReports();
	
	extent.attachReporter(reporter);


extent.setSystemInfo("operating system", "windows11");

extent.setSystemInfo("tested by", "pavan");


return extent;

}

}






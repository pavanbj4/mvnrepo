package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import uitilites.Extentreport;

public class Listener extends Base implements ITestListener {
	WebDriver driver = null;
	
	ExtentReports extentreport = Extentreport.report();
	
	ExtentTest extenttest;
	private static ThreadLocal<ExtentTest> extenttestthread = new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {

		String testname = result.getName();
	 extenttest = extentreport.createTest(testname);
	
	 
	extenttestthread.set(extenttest);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testname = result.getName();
	
		//extenttest.log(Status.PASS,testname+"got passed" );
	
		extenttestthread.get().log(Status.PASS,testname+"got passed" );
		
	
	}

	@Override
	public void onTestFailure(ITestResult result) {

		
        //extenttest.fail(result.getThrowable());
		
		extenttestthread.get().fail(result.getThrowable());
        
        String testname = result.getName();

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

			e.printStackTrace();
		}

		try {
			String screenshotfilepath = takescreenshot(testname, driver);
			extenttestthread.get().addScreenCaptureFromPath(screenshotfilepath,testname);
		
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

		extentreport.flush();
	
	}

}

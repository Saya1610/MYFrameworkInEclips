package vitiger.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provide Implementation to all abstract methods in ITestListner
 * @author Shine
 *
 */
public class ListenerImplementationLibrary implements ITestListener {
	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//System.out.println("Test is start->"+MethodName);
		test=report.createTest(MethodName);
		test.log(Status.INFO, "Test Execution is started");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//System.out.println("Test is successed->"+MethodName);
		test.log(Status.PASS, MethodName+"->PASS");
	}

	public void onTestFailure(ITestResult result) {
		WebDriverLibrary wLib=new WebDriverLibrary();
		JavaLibrary jLib=new JavaLibrary();
		
		String MethodName = result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		//System.out.println("Test is failed->"+MethodName);
		test.log(Status.FAIL, MethodName+"->FAIL");
		test.log(Status.FAIL, result.getThrowable());
		try {
			String path = wLib.takeScreenShot(BaseClass.sDriver, MethodName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		//System.out.println("Test is skipped->"+MethodName);
		test.log(Status.SKIP, MethodName+"->SKIPPED");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("Execution of suite started",true);
		//this configure the report here-Report-11-11-2022-10-57-html
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaLibrary().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("ExecutionReports for vTiger");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("vTigerExecutionReport");
		
		//attach the report to extent report
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base BROWSER", "chromr");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Base URL", "http://localhost:8888");
		report.setSystemInfo("BasePlatform", "Windows");
		report.setSystemInfo("ReporterName", "sayali");
		
	}

	public void onFinish(ITestContext context) {
		Reporter.log("Execution of suite finished",true);
		//flush the report bcz here execution is finished
		report.flush();	
}
}
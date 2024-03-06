package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	    String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript excecution is started", true);
	    test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	      String methodName = result.getMethod().getMethodName();
	      test.log(Status.PASS,"Testscript execution is Passed");


	//Reporter.log(methodName+"Testscript execution is Passed", true);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
        String message  = result.getThrowable().toString();
 		String methodName = result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is Failed", true);
	    test.log(Status.FAIL,"Testscript execution is Failed");


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	    String methodName = result.getMethod().getMethodName();
   		Reporter.log(methodName+"Testscript execution is skipped", true);
	    test.log(Status.SKIP,"Testscript execution is skipped");

		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("TestScript is start",true);
		JavaUtil jUtil = new JavaUtil();
	    ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report.html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("Shivani");
		
		ExtentReports report = new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("chromeversion", "121");
		report.setSystemInfo("Author", "Shivani");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("TestScript is finish",true);
		report.flush();

	}
	
	
}

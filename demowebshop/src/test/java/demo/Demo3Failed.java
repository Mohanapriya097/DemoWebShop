package demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demowebshop.baseclass.BaseClass;

//@Listeners(demowebshop.listnersimplementation.ListnerClass.class) // we can give listners at suite level if the test scripts is more
public class Demo3Failed //extends BaseClass
{
	@Test //(retryAnalyzer = demowebshop.listnersimplementation.RetryListner.class)
	public void demo()
	{
		//Assert.fail();
		//Reporter.log(driver.getTitle(),true);
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvancedReports/Demoreport.html");
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test = report.createTest("TestName");
		test.log(Status.INFO, "Demo Reports");
		test.log(Status.INFO, "Demo Reports");
		test.log(Status.INFO, "Demo Reports");
		test.log(Status.INFO, "Demo Reports");
		test.log(Status.INFO, "Demo Reports");
		test.log(Status.INFO, "Info Reports");
		test.log(Status.PASS, "Pass Reports");
		test.log(Status.FAIL, "Fail Reports");
		report.flush();
		
	}
}

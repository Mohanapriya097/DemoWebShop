package demowebshop.listnersimplementation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import demowebshop.baseclass.BaseClass;
import demowebshop.fileutility.JavaUtility;

public class ListnerClass implements ITestListener,ISuiteListener {  //extends baseclass to take failed screenshots
	
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite)
	{	
		JavaUtility java = new JavaUtility();
		spark = new ExtentSparkReporter("./AdvancedReports/"+suite.getName()+java.getSystemDate()+".html");
		report = new ExtentReports();
		report.attachReporter(spark);
		Reporter.log(suite.getName()+" has started execution",true);
	}
	 @Override
	public void onTestStart(ITestResult result) 
	{
		test = report.createTest(result.getName());
		Reporter.log(result.getName()+" test script execution started",true);
		test.log(Status.INFO,result.getName()+" test script execution started");
	}
	 @Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log(result.getName()+" test script successfully executed",true);
	}
	 @Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log(result.getName()+" test script skipped",true);
		test.log(Status.SKIP,result.getName()+"test script skipped");	
	}
	@Override
	public void onFinish(ISuite suite) 
	{	
		report.flush();
		Reporter.log(suite.getName()+" has execution completed",true);
	}
	@Override
	public void onTestFailure(ITestResult result)
	{	
		
		Reporter.log(result.getName()+" test script failed and captured the screenshot",true);
		JavaUtility java = new JavaUtility();
		String screenshotPath = "./FailedScreenshots/"+result.getName()+java.getSystemDate()+".png"; //To get the failed screenshots in the reports
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File img = ts.getScreenshotAs(OutputType.FILE);
		//File path = new File("./FailedScreenshots/"+result.getName()+java.getSystemDate()+".png");
		File path = new File(screenshotPath);
		
		try 
		{
			FileHandler.copy(img, path); // Copy
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath("."+screenshotPath); // To screenshot the image from the folder to show in the advanced reports
		test.log(Status.FAIL, result.getName()+" test script failed and captured the screenshot");
				
	}
	
}

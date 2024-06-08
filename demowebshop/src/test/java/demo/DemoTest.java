package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

import demowebshop.baseclass.BaseClass;

public class DemoTest extends BaseClass{
	@Test
	public void demoTest()
	{
		//System.out.println("Hello");
		String browser = System.getProperty("browser");
		System.out.println(browser);
		Reporter.log(driver.getTitle(),true);
	}

}

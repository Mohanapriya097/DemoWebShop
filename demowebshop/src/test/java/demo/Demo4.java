package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

import demowebshop.baseclass.BaseClass;

public class Demo4 extends BaseClass{
	@Test
	public void demo()
	{
		Reporter.log("Demo4 executed");
	}

}

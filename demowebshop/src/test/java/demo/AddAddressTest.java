package demo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import demowebshop.baseclass.BaseClass;
@Listeners(demowebshop.listnersimplementation.ListnerClass.class)

public class AddAddressTest extends BaseClass{
	@Test
	public void addAddressTest() 
	{
		//Click on my profile
		test.log(Status.INFO, "Clicked on My Profile");
		
		//Click on Addresses
		test.log(Status.INFO, "Clicked on Addresses");
		
		
		//Click on Add new Address
		
		//Assert.fail();
		test.log(Status.INFO, "Clicked on Add New Address");
		
		//Entering all the Details
		test.log(Status.INFO, "Entered all the Details");		
	}

}

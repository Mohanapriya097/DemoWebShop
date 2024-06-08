package demo;

import java.awt.Desktop.Action;
import java.time.Duration;

import org.openqa.selenium.By;

import demowebshop.fileutility.ReadAddressProperties;

	public class Demo2 extends demowebshop.baseclass.BaseClass
	{
		ReadAddressProperties add=new ReadAddressProperties();
		
		@org.testng.annotations.Test
		public void search()
		{
			org.openqa.selenium.WebElement scrl = driver.findElement(By.xpath("//h3[text()='Information']"));
			org.openqa.selenium.interactions.Actions act=new org.openqa.selenium.interactions.Actions(driver);
			act.scrollToElement(scrl).perform();
			
			driver.findElement(By.xpath("//a[text()='Addresses']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(150));
			driver.findElement(By.xpath("//input[@value='Add new']")).click();
			
			String firstname = add.fetchProperties("firstname");
			driver.findElement(By.id("Address_FirstName")).sendKeys(firstname);
			
			String lastname = add.fetchProperties("lastname");
			driver.findElement(By.id("Address_LastName")).sendKeys(lastname);
			
			String email = add.fetchProperties("email");
			driver.findElement(By.id("Address_Email")).sendKeys(email);
			
			String company = add.fetchProperties("company");
			driver.findElement(By.id("Address_Company")).sendKeys(company);
			
			org.openqa.selenium.WebElement ID = driver.findElement(By.id("Address_CountryId"));
			org.openqa.selenium.support.ui.Select sel=new org.openqa.selenium.support.ui.Select(ID);
			sel.selectByVisibleText("India");
			String city = add.fetchProperties("city");
			driver.findElement(By.id("Address_City")).sendKeys(city);
			
			String address1 = add.fetchProperties("address1");
			driver.findElement(By.id("Address_Address1")).sendKeys(address1);
			
			String address2 = add.fetchProperties("address2");
			driver.findElement(By.id("Address_Address2")).sendKeys(address2);
			
			String postalcode = add.fetchProperties("postalcode");
			driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(postalcode);
			
			String phonenum = add.fetchProperties("Phone");
			driver.findElement(By.id("Address_PhoneNumber")).sendKeys(phonenum);
			
			driver.findElement(By.xpath("//input[@Value='Save']")).click();
			driver.quit();
		}

}


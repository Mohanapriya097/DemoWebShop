package demo;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demowebshop.baseclass.BaseClass;
import demowebshop.fileutility.ReadProperties;

public class Asserts extends BaseClass
{
	@Test
	public void demo() throws InterruptedException
	{
		System.out.println("Hello");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		ReadProperties read = new ReadProperties();
		String url = read.fetchProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle().contains("Login"), true);
	    Reporter.log("Login Displayed",true);
	    String username = read.fetchProperty("username");
		String password = read.fetchProperty("password");
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		
	}
}
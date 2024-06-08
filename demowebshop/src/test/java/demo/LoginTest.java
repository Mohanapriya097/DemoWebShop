package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demowebshop.fileutility.ReadProperties;

public class LoginTest{

	@DataProvider
	public Object[][] dataSupplier() {
		ReadExcel readExcel = new ReadExcel();
		Object[][] data = readExcel.getmultipledata("Sheet2");
		return data;
	}

	@Test(dataProvider = "dataSupplier")
	public void loginTest(String username, String password) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		ReadProperties read = new ReadProperties();
		String url = read.fetchProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.quit();
	}
}

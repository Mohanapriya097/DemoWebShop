package demowebshop.baseclass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import demowebshop.fileutility.ReadProperties;
import demowebshop.genericutility.WebDriverutility;
import demowebshop.listnersimplementation.ListnerClass;
import demowebshop.objectrepositry.LoginPage;
import demowebshop.objectrepositry.RegisterPage;
import demowebshop.objectrepositry.WelcomePage;

public class BaseClass extends ListnerClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	ReadProperties read= new ReadProperties();
	
	WebDriverutility webDriverUtility = new WebDriverutility();
	//WebElement element;
	
	@BeforeClass
	public void openBrowser()
	{
		String browser = System.getProperty("browser");// to give the parameters using command prompt
		System.out.println(browser);
		if(browser.contains("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.contains("Edge"))
		{
			driver = new EdgeDriver();
		}
		//driver = new ChromeDriver();
		sdriver=driver;
		driver.manage().window().maximize();
		String url = read.fetchProperty("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
    @BeforeMethod
    public void login()
    { 	
    	driver.findElement(By.linkText("Log in")).click();
//    	WelcomePage welcomePage = new WelcomePage(driver);
//    	LoginPage loginPage = new LoginPage(driver);
//    	WebDriverutility webdriverUtility = new WebDriverutility();
//    	webdriverUtility.clickOnWebElement(loginPage.getLoginButton());
    	String username = read.fetchProperty("username");
    	String password = read.fetchProperty("password");
//    	webdriverUtility.sendText(loginPage.getEmailTextField(), username);
//    	webdriverUtility.sendText(loginPage.getPasswordTextField(), password);
//    	webdriverUtility.clickOnWebElement(loginPage.getLoginButton());
   		

     
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
    }
//    public void register()
//    {
//    	WelcomePage welcomePage = new WelcomePage(driver);
//    	welcomePage.getRegisterButton().click();
//    	String gender = read.fetchProperty("gender");
//    	String firstName = read.fetchProperty("firstname");
//    	String lastName = read.fetchProperty("lastname");
//    	String email = read.fetchProperty("email");
//    	String password = read.fetchProperty("password");
//    	String confirmPassword = read.fetchProperty("confirmpassword");
//    	RegisterPage regPage = new RegisterPage(driver);
//    	regPage.getGender().click();
//    	regPage.getFirstnameTextField().sendKeys(firstName);
//    	regPage.getLastnameTextField().sendKeys(lastName);
//    	regPage.getEmailTextField().sendKeys(email);
//    	regPage.getPasswordTextField().sendKeys(password);
//    	regPage.getConfirmPasswordTextField().sendKeys(confirmPassword);
//    	regPage.getRegisterButton().click();
//    	
//    }  
    @AfterMethod
    public void logout()
	{
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
    	//driver.quit();
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}


package demowebshop.objectrepositry;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import demowebshop.baseclass.BaseClass;

public class WelcomePage extends BasePage{

	public WelcomePage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
//	@FindAll({@FindBy(linkText = "Log in"), @FindBy(xpath ="//a[@class='ico-login'])")})
//	private WebElement loginButton;
//	
//	
//	public WebElement getLoginButton() {
//		return loginButton;
//	}	
	
	@FindAll({@FindBy(linkText = "Register"),@FindBy(xpath = "//a[@href='/register']")})
	private WebElement registerButton;

	public WebElement getRegisterButton() {
		return registerButton;
	}
}
	
	




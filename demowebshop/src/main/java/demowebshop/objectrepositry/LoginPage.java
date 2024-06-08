package demowebshop.objectrepositry;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindAll({@FindBy(id="Email"),@FindBy(xpath = "//input[@autofocus='autofocus']")})
	private WebElement emailTextField;
	
	@FindAll({@FindBy(id="Password"),@FindBy(xpath = "//input[@type='password']")})
	private WebElement passwordTextField;
	
	@FindAll({@FindBy(xpath = "//input[@class='button-1 login-button']"),@FindBy(xpath="//input[@value='Log in']")})
	private WebElement loginButton;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	

}

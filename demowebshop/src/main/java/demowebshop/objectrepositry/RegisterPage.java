package demowebshop.objectrepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage
{

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindAll({@FindBy(id="gender-female"),@FindBy(xpath ="//input[@value='F'")})
	private WebElement Gender;
	
	@FindBy(id="FirstName")
	private WebElement firstnameTextField;
	
	@FindBy(id="LastName")
	private WebElement lastnameTextField;
	
	@FindBy(id="Email")
	private WebElement emailTextField;
	
	@FindBy(id="Password")
	private WebElement passwordTextField;
	
	@FindBy(id="ConfirmPassword")
	private WebElement ConfirmPasswordTextField;
	
	@FindAll({@FindBy(id="register-button"),@FindBy(xpath ="//input[@value='Register']")})
	private WebElement registerButton;

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getFirstnameTextField() {
		return firstnameTextField;
	}

	public WebElement getLastnameTextField() {
		return lastnameTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return ConfirmPasswordTextField;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	
}

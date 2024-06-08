package demowebshop.genericutility;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import demowebshop.baseclass.BaseClass;

public class WebDriverutility
{
	
	public String getTitle(WebDriver driver)
	{	 
		return driver.getTitle();
	}
	public String getUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	
	public void clickOnWebElement(WebElement element)
	{
		element.click();
	}
	public void sendText(WebElement element,String text)
	{
		element.sendKeys(text);
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert (WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void dropDownHanlingByIndex(WebElement element, int a)
	{
		Select sel = new Select(element);
		sel.selectByIndex(a);
	}
	public void dropDownHanlingByValue(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByValue(text);
	}
	public void dropDownHanlingByVisibleText (WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public void deselectAll(WebElement element)
	{
		Select sel = new Select(element);
		sel.deselectAll();
	}
	public void scrollToElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.scrollToElement(element);
	}
	
	public void frameHandling(WebDriver driver, int a)
	{
		driver.switchTo().frame(a);
	}
	public void ScreenshotP(WebDriver driver, String screenshotName) // To take a screenshot of a webpage
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File path = new File("./Screenshots/"+screenshotName+".png");
		File img = ts.getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(img,path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public void ScreenshotE(WebElement element,String screenshotName)
	{
		File path = new File("./Screenshots/"+screenshotName+".png");
		File img = element.getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(img,path);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}

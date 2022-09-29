package ecomm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By username = By.id("email");
	private By password = By.cssSelector("input[id='passwd']");
	private By LoginButton = By.xpath("//button[@id='SubmitLogin']");
	
	public WebElement EmailAddress()
	{
		return driver.findElement(username);
	}
	
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement Login()
	{
		return driver.findElement(LoginButton);
	}
	
	public void userLogin(String userName, String Password)
	{
		EmailAddress().sendKeys(userName);
		password().sendKeys(Password);
		Login().click();
	}

}

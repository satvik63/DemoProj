package POMPF.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import POMPF.Utils.Constants;

public class LoginPage {
	WebDriver driver;
	ExtentTest eTest;
	
	@FindBy(id="login_id")
	public WebElement emailField;
	
	@FindBy(id="pwd")
	public WebElement passwordField;
	
	@FindBy(id="signin_submit")
	public WebElement signInButton;
	
	//Constructor
	public LoginPage(WebDriver driver, ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
		
	}
	
	public void navigatetoHome()
	{
		emailField.sendKeys(Constants.USERNAME);
		passwordField.sendKeys(Constants.PASSWORD);
		
		signInButton.click();
	}
	
	
	

}

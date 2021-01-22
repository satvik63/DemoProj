package POMPF.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import POMPF.Utils.Constants;

public class LaunchPage {
	
	WebDriver driver;
	ExtentTest eTest;
	
	//WebElements in Launch Page
	@FindBy(className="zh-login")
	public WebElement loginOption;
	
	//Constructor
	public LaunchPage(WebDriver driver,ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
		
	}
	
	//Reusable methods in Launch Page
	public void navigatetoLogin()
	{
		driver.get(Constants.APP_URL);
		
		loginOption.click();
		
	}

	
	
	

}

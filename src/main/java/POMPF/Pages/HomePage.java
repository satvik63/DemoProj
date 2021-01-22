package POMPF.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	
	WebDriver driver;
	ExtentTest eTest;

	@FindBy(css="[class^='zicon-apps-chat']")
	public WebElement cliqOption;
	
	@FindBy(css="[class^='zicon-apps-crm']")
	public WebElement crmOption;
	
	@FindBy(css="[class^='zicon-apps-salesiq']")
	public WebElement salesIQOption;
	
	//Constructor
	public HomePage(WebDriver driver, ExtentTest eTest)
	{
		this.driver=driver;
		this.eTest=eTest;
	}

	
	//Reusable method to verify the presence of CRM option
	public boolean crmOption()
	{
		if(crmOption.isDisplayed())
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	//Reusable method for navigating to CRM option
	
	//Reusable method for navigating to SalesIQ option
	
	//Reusable method for navigating to Cliq option
	
}

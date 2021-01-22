package POMPF.Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import POMPF.Pages.HomePage;
import POMPF.Pages.LaunchPage;
import POMPF.Pages.LoginPage;
import POMPF.Tests.Base.BaseTest;
import POMPF.Utils.Constants;

public class LoginTest extends BaseTest{
	
	@Test
	public void TestLogin()
	{
		eReport.startTest("LoginTest");
		eTest.log(LogStatus.INFO, "Login Test has started");
		
		OpenBrowser(Constants.BROWSER_TYPE);
		
		LaunchPage lp=new LaunchPage(driver,eTest);
		PageFactory.initElements(driver, lp);
		lp.navigatetoLogin();
		
		LoginPage lop=new LoginPage(driver, eTest);
		PageFactory.initElements(driver, lop);
		lop.navigatetoHome();
		
		HomePage hp=new HomePage(driver, eTest);
		PageFactory.initElements(driver, hp);
		boolean displayStatus=hp.crmOption();
		
		if(displayStatus)
		{
			passMethod("LoginTest Test Case is passed");
		}
		else
		{
			failMethod("LoginTest Test Case is failed");
	
		}

	}
	
	

}

package POMPF.Tests.Base;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import POMPF.Utils.Constants;
import POMPF.Utils.ExtentManager;
import junit.framework.Assert;

public class BaseTest {
	
	public ExtentReports eReport=null;
	public ExtentTest eTest=null;
	public WebDriver driver=null;
	
	public void OpenBrowser(String browserType)
	{
		eReport=ExtentManager.getInstance();
		if(browserType.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", Constants.FF_PATH);
			driver=new FirefoxDriver();
		}else if(browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_PATH);
			driver=new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", Constants.IE_PATH);
			driver=new InternetExplorerDriver();
		}
		eTest.log(LogStatus.INFO, "Successfully Opened the "+browserType);
		
		driver.manage().window().maximize();
		eTest.log(LogStatus.INFO, browserType+" is Maximized");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public void passMethod(String msg)
	{	
		eTest.log(LogStatus.PASS, msg);
	}

	public void failMethod(String msg)
	{
		eTest.log(LogStatus.FAIL, msg);
		takeScreenshot();
		
		Assert.fail("msg");
	}
	
	public void takeScreenshot()
	{
		Date d=new Date();
		String file=d.toString().replace(" ", "_").replace(":", "_")+".png";
		String path="screenshot//"+file;
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try
		{
		FileUtils.copyFile(src, new File(path));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		eTest.log(LogStatus.INFO, "Screenshot---> "+
		eTest.addScreenCapture(System.getProperty("userdir")+path));		
	}
		
	}
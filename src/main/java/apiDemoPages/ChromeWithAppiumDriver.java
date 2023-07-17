package apiDemoPages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;

import baseLibrary.BaseLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utility.Utility;

public class ChromeWithAppiumDriver extends BaseLibrary
{
	
	static AppiumDriver<MobileElement> driver;
	@BeforeClass
	public void launchAppp() throws MalformedURLException
	{
		BaseLibrary ob= new BaseLibrary();
		ob.launchDriverApp("com.android.chrome", "com.google.android.apps.chrome.Main");
		this.driver = super.getDriver();
	}
	public void acceptT_C()
	{
		try
		{
			Thread.sleep(2000);
			driver.findElement(By.id("com.android.chrome:id/terms_accept")).click();
			Thread.sleep(2000);
			
		}
		catch (Exception e)
		{
			Utility.PrintText("issue in accept and continue");
			e.printStackTrace();
		}
		try
		{
			driver.findElement(By.id("com.android.chrome:id/negative_button")).click();
			Thread.sleep(2000);
			
		}
		catch (Exception e)
		{
			Utility.PrintText("issue in skip account");
			e.printStackTrace();
		}
	}
	public void launchFacebook()
	{
		driver.get("https://m.facebook.com");
	}
	
}

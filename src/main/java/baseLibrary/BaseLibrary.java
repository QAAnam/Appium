package baseLibrary;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import utility.Utility;

public class BaseLibrary 
{
	private BaseLibrary ob ;
	private static AppiumDriver<MobileElement> driver;
	public DesiredCapabilities desirecaps()
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/ApiDemos-debug.apk");
//		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
//		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		dc.setCapability(MobileCapabilityType.FULL_RESET, false);
//		dc.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, true);
//		dc.setCapability("skipServerInstallation", "true");
		return dc;
	}
	public AppiumDriver<MobileElement> launchAppDriver() throws InterruptedException
	{
		ob = new BaseLibrary();
		driver=ob.initializeDriver();
		try 
		{
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		} 
		catch (Exception e) 
		{
			Utility.PrintText("error while click on continue");
		}
		try 
		{

			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
			driver.findElement(By.id("android:id/button1")).click();
		} 
		catch (Exception e) 
		{
			Utility.PrintText("error while click on ok for update");
		}
		
		return driver;
		
		
		
	}
	public AppiumDriver<MobileElement> initializeDriver() throws InterruptedException
	{
		ob = new BaseLibrary();
		try
		{
			
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),ob.desirecaps());
			boolean IsAppInstalled = driver.isAppInstalled("io.appium.android.apis");
			if(IsAppInstalled)
			{
				((StartsActivity) driver).startActivity(new Activity("io.appium.android.apis","io.appium.android.apis.ApiDemos"));
				Thread.sleep(5000);
			}
			else if(!IsAppInstalled)
			{
				driver.installApp(System.getProperty("user.dir")+"/Appium/ApiDemos-debug.apk");
				((StartsActivity) driver).startActivity(new Activity("io.appium.android.apis","io.appium.android.apis.ApiDemos"));
			}
			
		} 
		catch (MalformedURLException e)
		{
			System.out.println("**************************************************************************");
			System.out.println("**********Issue in driver=new andriodDriver(Url,dc)***********************");
			System.out.println("**************************************************************************");
			e.printStackTrace();
		}
		
		return driver;
	}
	public AppiumDriver<MobileElement> getDriver()
	{
		return driver;
		
	}
	

}

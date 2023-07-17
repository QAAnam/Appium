package baseLibrary;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
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
	private static WebDriver webdriver;

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
	public DesiredCapabilities getchromeoption()
	{
		Utility.PrintText("BaseClass method called");
		DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.VERSION, "11");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
		cap.setCapability(MobileCapabilityType.NO_RESET, true);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		cap.setCapability("autoGrantPermissions", "true");
		cap.setCapability("autoAcceptAlerts", "true");
		cap.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
		Utility.PrintText("last line of base class excuted");
		return cap;
		
	}
	public WebDriver initializeChromeDriver() throws InterruptedException
	{
		ob = new BaseLibrary();
		try
		{
			
			webdriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub/"),ob.getchromeoption());
		}
		catch (MalformedURLException e)
		{
			System.out.println("**************************************************************************");
			System.out.println("**********Issue in driver=new andriodDriver(Url,dc)***********************");
			System.out.println("**************************************************************************");
			e.printStackTrace();
		}
		
		return webdriver;
	}
	public WebDriver getChromeDriver()
	{
		return webdriver;
		
	}
	public DesiredCapabilities desirecapsDynamic(String AppPackage, String AppActivity)
	{
		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/ApiDemos-debug.apk");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, AppActivity);
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, AppPackage);
		dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
//		dc.setCapability(MobileCapabilityType.NO_RESET, true);
//		dc.setCapability(MobileCapabilityType.FULL_RESET, false);
//		dc.setCapability(AndroidMobileCapabilityType.SKIP_DEVICE_INITIALIZATION, true);
//		dc.setCapability("skipServerInstallation", "true");
		return dc;
	}
	public AppiumDriver<MobileElement> intializedriver(String AppPackage, String AppActivity) throws MalformedURLException
	{
		ob=new BaseLibrary();
		DesiredCapabilities DC=ob.desirecapsDynamic(AppPackage, AppActivity);		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"),DC);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		return driver;
	}
	
	public AppiumDriver<MobileElement> launchDriverApp(String AppPackage, String AppActivity) throws MalformedURLException
	{
		ob= new BaseLibrary();
		return driver=ob.intializedriver(AppPackage, AppActivity);
	}

}

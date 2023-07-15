package apiDemoPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.Assertion;

import baseLibrary.BaseLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.appmanagement.ApplicationState;
import utility.Utility;

public class ApiDemoPage extends BaseLibrary
{
	
	protected static AppiumDriver<MobileElement> driver;
	
	
	@BeforeClass
	public void initializeAppDriver() throws InterruptedException
	{
		BaseLibrary ob = new BaseLibrary();
		ob.launchAppDriver();
		ApiDemoPage.driver = super.getDriver();
	}
	
	public void tapOnElementViews()
	{
		MobileElement Views = driver.findElementByAccessibilityId("Views");
		System.out.println(Views.getText());
		Utility.tapActionOnElement(driver, Views);
		Utility.PrintText("tapOnElementViews executed");
		
	}
	public void clickOnElementAnimation()
	{
		MobileElement Animation = driver.findElementByAccessibilityId("Animation");
		Utility.clickActionOnElementWebelement(driver, Animation);
		Utility.PrintText("clickOnElementAnimation executed");
	}
	
	public void pressOnElement3D_Transition()
	{
		List<MobileElement> Transition = driver.findElementsByClassName("android.widget.TextView");
		for (MobileElement mobileElement : Transition)
		{
			if(mobileElement.getText().equalsIgnoreCase("3D Transition"))
			{
				Utility.pressMobileElement(driver, mobileElement);;
				Utility.PrintText("pressOnElement3D_Transition");
				break;
			}
			else
			{
				System.out.println(mobileElement.getText());
			}
		}
	}
	public void ScrollAndClickOnElementPopUpMenu()
	{
		try 
		{
			driver.navigate().back();
			Thread.sleep(3000);
			Utility.ScrollAndMatcher(driver, "android.widget.TextView", "Popup Menu");
		} 
		catch (Exception e) 
		{
			Utility.PrintText("Popup Menu is not found");
			e.printStackTrace();
		}
		
	}
	public void scrollUpDownAndClick()
	{
		try 
		{
			driver.navigate().back();
			Thread.sleep(3000);
			Utility.ScrollAndMatcher(driver, "android.widget.TextView", "Buttons");
		} 
		catch (Exception e) 
		{
			Utility.PrintText("Auto Complete is not found");
			e.printStackTrace();
		}
	}
	public void clickonOnOffButton() throws InterruptedException
	{
		try 
		{
			MobileElement ele = driver.findElementByAccessibilityId("Toggle");
			if (ele.getText().equalsIgnoreCase("off")) 
			{
				ele.click();
				Utility.PrintText("system is "+ele.getText());
			}
			else
			{
				Utility.PrintText("system is already "+ele.getText());
			}
				
		} 
		catch (Exception e) 
		{
			Utility.PrintText("Error in clickonOnOffButton");
			e.printStackTrace();
		}
		Thread.sleep(3000);
	}
	public void longPresspeople() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		MobileElement expendable = driver.findElementByAccessibilityId("Expandable Lists");
		Utility.clickActionOnElementWebelement(driver, expendable);
		MobileElement customAdapter = driver.findElementByAccessibilityId("1. Custom Adapter");
		Utility.clickActionOnElementWebelement(driver, customAdapter);
		MobileElement names = Utility.SearchWebElementWithClassName(driver, "android.widget.TextView", "People Names");
		Utility.longPress(driver, names);
		Thread.sleep(2000);
		MobileElement sampleAction = Utility.SearchWebElementWithClassName(driver, "android.widget.TextView", "Sample action");
		Utility.waitTillVisible(driver, sampleAction);
		Utility.PrintText(sampleAction.getText());
		Assertion asrt = new Assertion();
		asrt.assertEquals(sampleAction.getText(), "Sample action");
	}
	public void runInBackground()
	{
		driver.runAppInBackground(Duration.ofSeconds(5));
	}
	public void terminateApp() throws InterruptedException
	{
		driver.terminateApp("io.appium.android.apis");
		Thread.sleep(3000);
	}
	public void activateApp() throws InterruptedException
	{
		driver.activateApp("com.android.gallery3d");
		Thread.sleep(3000);
	}
	public void qureyAppstate() throws InterruptedException
	{
		ApplicationState text = driver.queryAppState("com.android.gallery3d");
		Thread.sleep(3000);
	}
	public void removeapp() throws InterruptedException
	{
		driver.removeApp("com.android.gallery3d");
		Thread.sleep(3000);
	}
	public void activateApp1() throws InterruptedException
	{
		driver.activateApp("io.appium.android.apis");
		Thread.sleep(3000);
	}
	public void scrollUpDirectelyWithElement() throws InterruptedException
	{
		driver.findElementByAccessibilityId("Views").click();
		Thread.sleep(2000);
		Utility.scrollUpDirectelyWithElement(driver, "Radio Group");
		driver.findElementByAccessibilityId("Radio Group").click();
		Thread.sleep(2000);
		MobileElement check = driver.findElementByAccessibilityId("You have selected: (none)");
		if(check.getText().equalsIgnoreCase("You have selected: (none)"))
		{
			driver.findElementByAccessibilityId("All of them").click();
			Thread.sleep(2000);
			MobileElement check1 = driver.findElementByAccessibilityId("You have selected: (none)");
			Assertion assrt = new Assertion();
			assrt.assertEquals(check1.getText(), "You have selected: 2131296535");
			Utility.PrintText(check1.getText());
			
		}
		else
		{
			driver.findElement(By.id("io.appium.android.apis:id/clear")).click();
			System.out.println();
			MobileElement check2 = driver.findElementByAccessibilityId("You have selected: (none)");
			Utility.PrintText(check2.getText());
		}
		
		
	}


}

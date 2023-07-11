package apiDemoPages;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import baseLibrary.BaseLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utility.Utility;

public class ApiDemoPage extends BaseLibrary
{
	
	protected static AppiumDriver<MobileElement> driver;
	
	
	@BeforeClass
	public void initializeAppDriver()
	{
		BaseLibrary ob = new BaseLibrary();
		ob.launchAppDriver();
		this.driver = super.getDriver();
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
			}
			else
			{
				System.out.println(mobileElement.getText());
			}
		}
	}

}

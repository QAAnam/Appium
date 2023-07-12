package utility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Utility 
{
	public static void waitTillVisible(AppiumDriver<MobileElement> driver, MobileElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e)
		{
			PrintText("element is not visible");
		}
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e)
		{
			PrintText("element is not clickable");
		}
		
		
	}
	public static void PrintText(String text)
	{
		System.out.println("**************************************************************************");
		System.out.println("**********"+text+"***********************");
		System.out.println("**************************************************************************");
	}
	public static void tapActionOnElement(AppiumDriver<MobileElement> driver, MobileElement element)
	{
		AndroidTouchAction touchAction = new AndroidTouchAction(driver); 
		waitTillVisible(driver, element);
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
		
	}
	public static void clickActionOnElementWebelement(AppiumDriver<MobileElement> driver,  MobileElement element)
	{
		waitTillVisible(driver, element);
		element.click();
	}
	public static void pressMobileElement(AppiumDriver<MobileElement> driver, MobileElement element)
	{
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		int X = element.getLocation().x;
		int Y = element.getLocation().y;
		touch.press(PointOption.point(X,Y )).release().perform();
	}
	public static void scrollByCordinates(AppiumDriver<MobileElement> driver)
	{
		int Y=driver.manage().window().getSize().getHeight();
		int X=driver.manage().window().getSize().getWidth();
		int endY = (int) (Y*0.2);
		int startY = (int) (Y*0.8);
		int endX = (int)(X*0.5);
		int startX = (int) (X*0.5);
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.press(ElementOption.point(startX, startY)).moveTo(ElementOption.point(endX, endY)).release().perform();
		System.out.println(startX +" , "+startY+" , "+endX+" , "+endY);
	}
	public static void scrollDownByCordinates(AppiumDriver<MobileElement> driver)
	{
		int Y=driver.manage().window().getSize().getHeight();
		int X=driver.manage().window().getSize().getWidth();
		int endY = (int) (Y*0.2);
		int startY = (int) (Y*0.8);
		int endX = (int)(X*0.5);
		int startX = (int) (X*0.5);
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.press(ElementOption.point(endX, endY)).moveTo(ElementOption.point(startX, startY)).release().perform();
		System.out.println(startX +" , "+startY+" , "+endX+" , "+endY);
	}
	public static void ScrollAndMatcher(AppiumDriver<MobileElement> driver,String classname, String text)
	{
		for (int i = 0; i < 12; i++)
		{
			if (i<6)
			{
				List<MobileElement> mobileelements = driver.findElementsByClassName(classname);
				for(MobileElement mobileelement : mobileelements)
				{
					if(mobileelement.getText().equalsIgnoreCase(text))
					{
						PrintText(text +" found");
						mobileelement.click();
						i=12;
						break;
					}
					else
					{
						PrintText(mobileelement.getText());
					}
				}
				scrollByCordinates(driver);
			}
			else if (i<12 & i>5)
			{
				List<MobileElement> mobileelements = driver.findElementsByClassName(classname);
				for(MobileElement mobileelement : mobileelements)
				{
					if(mobileelement.getText().equalsIgnoreCase(text))
					{
						PrintText(text +" found");
						mobileelement.click();
						i=12;
						break;
					}
					else
					{
						PrintText(mobileelement.getText());
					}
				}
				scrollDownByCordinates(driver);				
			}
			
		}
		
		
	}
	
}

package utility;

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
	public static void waitTillVisible(AppiumDriver<MobileElement> driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void PrintText(String text)
	{
		System.out.println("**************************************************************************");
		System.out.println("**********"+text+"***********************");
		System.out.println("**************************************************************************");
	}
	public static void tapActionOnElement(AppiumDriver<MobileElement> driver, WebElement element)
	{
		AndroidTouchAction touchAction = new AndroidTouchAction(driver); 
		waitTillVisible(driver, element);
		touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
		
	}
	public static void clickActionOnElementWebelement(AppiumDriver<MobileElement> driver,  WebElement element)
	{
		waitTillVisible(driver, element);
		element.click();
	}
	public static void pressMobileElement(AppiumDriver<MobileElement> driver, MobileElement element)
	{
		AndroidTouchAction touch = new AndroidTouchAction(driver);
		touch.press(PointOption.point(element.getLocation().x, element.getLocation().y)).perform();
	}

}

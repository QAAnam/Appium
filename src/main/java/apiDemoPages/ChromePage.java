package apiDemoPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import baseLibrary.BaseLibrary;
import utility.Utility;

public class ChromePage extends BaseLibrary
{
	protected static WebDriver driver;
	@BeforeClass
	public void initializechromr() throws InterruptedException
	{
		BaseLibrary ob = new BaseLibrary();
		ob.initializeChromeDriver();
		this.driver=super.getChromeDriver();
	}
	public void AcceptT_C()
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
	public void seachYouTube() throws InterruptedException
	{
		driver.findElement(By.id("com.android.chrome:id/search_box_text")).sendKeys("You tube");
		Thread.sleep(500);
		List<WebElement> eles = driver.findElements(By.id("com.android.chrome:id/entity_description"));
		for(WebElement element: eles)
		{
			if(element.getText().contains("Video sharing company"))
			{
				element.click();
			}
			else
			{
				driver.get("https://www.youtube.com");
			}
		}
	}
	public void clickOnYouTubeWeb() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement webSite = Utility.findWebElementHavingText(driver, "android.widget.TextView", "https://m.youtube.com");
		webSite.click();
	}
}

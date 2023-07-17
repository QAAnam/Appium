package apiDemoTest;

import org.testng.annotations.Test;

import apiDemoPages.ChromeWithAppiumDriver;

public class ChromewithAppiumTest extends ChromeWithAppiumDriver
{
	ChromeWithAppiumDriver ob = new ChromeWithAppiumDriver();
	
	@Test(priority = 1)
	public void testAcceptT_C()
	{
		ob.acceptT_C();
	}

}

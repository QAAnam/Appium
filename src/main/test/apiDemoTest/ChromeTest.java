package apiDemoTest;

import org.testng.annotations.Test;

import apiDemoPages.ChromePage;

public class ChromeTest extends ChromePage
{
	static ChromePage ob;
	
	@Test(priority =1)
	public void LaunchChrome()
	{
		ob=new ChromePage();
		
	}
	@Test(priority = 2)
	public void acceptTCTest()
	{
		ob.AcceptT_C();
	}
	@Test(priority = 2)
	public void searchyoutubetst() throws InterruptedException
	{
		ob.seachYouTube();
	}
	@Test(priority = 3)
	public void clickOnWebSite() throws InterruptedException
	{
		ob.clickOnYouTubeWeb();
	}
	
}

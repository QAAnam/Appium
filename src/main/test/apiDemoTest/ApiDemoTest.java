package apiDemoTest;
import org.testng.annotations.Test;
import apiDemoPages.ApiDemoPage;

public class ApiDemoTest extends ApiDemoPage
{
	static ApiDemoPage ob;
//	@BeforeTest
//	public void startServer()
//	{
//		StartAppiumServer.startingServer();
//	}
//	@AfterTest
//	public void tearDownServerTest()
//	{
//		StartAppiumServer.tearDownServer();
//	}
	@Test(priority = 0)
	public void acceptTermAndConditionTest()
	{
		ob=new ApiDemoPage();
		System.out.println();
	}
	@Test(priority = 1)
	public void tapOnViewsTest() throws InterruptedException
	{
		Thread.sleep(3000);
		ob.tapOnElementViews();
	}
	@Test(priority = 2)
	public void clickOnElementAnimationTest() throws InterruptedException
	{
		Thread.sleep(3000);
		ob.clickOnElementAnimation();
	}
	@Test(priority = 3)
	public void pressOnElement3D_TransitionTest() throws InterruptedException
	{
		Thread.sleep(3000);
		ob.pressOnElement3D_Transition();
	}
	@Test(priority = 4)
	public void ScrollAndClickOnElementPopUpMenuTest() throws InterruptedException
	{
		Thread.sleep(3000);
		ob.ScrollAndClickOnElementPopUpMenu();
	}
	@Test(priority = 5)
	public void scrollUpDownAndClickTest() throws InterruptedException
	{
		Thread.sleep(3000);
		ob.scrollUpDownAndClick();
	}
	@Test(priority = 6)
	public void clickonOnOffButtonTest() throws InterruptedException
	{
		Thread.sleep(3000);
		ob.clickonOnOffButton();
	}
	@Test(priority = 7)
	public void clickonOnOffButtonTest1() throws InterruptedException
	{
		Thread.sleep(3000);
		ob.clickonOnOffButton();
		Thread.sleep(3000);
	}
	@Test(priority = 8)
	public void longPresspeopleTest() throws InterruptedException
	{
		ob.longPresspeople();
	}
	@Test(priority = 9)
	public void runInBackgroundTest()
	{
		ob.runInBackground();
	}
	@Test(priority = 10)
	public void terminateAppTest() throws InterruptedException
	{
		ob.terminateApp();
	}
	@Test(priority = 11)
	public void activateAppTest() throws InterruptedException
	{
		ob.activateApp();
	}
	@Test(priority = 12)
	public void qureyAppstateTest() throws InterruptedException
	{
		ob.qureyAppstate();;
	}
	@Test(priority = 12)
	public void removeappTest() throws InterruptedException
	{
		//ob.removeapp();
	}
	@Test(priority = 14)
	public void qureyAppstate1Test() throws InterruptedException
	{
		ob.qureyAppstate();
	}
	@Test(priority = 15)
	public void activateApp1Test() throws InterruptedException
	{
		ob.activateApp1();
	}
	@Test(priority = 16)
	public void scrollUpDirectelyWithElementTest() throws InterruptedException
	{
		ob.scrollUpDirectelyWithElement();
	}
	@Test(priority = 17)
	public void terminateAppTest2() throws InterruptedException
	{
		ob.terminateApp();
	}
	

}

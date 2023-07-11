package apiDemoTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
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
	public void tapOnViewsTest()
	{
		ob.tapOnElementViews();
	}
	@Test(priority = 2)
	public void clickOnElementAnimationTest()
	{
		ob.clickOnElementAnimation();
	}
	@Test(priority = 3)
	public void pressOnElement3D_TransitionTest()
	{
		ob.pressOnElement3D_Transition();
	}
	

}

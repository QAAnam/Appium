package baseLibrary;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class BaseLibrary 
{
	public DesiredCapabilities desirecaps()
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "");
		
		return dc;
	}

}

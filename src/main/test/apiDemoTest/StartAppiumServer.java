package apiDemoTest;

import java.io.File;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utility.Utility;

public class StartAppiumServer {

	public static AppiumDriverLocalService services;
	public static String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
	public static String appiumJsmainPath = "C:\\Program Files\\Appium Server GUI\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
	public static String serverAddress = "127.0.0.1";

	public static void startingServer() {
		try {
			services = AppiumDriverLocalService
					.buildService(new AppiumServiceBuilder().usingDriverExecutable(new File(nodeExePath))
							.withAppiumJS(new File(appiumJsmainPath)).withIPAddress(serverAddress).usingPort(4723)
							.withLogFile(new File(System.getProperty("user.dir") + "log.txt")));
			services.start();
		} catch (Exception e) {
			Utility.PrintText("appium may be started");
		}
	}

	public static void tearDownServer() {
		try {
			if (services.isRunning() == true) {
				services.stop();
				Utility.PrintText("" + services.isRunning());
				System.out.println();
			}
		} catch (Exception e) {
			Utility.PrintText("no need to close");
		} 
	}

}

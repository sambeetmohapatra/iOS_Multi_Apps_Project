package iOS.LaunchApps;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import iOS.BaseClass.iOSBase_Class;
import iOS.Utilities.Utility;
import io.appium.java_client.ios.IOSDriver;

public abstract class Launch_Apps extends Utility implements iOSBase_Class {

	private DesiredCapabilities caps;
	private Process process;
	public static ExtentReports report;
	public ExtentTest logger;
	
	public void Launch_iOS_Application(String bundleId) {
		if(iOSDevice.equalsIgnoreCase("iPhone")) {
			try {
				
			//Set Desired Capabilities
					Reporter.log(Utility.getFormatedDateTime()+" Setting Desired Capabilities - iOS on : "+iOSDevice,true);

					caps = new DesiredCapabilities();
					caps.setCapability("platformName", Utility.getProperty("platformName", PROPERTIES_FILE));
					caps.setCapability("platformVersion", Utility.getProperty("platformVersion", PROPERTIES_FILE));
					caps.setCapability("deviceName", Utility.getProperty("deviceName", PROPERTIES_FILE));
					caps.setCapability("noReset", true);
					
			//Set Application Capabilities		
					caps.setCapability("bundleId",bundleId);
					
			// Launch iOSDriver
					Reporter.log(Utility.getFormatedDateTime()+" Launching iOSDriver with capabilities : "+caps,true);
					
					driver = new IOSDriver<WebElement>(new URL(APPIUM_SERVER_URL), caps);
					driver.manage().timeouts().implicitlyWait(TimeOut, TimeUnit.SECONDS);
			}
			catch (Exception e) {
					Reporter.log(" Please Open iPhone 7 Simulator or Start Appium Server"+e,true);
			}
			}
		
	}

	@Override
	public void startServer() {
		try {
		String[] command = { "/usr/bin/killall", "-9", "node" };
		Runtime.getRuntime().exec(command);
		String[] commandProxy = { "/usr/bin/killall", "-9", "ios_webkit_debug_proxy" };
		Runtime.getRuntime().exec(commandProxy);
		//Start Appium Server 
		
		String start_server = "/usr/local/bin/node /usr/local/bin/appium";
		process = Runtime.getRuntime().exec(start_server);
		Wait(start_Appium_Time);
		/*
			Reporter.log("Start Execution",true);
			  process = Runtime.getRuntime().exec("/usr/bin/open -a /Applications/Utilities/Terminal.app /bin/bash /usr/local/bin/appium");
			    process.waitFor();	
			    Wait(8);*/
		
		if(process!=null)
			System.out.println(getFormatedDateTime() +" Started Appium Server");
		else
			System.out.println(getFormatedDateTime() +" Unable to launch Appium Server");
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	//Stop Appium Server Method -Mac
	public void stopServer(){
		
		process.destroy();
		//kill appium node after end of your execution
		String[] command = { "/usr/bin/killall", "-9", "node" };
		try {
		Runtime.getRuntime().exec(command);
		System.out.println(getFormatedDateTime() +"Appium server stopped.");
		} catch (IOException e) {
		e.printStackTrace();
		}
		//Kill webkit proxy for iOS
		String[] commandProxy = { "/usr/bin/killall", "-9", "ios_webkit_debug_proxy" };
		try {
		Runtime.getRuntime().exec(commandProxy);
		System.out.println(getFormatedDateTime() +"iOS Webkit proxy stopped");
		
		} catch (IOException e) {
			System.out.println(e);	
		}
		
		
	}
	
	
}

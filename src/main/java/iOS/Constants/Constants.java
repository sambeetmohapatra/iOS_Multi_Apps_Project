/**
 * 
 */
package iOS.Constants;

/**
 * @author sambeetmohapatra
 *
 */
public interface Constants extends Excel_SheetNames {
	
	String iOSDevice="iPhone"; //***** Using iPhone 7

	int start_Appium_Time =10;
	
	int TimeOut =20; // Waiting period Timeout
	
	
	String NAME_ATTRIBUTE="name";
	String LABEL_ATTRIBUTE="label";
	String VALUE_ATTRIBUTE="value";

	String APPIUM_SERVER_URL="http://127.0.0.1:4723/wd/hub";

	String WORKSPACE_PATH = System.getProperty("user.dir");
	//String TEST_DATA_FILE="./src/test/resources/TestData.xls"; // input is taken from suite xml
	
	String REPORT_PATH="/Users/sambeetmohapatra/Desktop/Sambeet_Work/iOS_Multi_Apps_Project/Reports/";
	String SCREENSHOT_PATH="/Users/sambeetmohapatra/Desktop/Sambeet_Work/iOS_Multi_Apps_Project/ScreenShots/";
	String ERROR_SCREENSHOT_PATH = "/Users/sambeetmohapatra/Desktop/Sambeet_Work/iOS_Multi_Apps_Project/Error_Screenshots/";
	String EXTENT_CONFIG_FILE="./src/test/resources/extent_config.xml";
	String PROPERTIES_FILE="./src/test/resources/App_Settings.properties";
	
	String WebUrl = "http://automationpractice.com/index.php";
	String Native_App_View ="NATIVE_APP";
	String Web_App_View = "WEBVIEW";
}

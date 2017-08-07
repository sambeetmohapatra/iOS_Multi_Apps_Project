/**
 * 
 */
package iOS.TestApp.scripts;

import java.util.Iterator;
import java.util.Map;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;
import iOS.DataProvider.Dataprovider_testdata;
import iOS.POMLibrary.Get_WebElement_XML;

/**
 * @author sambeetmohapatra
 *
 */
public class Test_02_Alerts_TestApp extends Base_Class {

	
	@Test (dataProvider="dp_Test_02_Alerts_TestApp")
	public void test_02_Alerts_TestApp (Map<String,String> data) throws Exception {


// Initialization
		Get_WebElement_XML object = new Get_WebElement_XML(PageObjects_File)	;

//Step 1 : Verify the Test App Home Page is displayed with Compute Sum Button
		logger.log(LogStatus.INFO,"Step 1 : Verify the Test App Home Page is displayed with Compute Sum Button");
		
		WebElement Compute_Sum_btn = waitForElement(object.getElementByXpath("Test_HomePage/Compute_Sum_btn"));
		Assert.assertTrue(isElementDisplayed(Compute_Sum_btn));
		
		logger.log(LogStatus.PASS,"Step 1 : Verify the Test App Home Page is displayed with Compute Sum Button : "+showAttribute(Compute_Sum_btn, NAME_ATTRIBUTE));

//Step 2 : Click on Show Alert and validate the header 
		logger.log(LogStatus.INFO,"Step 2 : Click on Show Alert and validate the header");
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("Test_HomePage/ShowAlert_label"))));
		Tap_on_element(object.getElementByXpath("Test_HomePage/ShowAlert_label"));
		waitForAlert();
		String Show_Alert_Header = showText(waitForElement(object.getElementByXpath("Test_HomePage/ShowAlertHeader_label")));
		Assert.assertEquals(Show_Alert_Header, data.get("TestData_1"));
		takeScreenshot();
		dismissAlert();
		
		logger.log(LogStatus.PASS,"Step 2 : Click on Show Alert and validate the header : "+Show_Alert_Header);
		
///Step 3 : Click on Calendar Alert and validate the header 
		logger.log(LogStatus.INFO,"Step 3 : Click on Calendar Alert and validate the header");
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("Test_HomePage/CalendarAlert_label"))));
		Tap_on_element(object.getElementByXpath("Test_HomePage/CalendarAlert_label"));
		waitForAlert();
		String Calendar_Alert_Header = showText(waitForElement(object.getElementByXpath("Test_HomePage/CalendarAlertHeader_label")));
		Assert.assertEquals(Calendar_Alert_Header,  data.get("TestData_2"));
		takeScreenshot();
		dismissAlert();
		
		logger.log(LogStatus.PASS,"Step 3 : Click on Calendar Alert and validate the header : " +Calendar_Alert_Header);
		
//Step 4 : Validate the Slider is displayed in the homepage and validate its value 
		logger.log(LogStatus.INFO,"Step 4 : Validate the Slider is displayed in the homepage and validate its value");
		String Slider_Value = showAttribute(waitForElement(object.getElementByXpath("Test_HomePage/Slider")), VALUE_ATTRIBUTE);

		Assert.assertEquals(Slider_Value,  data.get("TestData_3"));
		logger.log(LogStatus.PASS,"Step 4 : Validate the Slider is displayed in the homepage and validate its value");

	}
	
	
	
	@DataProvider(name="dp_Test_02_Alerts_TestApp")
	public  Iterator<Object[]> getdata_Test_02_Alerts_TestApp() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,TEST_DATA_SHEETNAME,"Test_02_Alerts_TestApp");
	
	}
}

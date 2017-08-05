/**
 * 
 */
package iOS.UI_Catalog.scripts;


import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;
import iOS.DataProvider.Dataprovider_testdata;
import iOS.POMLibrary.Get_WebElement_JSON;


/**
 * @author sambeetmohapatra
 *
 */
public class Test_10_UI_Catalog_Switches extends Base_Class {

	@Test(dataProvider="dp_Test_10_UI_Catalog_Switches")
	public void test_10_UI_Catalog_Switches(Map<String,String> data) throws Exception{
		
// Initialization
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	swipeDown_Vertical(1);
	
	WebElement Switches_id = waitForElement(element.getElementByAccessibilityId("Switches_id"));
	Assert.assertTrue(isElementDisplayed(Switches_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Switches_id));
	
//Step 2 : Click on Switches label and Validate the Header Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Switches label and Validate the Header Displayed");
	click(Switches_id);
	Assert.assertTrue(isElementDisplayed(Switches_id));
	logger.log(LogStatus.PASS," Header is Displayed : " + showAttribute(Switches_id, NAME_ATTRIBUTE));

//Step 3 : Validate the Labels for the Switches displayed
	logger.log(LogStatus.INFO, "Step 3 : Validate the Labels for the Switches displayed");
	
	WebElement Default_label = waitForElement(element.getElementByXpath("Default_label_xpath"));
	Assert.assertEquals(showText(Default_label), data.get("TestData_1"),"Data Mismatch");
	
	WebElement Tinted_label = waitForElement(element.getElementByXpath("Tinted_label_xpath"));
	Assert.assertEquals(showText(Tinted_label), data.get("TestData_2"),"Data Mismatch");
	
	logger.log(LogStatus.PASS, " Actual Labels for the Steppers displayed : " + showText(Default_label) + " ; "+ showText(Tinted_label));

//Step 4 : Turn On/Off the Default Switch - Tap and Take Screenshot
	logger.log(LogStatus.INFO, "Step 4 : Turn On/Off the Default Switch - Tap and Take Screenshot");
	WebElement Default_Switch_Btn = waitForElement(element.getElementByXpath("Default_Switch_xpath"));
	Assert.assertTrue(isElementDisplayed(Default_Switch_Btn));
	Tap_on_element(Default_Switch_Btn);
	takeScreenshot();
	Tap_on_element(Default_Switch_Btn);
	logger.log(LogStatus.PASS, "Successful :  Turned On/Off the Default Switch");

//Step 5 : Turn On/Off  the Tinted Switch - Tap and Take Screenshot
	logger.log(LogStatus.INFO, "Step 5 : Turn On/Off  the Tinted Switch - Tap and Take Screenshot");
	WebElement Tinted_Switch_Btn = waitForElement(element.getElementByXpath("Tinted_Switch_xpath"));
	Assert.assertTrue(isElementDisplayed(Tinted_Switch_Btn));
	Tap_on_element(Tinted_Switch_Btn);
	takeScreenshot();
	Tap_on_element(Tinted_Switch_Btn);
	logger.log(LogStatus.PASS, "Successful :  Turned On/Off the Default Switch");
	
//Step 6 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 6 : Go Back to Home Screen ");
	goBack();

	}
	
	@DataProvider(name="dp_Test_10_UI_Catalog_Switches")
	public  Iterator<Object[]> getdata_Test_07_UI_Catalog_SegmentedControls() throws Exception
	{
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,EXCEL_SHEET_UI_CATALOG,"Test_10_UI_Catalog_Switches");
	
	}
}

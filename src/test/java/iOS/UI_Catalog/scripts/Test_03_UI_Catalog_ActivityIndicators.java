/**
 * 
 */
package iOS.UI_Catalog.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;
import iOS.DataProvider.ExcelReadWrite;
import iOS.POMLibrary.Get_WebElement_JSON;


/**
 * @author sambeetmohapatra
 *
 */
public class Test_03_UI_Catalog_ActivityIndicators extends Base_Class {

	@Test
	public void test_03_UI_Catalog_ActivityIndicators() throws Exception{
		
// Initialization
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);	
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed 
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully and "
					+ "HomePage is displayed ");
	WebElement Activity_Indicators_id= waitForElement(element.getElementByAccessibilityId("Activity Indicators_id"));
	Assert.assertTrue(isElementDisplayed(Activity_Indicators_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Activity_Indicators_id));
	
//Step 2 : Click on Activity Indicators ; Validate Activity Indicators Screen is displayed
	
	logger.log(LogStatus.INFO,"Step 2 : Click on Activity Indicators ; Validate Activity Indicators Screen is displayed");
	click(Activity_Indicators_id);
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Activity Indicators_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Indicator_GRAY_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Indicator_TINTED_id"))));

	logger.log(LogStatus.PASS, "Page Elements are displayed and validated");
	
//Step 3 : Validate the name of the Progress Bar
	logger.log(LogStatus.INFO,"Step 3 : Validate the name of the Progress Bar");

	 String Type_Cell1_Actual_value = waitForElement(element.getElementByXpath("TypeCell1_xpath")).getAttribute("name");
	 String Type_Cell_Exp_Value =ExcelReadWrite.getExcelData(TestData_Sheet,EXCEL_SHEET_UI_CATALOG, 1, 1);
	 Assert.assertEquals(Type_Cell1_Actual_value, Type_Cell_Exp_Value,"Mismatch");
	 takeScreenshot();
	 logger.log(LogStatus.PASS, "Values are validated , Actual : "+Type_Cell1_Actual_value);
	 
//Step 4 : Go Back to Home Screen 
		logger.log(LogStatus.INFO, "Step 4: Go Back to Home Screen ");
		goBack();
		
//Step 5 : Navigate to Activity Indicators Screen again . Click on UI Catalog Back Button
		if(iOSDevice.equalsIgnoreCase("iPhone")) {
		logger.log(LogStatus.INFO, "Step 5 : Navigate to Activity Indicators Screen again. Click on UI Catalog Back Button");
		click(Activity_Indicators_id);
		Tap_on_element(element.getElementByAccessibilityId("Back_id"));
		logger.log(LogStatus.PASS, "Home Screen is displayed");

		}
	 
	}
	

}

/**
 * 
 */
package iOS.UI_Catalog.scripts;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;
import iOS.POMLibrary.Get_WebElement_JSON;

/**
 * @author sambeetmohapatra
 *
 */
public class Test_02_UI_Catalog_ActionSheets extends Base_Class {

	@Test
	public void test_02_UI_Catalog_ActionSheets() throws Exception{
		
// Initialization
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
	
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed with First Label - Action Sheets
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully and "
					+ "HomePage is displayed with First Label - Action Sheets");
	WebElement Action_Sheets_id = waitForElement(element.getElementByAccessibilityId("Action Sheets_id"));
	Assert.assertTrue(isElementDisplayed(Action_Sheets_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Action_Sheets_id));
	
//Step 2 : Click on Action Sheets ; Validate Action Sheets Page is displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Action Sheets ; Validate Action Sheets Page is displayed");
	click(Action_Sheets_id);
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Action Sheets_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Okay/Cancel_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Other_id"))));
	if(iOSDevice.equalsIgnoreCase("iPhone")) {
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Back_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("UICatalog_id"))));
	}
	logger.log(LogStatus.PASS, "Action Sheets Screen is displayed ; Elements are validated");
	

//Step 3 : Click on Okay / Cancel  . Validate Okay And Cancel Buttons are displayed
	logger.log(LogStatus.INFO,"Step 3 : Click on Okay / Cancel  . Validate Okay And Cancel Buttons are displayed");
	click(element.getElementByAccessibilityId("Okay/Cancel_id"));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("OK_id"))));
	if(iOSDevice.equalsIgnoreCase("iPhone")) { // Changes for iPhone
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Cancel_id"))));
	}
	logger.log(LogStatus.PASS, " Validated ; Result : "+showText(element.getElementByAccessibilityId("OK_id")));
	takeScreenshot();
	
//Step 4 : Click on Ok Button . 
	logger.log(LogStatus.INFO, "Step 4 : Click on Ok Button ");
	click(element.getElementByAccessibilityId("OK_id"));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Action Sheets_id"))));
	logger.log(LogStatus.PASS, "Action Sheets Screen is displayed");
	if(iOSDevice.equalsIgnoreCase("iPhone")) {
	
//Step 5 : Now Click on Cancel Button . 
	logger.log(LogStatus.INFO, "Step 5 : Now Click on Cancel Button .");
	click(element.getElementByAccessibilityId("Okay/Cancel_id"));
	
	//Click Cancel
	click(element.getElementByAccessibilityId("Cancel_id"));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Action Sheets_id"))));
	logger.log(LogStatus.PASS, "Action Sheets Screen is displayed");

	}
//Step 6 : Tap on Other. Validate the Options displayed
	logger.log(LogStatus.INFO, "Step 6 : Tap on Other. Validate the Options displayed");
	Tap_on_element(element.getElementByAccessibilityId("Other_id"));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Safe Choice_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Destructive Choice_id"))));
	
	logger.log(LogStatus.PASS, "Values Displayed : "+showText(element.getElementByAccessibilityId("Safe Choice_id"))+showText(element.getElementByAccessibilityId("Destructive Choice_id")));
	takeScreenshot();

//Step 7 : Select Safe Choice Option 
	logger.log(LogStatus.INFO, "Step 7 : Select Safe Choice Option ");
	Tap_on_element(element.getElementByAccessibilityId("Safe Choice_id"));
	logger.log(LogStatus.PASS, "Action Sheets Screen is displayed");

//Step 8 : Now Select Destructive Choice Option
	logger.log(LogStatus.INFO, "Step 8 : Now Select Destructive Choice Option");
	Tap_on_element(element.getElementByAccessibilityId("Other_id"));
	Tap_on_element(element.getElementByAccessibilityId("Destructive Choice_id"));
	logger.log(LogStatus.PASS, "Action Sheets Screen is displayed");

//Step 9 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 9 : Go Back to Home Screen ");
	goBack();
	
//Step 10 : Navigate to Action Sheets Screen again . Click on UI Catalog Back Button
	if(iOSDevice.equalsIgnoreCase("iPhone")) {
	logger.log(LogStatus.INFO, "Step 10 : Navigate to Action Sheets Screen again . Click on UI Catalog Back Button");
	click(Action_Sheets_id);
	Tap_on_element(element.getElementByAccessibilityId("Back_id"));
	logger.log(LogStatus.PASS, "Home Screen is displayed");

	}
	
	}

}

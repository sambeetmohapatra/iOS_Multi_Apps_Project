/**
 * 
 */
package iOS.UI_Catalog.scripts;


import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;
import iOS.POMLibrary.Get_WebElement_JSON;


/**
 * @author sambeetmohapatra
 *
 */
public class Test_14_UI_Catalog_ToolBars extends Base_Class {

	@Test
	public void test_14_UI_Catalog_ToolBars() throws Exception{
		
// Initialization
		
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	swipeDown_Vertical(3);
	WebElement Toolbars_id = waitForElement(element.getElementByAccessibilityId("Toolbars_id"));
	Assert.assertTrue(isElementDisplayed(Toolbars_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Toolbars_id));
		
//Step 2 : Click on ToolBars label and Validate the Header Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Search Bars label and Validate the Header Displayed ");
	click(Toolbars_id);
	Assert.assertTrue(isElementDisplayed(Toolbars_id));
	logger.log(LogStatus.PASS," Header is Displayed : " + showAttribute(Toolbars_id, NAME_ATTRIBUTE));

//Step 3 : Validate the Fields displayed in ToolBars Screen 
	logger.log(LogStatus.INFO, "Step 3 : Validate the Fields displayed in ToolBars Screen ");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("ToolBars_Default_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("ToolBars_Tinted_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("ToolBars_Custom_xpath"))));
	logger.log(LogStatus.PASS, "Step 3 : Validated the Fields displayed in ToolBars Screen ");

//Step 3 : Click on Default Toolbar and Navigate to Default Toolbar
	logger.log(LogStatus.INFO, "Step 3 : Click on Default Toolbar and Navigate to Default Toolbar ");
	click(element.getElementByXpath("ToolBars_Default_xpath"));
	takeScreenshot();
	logger.log(LogStatus.PASS, "Step 3 : Clicked on Default Toolbar and Navigate to Default Toolbar ");

//Step 4 : Validate the Buttons displayed in Default Toolbar Screen
	logger.log(LogStatus.INFO, "Step 4 : Validate the Buttons displayed in Default Toolbar Screen");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Default_Toolbar_Delete_Btn_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Default_Toolbar_Action_Btn_xpath"))));
	
	Tap_on_element(element.getElementByXpath("Default_Toolbar_Action_Btn_xpath"));
	Tap_on_element(element.getElementByXpath("Default_Toolbar_Delete_Btn_xpath"));
	goBack();
	logger.log(LogStatus.INFO, "Step 4 : Validated the Buttons displayed in Default Toolbar Screen");

//Step 5 : Click on Tinted Toolbar and Navigate to Tinted Toolbar
	logger.log(LogStatus.INFO, "Step 5 : Click on Tinted Toolbar and Navigate to Tinted Toolbar ");
	click(element.getElementByXpath("ToolBars_Tinted_xpath"));
	takeScreenshot();
	logger.log(LogStatus.PASS, "Step 5 : Clicked on Tinted Toolbar and Navigate to Tinted Toolbar ");

//Step 6 : Validate the Buttons displayed in Tinted Toolbar Screen
	logger.log(LogStatus.INFO, "Step 6 : Validate the Buttons displayed in Tinted Toolbar Screen");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Tinted_Toolbar_Refresh_Btn_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Tinted_Toolbar_Share_Btn_xpath"))));
	
	Tap_on_element(element.getElementByXpath("Tinted_Toolbar_Refresh_Btn_xpath"));
	Tap_on_element(element.getElementByXpath("Tinted_Toolbar_Share_Btn_xpath"));
	goBack();
	logger.log(LogStatus.INFO, "Step 6 : Validated the Buttons displayed in Tinted Toolbar Screen");

//Step 7 : Click on Custom Tool bar and Navigate to Custom Tool bar
	logger.log(LogStatus.INFO, "Step 7 : Click on Custom Toolbar and Navigate to Custom Toolbar ");
	click(element.getElementByXpath("ToolBars_Custom_xpath"));
	takeScreenshot();
	logger.log(LogStatus.PASS, "Step 7 : Clicked on Custom Toolbar and Navigate to Custom Toolbar ");

//Step 8 : Validate the Buttons displayed in Custom Tool bar Screen
	logger.log(LogStatus.INFO, "Step 8 : Validate the Buttons displayed in Custom Toolbar Screen");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Custom_Toolbar_Tools_Btn_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Custom_Toolbar_Button_Btn_xpath"))));
	
	Tap_on_element(element.getElementByXpath("Custom_Toolbar_Tools_Btn_xpath"));
	Tap_on_element(element.getElementByXpath("Custom_Toolbar_Button_Btn_xpath"));
	logger.log(LogStatus.INFO, "Step 8 : Validated the Buttons displayed in Custom Toolbar Screen");
		
//Step 9 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 9 : Go Back to Home Screen ");
	goBack();
	goBack();

	}

}

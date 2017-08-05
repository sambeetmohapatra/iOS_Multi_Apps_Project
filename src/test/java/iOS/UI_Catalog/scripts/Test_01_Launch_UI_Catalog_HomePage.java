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
public class Test_01_Launch_UI_Catalog_HomePage extends Base_Class {
	

	@Test(invocationCount=1,description="Test UI Catalog APP -Smoke Test")
	public void test_01_Launch_UI_Catalog_HomePage() throws Exception{
// Initialization
		
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed with First Label - Action Sheets
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully and "
					+ "HomePage is displayed with First Label - Action Sheets");
	WebElement Action_Sheets_id = waitForElement(element.getElementByAccessibilityId("Action Sheets_id"));
	Assert.assertTrue(isElementDisplayed(Action_Sheets_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Action_Sheets_id));
	
//Step 2 : Click on Action Sheets and then Navigate back to home page
	logger.log(LogStatus.INFO,"Step 2 : Click on Action Sheets and then Navigate Back to homepage");
	click(Action_Sheets_id);
	takeScreenshot();
	goBack();
	Assert.assertTrue(isElementDisplayed(Action_Sheets_id));
	logger.log(LogStatus.PASS, "Back to Homepage ; Actual : " + showText(Action_Sheets_id));

//Step 3: Swipe To the Bottom of the Screen  , Click on Tool bars and then Navigate back to home page
	logger.log(LogStatus.INFO,"Step 3: Swipe To the Bottom of the Screen, Click on Toolbars and then Navigate back to homepage");
	swipe_Down_VerticalAndTap(element.getElementByAccessibilityId("Toolbars_id"));
	WebElement Toolbars_id = waitForElement(element.getElementByAccessibilityId("Toolbars_id"));
	
	takeScreenshot();
	goBack();
	logger.log(LogStatus.PASS, "Back to Homepage ; Actual : " + showText(Toolbars_id));
	
//Step 4 : Swipe To the Bottom of the Screen 
	logger.log(LogStatus.INFO,"Step 4 : Swipe To the Bottom of the Screen ");
	swipe_Up_VerticalToElement(element.getElementByAccessibilityId("Action Sheets_id"));
	logger.log(LogStatus.PASS, "Scrolled to the Top of the Screen" );

	}

}

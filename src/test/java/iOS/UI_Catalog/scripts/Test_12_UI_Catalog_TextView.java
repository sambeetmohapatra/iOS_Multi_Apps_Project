/**
 * 
 */
package iOS.UI_Catalog.scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;
import iOS.POMLibrary.Get_WebElement_JSON;


/**
 * @author sambeetmohapatra
 *
 */
public class Test_12_UI_Catalog_TextView extends Base_Class {

	@Test(invocationCount=1)
	public void test_12_UI_Catalog_TextView() throws Exception{
		
// Initialization
		
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	swipeDown_Vertical(2);
	WebElement Text_View_id = waitForElement(element.getElementByAccessibilityId("Text_View_id"));
	Assert.assertTrue(isElementDisplayed(Text_View_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Text_View_id));
		
//Step 2 : Click on Text View label and Validate the Header Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Text View label and Validate the Header Displayed");
	click(Text_View_id);
	Assert.assertTrue(isElementDisplayed(Text_View_id));
	logger.log(LogStatus.PASS," Header is Displayed : " + showAttribute(Text_View_id, "name"));
	
//Step 3 : View the Existing Text in the Text View Field of the screen
	logger.log(LogStatus.INFO,"Step 3 : View the Existing Text in the Text View Field of the screen");
	swipeDown_Vertical(3);
	WebElement Text_View_Field = waitForElement(element.getElementByXpath("Text_View_TextField_xpath"));
	String Text_Field_Value = showAttribute(Text_View_Field, VALUE_ATTRIBUTE);
	Reporter.log(Text_Field_Value,true);
	takeScreenshot();
	logger.log(LogStatus.PASS,"Step 3 : Viewed the Existing Text in the Text View Field of the screen : " + Text_Field_Value);

//Step 4 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 4 : Go Back to Home Screen ");
	goBack();

	}

}

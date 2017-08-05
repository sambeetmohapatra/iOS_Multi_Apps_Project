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
public class Test_08_UI_Catalog_Sliders extends Base_Class {

	@Test(invocationCount=1)
	public void test_08_UI_Catalog_Sliders() throws Exception{
		
// Initialization
		
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	swipeDown_Vertical(1);
	WebElement Sliders_id = waitForElement(element.getElementByAccessibilityId("Sliders_id"));
	Assert.assertTrue(isElementDisplayed(Sliders_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Sliders_id));
	
//Step 2 : Click on Sliders label and Validate the Elements Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Sliders label and Validate the Elements Displayed");
	click(Sliders_id);
	takeScreenshot();
	Assert.assertTrue(isElementDisplayed(Sliders_id));
	WebElement Default_Slider = waitForElement(element.getElementByXpath("Default_Slider_xpath"));
	Assert.assertTrue(isElementDisplayed(Default_Slider),"Element not displayed");
	
	WebElement Tinted_Slider = waitForElement(element.getElementByXpath("Tinted_Slider_xpath"));
	Assert.assertTrue(isElementDisplayed(Tinted_Slider),"Element not displayed");

	WebElement Custom_Slider = waitForElement(element.getElementByXpath("Custom_Slider_xpath"));
	Assert.assertTrue(isElementDisplayed(Custom_Slider),"Element not displayed");

	logger.log(LogStatus.PASS,"Step 2 : Clicked on Sliders label and Validated the Slider Elements Displayed");

//Step 3 : Fetch the value attributes of Sliders
	logger.log(LogStatus.INFO,"Step 3 : Fetch the value attributes of Sliders");
	String Default_Slider_value = showAttribute(Default_Slider, "value");

	String Tinted_Slider_value =showAttribute(Tinted_Slider, VALUE_ATTRIBUTE);
	String Custom_Slider_value= showAttribute(Custom_Slider, VALUE_ATTRIBUTE);
	logger.log(LogStatus.PASS,"Step 3 : Values fetched are  : " + Default_Slider_value+ " ; "+Tinted_Slider_value+" ; "+
			Custom_Slider_value);

//Step 4 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 4 : Go Back to Home Screen ");
	goBack();

	}

}

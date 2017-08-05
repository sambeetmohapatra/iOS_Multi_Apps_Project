/**
 * 
 */
package iOS.UI_Catalog.scripts;

import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import iOS.POMLibrary.Get_WebElement_JSON;

/**
 * @author sambeetmohapatra
 *
 */
public class Test_06_UI_Catalog_DatePicker extends iOS.BaseClass.Base_Class {

	@Test
	public void test_06_UI_Catalog_DatePicker() throws Exception{
		
// Initialization
		
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully and HomePage is displayed ");
	WebElement Date_Picker_id = waitForElement(element.getElementByAccessibilityId("Date Picker_id"));
	Assert.assertTrue(isElementDisplayed(Date_Picker_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Date_Picker_id));
	
//Step 2 : Click on Date Picker label and Validate the Elements Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Date Picker label and Validate the Elements Displayed");
	click(Date_Picker_id);
	takeScreenshot();
	Assert.assertTrue(isElementDisplayed(Date_Picker_id));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("TimeStamp_xpath"))));
	logger.log(LogStatus.PASS, "Validated the Elements in Date Picker Screen ");	
	
//Step 3 : Swipe each of the date pickers :
	logger.log(LogStatus.INFO,"Step 3 : Swipe each of the date pickers ");
	if(iOSDevice.equalsIgnoreCase("iPhone")) {
	List<WebElement> DatePicker_Wheels = waitForElements(element.getElementsByXpath("DatePicker_Wheels_xpath"));
	Dimension size = driver.manage().window().getSize();
	  int starty = (int) (size.height * 0.60);
	  int endy = (int) (size.height * 0.30);
	  //Date Pickers X Coordinates
	  int startx[] = {(int) (size.width * 0.20),(int) (size.width * 0.55),(int) (size.width * 0.70),(int) (size.width * 0.80)};
	  
	for(int loopvar=0;loopvar<DatePicker_Wheels.size();loopvar++) {
		Assert.assertTrue(isElementDisplayed(DatePicker_Wheels.get(loopvar)));
		//Swipe each of the date pickers :
		swipe(startx[loopvar], starty, startx[loopvar], endy, 1000, 1);
		logger.log(LogStatus.PASS, "Swiped the Date Picker Succssfully : "+DatePicker_Wheels.get(loopvar));
	}
	takeScreenshot();
	}
	else if(iOSDevice.equalsIgnoreCase("iPad")) {
		List<WebElement> DatePicker_Wheels = waitForElements(element.getElementsByXpath("DatePicker_Wheels_xpath"));
		Dimension size = driver.manage().window().getSize();
		  int starty = (int) (size.height * 0.60);
		  int endy = (int) (size.height * 0.40);
		  //Date Pickers X Coordinates
		  int startx[] = {(int) (size.width * 0.53),(int) (size.width * 0.65),(int) (size.width * 0.70),(int) (size.width * 0.78)};
		  
		for(int loopvar=0;loopvar<DatePicker_Wheels.size();loopvar++) {
			Assert.assertTrue(isElementDisplayed(DatePicker_Wheels.get(loopvar)));
			//Swipe each of the date pickers :
			swipe(startx[loopvar], starty, startx[loopvar], endy, 1000, 1);
			logger.log(LogStatus.PASS, "Swiped the Date Picker Succssfully : "+DatePicker_Wheels.get(loopvar));
		}
		takeScreenshot();
		}

//Step 4 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 4 : Go Back to Home Screen ");
	goBack();

	}

}

/**
 * 
 */
package iOS.HomeSafetyApp.scripts;

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
 * Test_01_HomeSafety_LaunchPage
 * @author sambeetmohapatra
 *
 */
public class Test_01_HomeSafety_LaunchPage extends Base_Class {

	
	@Test (dataProvider="dp_Test_01_HomeSafety_LaunchPage" ,enabled=true)
	public void test_01_HomeSafety_LaunchPage (Map<String,String> data) throws Exception {
		
// Initialization
		Get_WebElement_XML object = new Get_WebElement_XML(PageObjects_File)	;

//Step 1 : Click on Start Button and Validate the HOMESAFETY Header is displayed
		logger.log(LogStatus.INFO,"Step 1 : Click on Start Button and Validate the HOMESAFETY Header is displayed");
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("homesafety_mainPage/homesafety_start"))), "Not Displayed");
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("homesafety_mainPage/homesafety_about"))), "Not Displayed");
		takeScreenshot();
		click(object.getElementByXpath("homesafety_mainPage/homesafety_start"));
		WebElement homesafety_header =waitForElement(object.getElementByXpath("homesafety_mainPage/homesafety_header"));
		Validate_Is_Displayed(homesafety_header);
		
		Assert.assertEquals(showAttribute(homesafety_header, NAME_ATTRIBUTE), data.get("TestData_1"));
		logger.log(LogStatus.PASS,"Step 1 : Validate the HOMESAFETY Header is displayed");
		
//Step 2 : Validate the Elements displayed in HomeSafety Header Page
		logger.log(LogStatus.INFO,"Step 2 : Validate the Elements displayed in HomeSafety Header Page");
		String str[] = {"upstairsliving_btn","backyard_btn","laundryroom_btn","livingroom_btn","kitchen_btn","bathroom_btn","frontyard_btn",
				"nursery_btn","backToStart_btn"};
		takeScreenshot();
		for(int loopvar =0; loopvar<str.length;loopvar++) {
			WebElement elementByXpath = waitForElement(object.getElementByXpath("homesafety_selectionPage/homesafety_"+str[loopvar]));
			Assert.assertTrue(isElementDisplayed(elementByXpath), elementByXpath + " Not Displayed");
			logger.log(LogStatus.INFO,"Element Displayed : " + showAttribute(elementByXpath, NAME_ATTRIBUTE));
		}
		logger.log(LogStatus.PASS,"Step 2 : Validate the Elements displayed in HomeSafety Header Page");

//Step 3 : Click on Back To Start and Navigate Back to Main Page
		logger.log(LogStatus.INFO,"Step 3 : Click on Back To Start and Navigate Back to Main Page");
		Tap_on_element(object.getElementByXpath("homesafety_selectionPage/homesafety_backToStart_btn"));
		logger.log(LogStatus.PASS,"Step 3 : Click on Back To Start and Navigate Back to Main Page");

//Step 4 : Click on About And Validate
		logger.log(LogStatus.INFO,"Step 4 : Click on About And Validate");
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("homesafety_mainPage/homesafety_about"))), "Not Displayed");
		Tap_on_element(object.getElementByXpath("homesafety_mainPage/homesafety_about"));
		takeScreenshot();
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("homesafety_aboutPage/homesafety_about_header"))), "Not Displayed");
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("homesafety_aboutPage/homesafety_about_version"))), "Not Displayed");
		logger.log(LogStatus.PASS,"Step 4 : Clicked on About And Validated About Page ");
		
	}
	
	@DataProvider(name="dp_Test_01_HomeSafety_LaunchPage")
	public  Iterator<Object[]> getdata_Test_01_HomeSafety_LaunchPage() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,TEST_DATA_SHEETNAME,"Test_01_HomeSafety_LaunchPage");
	
	}
}

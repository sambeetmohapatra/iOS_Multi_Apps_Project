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
public class Test_02_HomeSafety_Bedroom extends Base_Class {

	
	@Test (dataProvider="dp_Test_02_HomeSafety_Bedroom" ,enabled=true)
	public void test_02_HomeSafety_Bedroom (Map<String,String> data) throws Exception {
		
// Initialization
		Get_WebElement_XML object = new Get_WebElement_XML(PageObjects_File)	;

//Step 1 : Click on Start Button and Validate the HOMESAFETY Header is displayed
		logger.log(LogStatus.INFO,"Step 1 : Click on Start Button and Validate the HOMESAFETY Header is displayed");
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("homesafety_mainPage/homesafety_start"))), "Not Displayed");
		takeScreenshot();
		click(object.getElementByXpath("homesafety_mainPage/homesafety_start"));
		WebElement homesafety_header =waitForElement(object.getElementByXpath("homesafety_mainPage/homesafety_header"));
		Validate_Is_Displayed(homesafety_header);
		
		Assert.assertEquals(showAttribute(homesafety_header, NAME_ATTRIBUTE), data.get("TestData_1"));
		logger.log(LogStatus.PASS,"Step 1 : Validate the HOMESAFETY Header is displayed");
		
//Step 2 : Validate the Elements displayed in HomeSafety Header Page
		logger.log(LogStatus.INFO,"Step 2 : Validate the Elements displayed in HomeSafety Header Page");
		String str[] = {"bedroom_btn","upstairsliving_btn","backyard_btn","laundryroom_btn","livingroom_btn","kitchen_btn","bathroom_btn","frontyard_btn",
				"nursery_btn","backToStart_btn"};
		WebElement elementByXpath = waitForElement(object.getElementByXpath("homesafety_selectionPage/homesafety_"+str[0])); // CHANGE in EVERY NEW Script
		Assert.assertTrue(isElementDisplayed(elementByXpath), elementByXpath + " Not Displayed");
		logger.log(LogStatus.INFO,"Element Displayed : " + showAttribute(elementByXpath, NAME_ATTRIBUTE));
		
		logger.log(LogStatus.PASS,"Step 2 : Validate the Elements displayed in HomeSafety Header Page");

//Step 3 : Click on Bedroom Button and Validate Bedroom Page is displayed
		logger.log(LogStatus.INFO,"Step 3 : Click on Bedroom Button and Validate Bedroom Page is displayed");
		click(object.getElementByXpath("homesafety_selectionPage/homesafety_"+str[0]));
		
		for(int loopvar =0; loopvar<7;loopvar++) {
			WebElement bedroom_tip = waitForElement(object.getElementByXpath("homesafety_bedroom/homesafety_bedroom_"+(loopvar+1)));
			Assert.assertTrue(isElementDisplayed(bedroom_tip), bedroom_tip + " Not Displayed");
			logger.log(LogStatus.INFO,"Element Displayed : " + showAttribute(bedroom_tip, NAME_ATTRIBUTE));
		}
		logger.log(LogStatus.PASS,"Step 3 : Clicked on Bedroom Button and Validated Bedroom Page is displayed");

//Step 4 : Validate the Information Message displayed at the bottom
		logger.log(LogStatus.INFO,"Step 4 : Validate the Information Message displayed at the bottom of the page " );
		Assert.assertTrue(isElementDisplayed(object.getElementByXpath("homesafety_common/homesafety_message")));
		
		Assert.assertEquals(showAttribute(object.getElementByXpath("homesafety_common/homesafety_message"), NAME_ATTRIBUTE), data.get("TestData_2"));
		logger.log(LogStatus.PASS,"Step 4 : Validated the Information Message displayed at the bottom of the page " +showAttribute(object.getElementByXpath("homesafety_common/homesafety_message"), NAME_ATTRIBUTE) );
		
//Step 5 : Click on Each Button and Validate the Page is displayed 
		logger.log(LogStatus.INFO,"Step 5 : Click on Each Button and Validate the Page is displayed" );
		
		for(int loopvar =1; loopvar<=7;loopvar++) {
			WebElement bedroom_tip_btn = waitForElement(object.getElementByXpath("homesafety_bedroom/homesafety_bedroom_"+(loopvar)));
			Tap_on_element(bedroom_tip_btn);
			logger.log(LogStatus.INFO, "Bedroom No - "+loopvar);
			takeScreenshot();
			Tap_on_element(object.getElementByXpath("homesafety_bedroom/homesafety_bedroom_back_btn"));
		}
		logger.log(LogStatus.PASS,"Step 5 : Clicked on Each Button and Validated the Page is displayed" );

	}
	
	
	
	@DataProvider(name="dp_Test_02_HomeSafety_Bedroom")
	public  Iterator<Object[]> getdata_dp_Test_02_HomeSafety_Bedroom() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,TEST_DATA_SHEETNAME,"Test_02_HomeSafety_Bedroom");
	
	}
}

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
public class Test_13_UI_Catalog_SearchBars extends Base_Class {

	@Test(dataProvider="dp_Test_13_UI_Catalog_SearchBars")
	public void test_13_UI_Catalog_TextView(Map<String,String> data) throws Exception{
		
// Initialization
		
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	swipeDown_Vertical(2);
	WebElement Search_Bars_id = waitForElement(element.getElementByAccessibilityId("Search_Bars_id"));
	Assert.assertTrue(isElementDisplayed(Search_Bars_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Search_Bars_id));
		
//Step 2 : Click on Search Bars label and Validate the Header Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Search Bars label and Validate the Header Displayed ");
	click(Search_Bars_id);
	Assert.assertTrue(isElementDisplayed(Search_Bars_id));
	logger.log(LogStatus.PASS," Header is Displayed : " + showAttribute(Search_Bars_id, NAME_ATTRIBUTE));

//Step 3 : Validate the Fields displayed in Search Bars Screen 
	logger.log(LogStatus.INFO,"Step 3 : Validate the Fields displayed in Search Bars Screen ");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Search_Bar_Default_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Search_Bar_Custom_xpath"))));
	takeScreenshot();
	logger.log(LogStatus.PASS,"Step 3 : Validated the Fields displayed in Search Bars Screen ");
	
//Step 4 : Click on Default and navigate to Search Bars - Default Screen
	logger.log(LogStatus.INFO,"Step 4 : Click on Default and navigate to Search Bars - Default Screen");
	Tap_on_element(element.getElementByXpath("Search_Bar_Default_xpath"));
	logger.log(LogStatus.PASS,"Step 4 : Clicked on Default and navigate to Search Bars - Default Screen");

//Step 5 : Validate the Elements displayed in the Search Bars Default Screen
	logger.log(LogStatus.INFO, "Step 5 : Validate the Elements displayed in the Search Bars Default Screen");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Default_SearchField_xpath"))));
	
	type(element.getElementByXpath("Default_SearchField_xpath"),data.get("TestData_1"));
	
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Default_Search_Cancel_Btn_id"))));
	click(element.getElementByAccessibilityId("Default_Search_Cancel_Btn_id"));
	takeScreenshot();
	logger.log(LogStatus.INFO,"Scope Bar Validation : ");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Default_Search_ScopeBar_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Default_Search_ScopeBar_One_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Default_Search_ScopeBar_Two_id"))));
	
	Tap_on_element(element.getElementByAccessibilityId("Default_Search_ScopeBar_Two_id"));
	Tap_on_element(element.getElementByAccessibilityId("Default_Search_ScopeBar_One_id"));

	logger.log(LogStatus.PASS, "Step 5 : Validated the Elements displayed in the Search Bars Default Screen");

//Step 6 : Clear the Search Field  
	logger.log(LogStatus.INFO, "Step 6 : Clear the Search Field ");
	element.getElementByXpath("Default_SearchField_xpath").clear();
	takeScreenshot();
	logger.log(LogStatus.PASS, "Step 6 : Cleared the Search Field ");

//Step 7 : Go Back to Previous Screen 
	logger.log(LogStatus.INFO, "Step 7 : Go Back to Previous Screen ");
	goBack();
	logger.log(LogStatus.PASS, "Step 7 : Navigated Back to Previous Screen ");
/*
 *  CUSTOM --- 
 */
	
//Step 8 : Click on Custom and navigate to Search Bars - Custom Screen
	logger.log(LogStatus.INFO,"Step 8 : Click on Custom and navigate to Search Bars - Custom Screen");
	Tap_on_element(element.getElementByXpath("Search_Bar_Custom_xpath"));
	logger.log(LogStatus.PASS,"Step 8 : Clicked on Custom and navigate to Search Bars - Custom Screen");
	
//Step 9 : Validate the Custom Search Field 
	logger.log(LogStatus.INFO, "Step 9 : Validate the Custom Search Field ");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Custom_Search_BookMark_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Default_Search_Cancel_Btn_id"))));
	type(element.getElementByXpath("Custom_Search_xpath") ,data.get("TestData_1"));
	takeScreenshot();
	logger.log(LogStatus.PASS, "Step 9 : Validate the Custom Search Field ");

//Step 10 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 10 : Go Back to Home Screen ");
	goBack();
	goBack();

	}
	
	
	@DataProvider(name="dp_Test_13_UI_Catalog_SearchBars")
	public Iterator<Object[]> getdata_Test_13_UI_Catalog_SearchBars() throws Exception
	{
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,EXCEL_SHEET_UI_CATALOG,"Test_13_UI_Catalog_SearchBars");
	
	}

}

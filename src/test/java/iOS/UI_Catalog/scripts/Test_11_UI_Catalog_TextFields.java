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
public class Test_11_UI_Catalog_TextFields extends Base_Class {

	@Test(dataProvider="dp_Test_11_UI_Catalog_TextFields")
	public void test_11_UI_Catalog_TextFields(Map<String,String> data) throws Exception{
		
// Initialization
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	swipeDown_Vertical(1);
	
	WebElement Text_Fields_id = waitForElement(element.getElementByAccessibilityId("Text_Fields_id"));
	Assert.assertTrue(isElementDisplayed(Text_Fields_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Text_Fields_id));
	
//Step 2 : Click on Switches label and Validate the Header Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Switches label and Validate the Header Displayed");
	click(Text_Fields_id);
	Assert.assertTrue(isElementDisplayed(Text_Fields_id));
	logger.log(LogStatus.PASS," Header is Displayed : " + showAttribute(Text_Fields_id, NAME_ATTRIBUTE));

//Step 3 : Validate the Labels for the Switches displayed
	logger.log(LogStatus.INFO, "Step 3 : Validate the Labels for the Switches displayed");
	
	WebElement Default_label = waitForElement(element.getElementByXpath("Default_label_xpath"));
	Assert.assertEquals(showText(Default_label), data.get("TestData_1"),"Data Mismatch");
	
	WebElement Tinted_label = waitForElement(element.getElementByXpath("Tinted_label_xpath"));
	Assert.assertEquals(showText(Tinted_label), data.get("TestData_2"),"Data Mismatch");
	
	WebElement Secure_label = waitForElement(element.getElementByXpath("Secure_label_xpath"));
	Assert.assertEquals(showText(Secure_label), data.get("TestData_3"),"Data Mismatch");
	
	WebElement Specific_label = waitForElement(element.getElementByXpath("Specific_label_xpath"));
	Assert.assertEquals(showText(Specific_label), data.get("TestData_4"),"Data Mismatch");
	
	WebElement Custom_label = waitForElement(element.getElementByXpath("Custom_label_xpath"));
	Assert.assertEquals(showText(Custom_label), data.get("TestData_5"),"Data Mismatch");
	
	WebElement Text_Field_PlaceHolder = waitForElement(element.getElementByXpath("Text_Field_PlaceHolder_xpath"));
	Assert.assertEquals(showText(Text_Field_PlaceHolder), data.get("TestData_6"),"Data Mismatch");
	
	logger.log(LogStatus.PASS, "Validated the Labels for the Switches displayed");

//Step 4 : Enter Data For Default Label Text Field -
	logger.log(LogStatus.INFO, "Step 4 : Enter Data For Default Label Text Field ");
	type(waitForElement(element.getElementByXpath("Default_TextField_xpath")), data.get("TestData_7"));
	takeScreenshot();
	logger.log(LogStatus.PASS, "Entered the Data For Default Label Text Field ");

//Step 5 : Enter Data For Tinted Label Text Field -
	logger.log(LogStatus.INFO, "Step 5 : Enter Data For Tinted Label Text Field ");
	type(waitForElement(element.getElementByXpath("Tinted_TextField_xpath")), data.get("TestData_8"));
	takeScreenshot();
	logger.log(LogStatus.PASS, "Entered the Data For Tinted Label Text Field ");
	driver.hideKeyboard();
	
//Step 6 : Enter Data For Secure Label Text Field -
	logger.log(LogStatus.INFO, "Step 6 : Enter Data For Secure Label Text Field");
	type(waitForElement(element.getElementByXpath("Secure_TextField_xpath")), data.get("TestData_9"));
	takeScreenshot();
	driver.hideKeyboard();
	logger.log(LogStatus.PASS, "Entered the Data For Secure Label Text Field ");
	
//Step 7 : Enter Data For Specific Label Text Field -
	logger.log(LogStatus.INFO, "Step 7 : Enter Data For Specific Label Text Field");
	type(waitForElement(element.getElementByXpath("Specific_TextField_xpath")), data.get("TestData_10"));
	takeScreenshot();
	driver.hideKeyboard();
	logger.log(LogStatus.PASS, "Entered the Data For Specific Label Text Field ");
	
//Step 8 : Enter Data For Custom Label Text Field -
	logger.log(LogStatus.INFO, "Step 8: Enter Data For Custom Label Text Field ");
	type(waitForElement(element.getElementByXpath("Custom_TextField_xpath")), data.get("TestData_11"));
	takeScreenshot();
	driver.hideKeyboard();
	logger.log(LogStatus.PASS, "Entered the Data For Custom Label Text Field ");
	
//Step 9 : Clear Data from Secure and Tinted Label Fields
	logger.log(LogStatus.INFO, "Step 9 : Clear Data from Secure and Tinted Label Fields");
	element.getElementByXpath("Default_TextField_xpath").clear();
	element.getElementByXpath("Tinted_TextField_xpath").clear();
	driver.hideKeyboard();
	takeScreenshot();

//Step 10 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 10 : Go Back to Home Screen ");
	goBack();

	}
	
	@DataProvider(name="dp_Test_11_UI_Catalog_TextFields")
	public  Iterator<Object[]> getdata_Test_07_UI_Catalog_SegmentedControls() throws Exception
	{
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,EXCEL_SHEET_UI_CATALOG,"Test_11_UI_Catalog_TextFields");
	
	}
}

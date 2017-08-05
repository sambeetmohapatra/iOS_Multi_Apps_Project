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
public class Test_04_UI_Catalog_AlertViews extends Base_Class {

	@Test(dataProvider="dp_Test_04_UI_Catalog_AlertViews")
	public void test_04_UI_Catalog_AlertViews(Map<String,String> data) throws Exception{
		
// Initialization
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);	
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed 
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully and HomePage is displayed ");
	WebElement Alert_Views_id= waitForElement(element.getElementByAccessibilityId("Alert Views_id"));
	Assert.assertTrue(isElementDisplayed(Alert_Views_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Alert_Views_id));
	
//Step 2 : Click on Alert_Views ; Validate Alert_Views Screen is displayed
	
	logger.log(LogStatus.INFO,"Step 2 : Click on Alert_Views ; Validate Alert_Views Screen is displayed");
	click(Alert_Views_id);
	
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Alert Views_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Simple_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Okay/Cancel_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Other_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Text_Entry_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Secure_Text_Entry_id"))));

	logger.log(LogStatus.PASS, "Page Elements are displayed");
	
//Step 3 : Click on Simple Alert and validate the Alert Message 
	
	logger.log(LogStatus.INFO,"Step 3 : Click on Simple Alert and validate the Alert Message ");
	WebElement Simple_alert = element.getElementByAccessibilityId("Simple_id");
	click(Simple_alert);
	waitForAlert(); takeScreenshot();
	
	WebElement Simple_Alert_Header_id = waitForElement(element.getElementByAccessibilityId("Simple_Alert_Header_id"));
	Assert.assertTrue(isElementDisplayed(Simple_Alert_Header_id),"Element Not Displayed");
	Assert.assertEquals(showText(Simple_Alert_Header_id), data.get("TestData_1"));
	
	logger.log(LogStatus.PASS, "Expected : "+data.get("TestData_1")+ "; Actual : " +showText(Simple_Alert_Header_id));
	
	WebElement Simple_Alert_Message_id = waitForElement(element.getElementByAccessibilityId("Simple_Alert_Message_id"));
	Assert.assertTrue(isElementDisplayed(Simple_Alert_Message_id),"Element Not Displayed");
	Assert.assertEquals(showText(Simple_Alert_Message_id), data.get("TestData_2"));
	logger.log(LogStatus.PASS, "Expected : "+data.get("TestData_2")+ " ; Actual : " +showText(Simple_Alert_Message_id));

	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("OK_id"))));
	acceptAlert();
	
//Step 4 : Click on Okay/Cancel Alert and validate the Alert message
	logger.log(LogStatus.INFO,"Step 4 : Click on Okay/Cancel Alert and validate the Alert message");
	click(element.getElementByXpath("Okay_Cancel_xpath"));
	waitForAlert(); takeScreenshot();
	
	Assert.assertTrue(isElementDisplayed(Simple_Alert_Header_id),"Element Not Displayed");
	Assert.assertEquals(showText(Simple_Alert_Header_id), data.get("TestData_1"));
	
	Assert.assertTrue(isElementDisplayed(Simple_Alert_Message_id),"Element Not Displayed");
	Assert.assertEquals(showText(Simple_Alert_Message_id), data.get("TestData_2"));
	
	acceptAlert();
	click(element.getElementByXpath("Okay_Cancel_xpath"));
	
	waitForAlert();
	dismissAlert();
	
	logger.log(LogStatus.PASS, "Accepted and Dismissed the  Okay/Cancel Alert");

//Step 5 : Click on MultiChoice Alert and validate the Alert message .Click the choices .
	logger.log(LogStatus.INFO, "Step 5 : Click on MultiChoice Alert and validate the Alert message .Click the choices .");
	click(element.getElementByAccessibilityId("Other_id"));
	waitForAlert();
	Assert.assertTrue(isElementDisplayed(Simple_Alert_Header_id),"Element Not Displayed");
	Assert.assertEquals(showText(Simple_Alert_Header_id), data.get("TestData_1"));
	
	Assert.assertTrue(isElementDisplayed(Simple_Alert_Message_id),"Element Not Displayed");
	Assert.assertEquals(showText(Simple_Alert_Message_id), data.get("TestData_2"));
	
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByAccessibilityId("Choice_One_id"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Choice_Two_xpath"))));

	//Tap on Choice One , Choice Two and Finally Cancel by Dismiss Alert
	logger.log(LogStatus.INFO,"Tap on Choice One , Choice Two and Finally Cancel by using Dismiss Alert");
	Tap_on_element(element.getElementByAccessibilityId("Choice_One_id"));
	
	click(element.getElementByAccessibilityId("Other_id"));
	waitForAlert(); takeScreenshot();
	
	Tap_on_element(element.getElementByXpath("Choice_Two_xpath"));
	click(element.getElementByAccessibilityId("Other_id"));
	waitForAlert();
	dismissAlert();
	logger.log(LogStatus.PASS, "Validated Multi Choice ALert");
	
//Step 6 : Click on Text Entry Alert. Validate the Alert and Send data to Alert
	logger.log(LogStatus.INFO, "Step 6 : Click on Text Entry Alert. Validate the Alert and Send data to Alert");
	click(element.getElementByAccessibilityId("Text_Entry_id"));
	waitForAlert(); 
	
	Assert.assertEquals(showText(Simple_Alert_Header_id), data.get("TestData_1"));
	Assert.assertEquals(showText(Simple_Alert_Message_id), data.get("TestData_2"));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Text_Entry_Text_Field_xpath"))));

	element.getElementByXpath("Text_Entry_Text_Field_xpath").sendKeys(data.get("TestData_3"));
	takeScreenshot();
	acceptAlert();
	
	click(element.getElementByAccessibilityId("Text_Entry_id"));
	waitForAlert();
	element.getElementByXpath("Text_Entry_Text_Field_xpath").sendKeys(data.get("TestData_3"));
	dismissAlert();
	
	logger.log(LogStatus.PASS, "Validated Text Entry ALert");
	
//Step 7 : Click on Secured Text Entry Alert. Validate the Alert and Send data to Alert
	logger.log(LogStatus.INFO, "Step 7 : Click on Secured Text Entry Alert. Validate the Alert and Send data to Alert");
	click(element.getElementByAccessibilityId("Secure_Text_Entry_id"));
	waitForAlert(); 
	
	Assert.assertEquals(showText(Simple_Alert_Header_id), data.get("TestData_1"));
	Assert.assertEquals(showText(Simple_Alert_Message_id), data.get("TestData_2"));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Secure_Text_Entry_Text_Field_xpath"))));

	element.getElementByXpath("Secure_Text_Entry_Text_Field_xpath").sendKeys(data.get("TestData_3"));
	takeScreenshot();
	acceptAlert();
	
	click(element.getElementByAccessibilityId("Secure_Text_Entry_id"));
	waitForAlert();
	element.getElementByXpath("Secure_Text_Entry_Text_Field_xpath").sendKeys(data.get("TestData_3"));
	dismissAlert();
	
	logger.log(LogStatus.PASS, "Validated Secure Text Entry ALert");

//Step 8 : Go Back to Home Screen 
		logger.log(LogStatus.INFO, "Step 8 : Go Back to Home Screen ");
		goBack();
	 
	}
	
	@DataProvider(name="dp_Test_04_UI_Catalog_AlertViews")
	public  Iterator<Object[]> getdata_Test_04_UI_Catalog_AlertViews() throws Exception
	{
		
	return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,EXCEL_SHEET_UI_CATALOG,"Test_04_UI_Catalog_AlertViews");
		
	}
}



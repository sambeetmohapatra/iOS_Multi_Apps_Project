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
public class Test_07_UI_Catalog_SegmentedControls extends Base_Class {

	@Test(dataProvider="dp_Test_07_UI_Catalog_SegmentedControls")
	public void test_07_UI_Catalog_SegmentedControls(Map<String,String> data) throws Exception{
		
// Initialization
		
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully and HomePage is displayed ");
	swipeDown_Vertical(1);
	WebElement Segmented_Controls_id = waitForElement(element.getElementByAccessibilityId("Segmented Controls_id"));
	Assert.assertTrue(isElementDisplayed(Segmented_Controls_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Segmented_Controls_id));
	
//Step 2 : Click on Segmented Controls label and Validate the Elements Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Segmented Controls label and Validate the Elements Displayed");
	click(Segmented_Controls_id);
	takeScreenshot();
	Assert.assertTrue(isElementDisplayed(Segmented_Controls_id));
	logger.log(LogStatus.PASS,"Step 2 : Validated the header - Segmented Controls Displayed");

//Step 3 : Validate The Button Texts and Click on each of them 
	logger.log(LogStatus.INFO,"Step 3 : Validate The Button Texts and Click on each of them ");

	//DEFAULT
	logger.log(LogStatus.INFO," Validate The Button Texts : DEFAULT ");

	String Actual_Default_label = showText(element.getElementByXpath("Default_label_xpath"));
	String Expected_Default_label= data.get("TestData_1");
	Assert.assertEquals(Actual_Default_label, Expected_Default_label, "Data Mismacth");
	
	WebElement Default_Check_Btn = waitForElement(element.getElementByXpath("Default_Check_Button_xpath"));
	Assert.assertEquals(showAttribute(Default_Check_Btn, NAME_ATTRIBUTE),data.get("TestData_3"));
	click(Default_Check_Btn);
	
	WebElement Default_Search_Btn = waitForElement(element.getElementByXpath("Default_Search_Button_xpath"));
	Assert.assertEquals(showAttribute(Default_Search_Btn, NAME_ATTRIBUTE),data.get("TestData_4"));
	click(Default_Search_Btn);
	
	WebElement Default_Tools_Btn = waitForElement(element.getElementByXpath("Default_Tools_Button_xpath"));
	Assert.assertEquals(showAttribute(Default_Tools_Btn, NAME_ATTRIBUTE),data.get("TestData_5"));
	click(Default_Tools_Btn);
	logger.log(LogStatus.PASS," Validated The Button Texts : DEFAULT ");

	//TINTED
	logger.log(LogStatus.INFO," Validate The Button Texts : TINTED ");

	String Actual_Tinted_label2 = showText(element.getElementByXpath("Tinted_label_xpath"));
	String Expected_Tinted_label2= data.get("TestData_2");
	Assert.assertEquals(Actual_Tinted_label2, Expected_Tinted_label2, "Data Mismacth");
	
	WebElement Tinted_Check_Btn = waitForElement(element.getElementByXpath("Tinted_Check_Button_xpath"));
	Assert.assertEquals(showAttribute(Tinted_Check_Btn, NAME_ATTRIBUTE),data.get("TestData_3"));
	click(Tinted_Check_Btn);
	
	WebElement Tinted_Search_Btn = waitForElement(element.getElementByXpath("Tinted_Search_Button_xpath"));
	Assert.assertEquals(showAttribute(Tinted_Search_Btn, NAME_ATTRIBUTE),data.get("TestData_4"));
	click(Tinted_Search_Btn);
	
	takeScreenshot();
	
	WebElement Tinted_Tools_Btn = waitForElement(element.getElementByXpath("Tinted_Tools_Button_xpath"));
	Assert.assertEquals(showAttribute(Tinted_Tools_Btn, NAME_ATTRIBUTE),data.get("TestData_5"));
	click(Tinted_Tools_Btn);
	logger.log(LogStatus.PASS," Validated The Button Texts : TINTED ");

	//CUSTOM SEGMENTS
	logger.log(LogStatus.INFO," Validate The Button Texts : CUSTOM SEGMENTS ");

	Assert.assertEquals(showText(element.getElementByXpath("Custom_Segments_label_xpath")), data.get("TestData_6"), "Data Mismacth");
	
	WebElement Custom_Segments_Check_Btn = waitForElement(element.getElementByXpath("Custom_Segments_Done_Button_xpath"));
	Assert.assertEquals(showAttribute(Custom_Segments_Check_Btn, NAME_ATTRIBUTE),data.get("TestData_7"));
	click(Custom_Segments_Check_Btn);
	
	WebElement Custom_Segments_Search_Btn = waitForElement(element.getElementByXpath("Custom_Segments_Search_Button_xpath"));
	Assert.assertEquals(showAttribute(Custom_Segments_Search_Btn, NAME_ATTRIBUTE),data.get("TestData_8"));
	click(Custom_Segments_Search_Btn);
	
	WebElement Custom_Segments_Tools_Btn = waitForElement(element.getElementByXpath("Custom_Segments_Settings_Button_xpath"));
	Assert.assertEquals(showAttribute(Custom_Segments_Tools_Btn, NAME_ATTRIBUTE),data.get("TestData_9"));
	click(Custom_Segments_Tools_Btn);
	logger.log(LogStatus.PASS,"Step 3 : Validated The Button Texts : CUSTOM SEGMENTS ");

	if(iOSDevice.equalsIgnoreCase("iPhone")) {
	logger.log(LogStatus.INFO, "Swipe Down Vertically");
	swipeDown_Vertical(1);
	}
	
	//CUSTOM BACKGROUND
	logger.log(LogStatus.INFO," Validate The Button Texts : CUSTOM BACKGROUND");

	Assert.assertTrue(isElementDisplayed(element.getElementByXpath("Custom_Background_label_xpath")));

	WebElement Custom_Backgroud_Check_Btn = waitForElement(element.getElementByXpath("Custom_Background_Check_Button_xpath"));
	Assert.assertEquals(showAttribute(Custom_Backgroud_Check_Btn, NAME_ATTRIBUTE),data.get("TestData_3"));
	click(Custom_Backgroud_Check_Btn);
	
	WebElement Custom_Backgroud_Search_Btn = waitForElement(element.getElementByXpath("Custom_Background_Search_Button_xpath"));
	Assert.assertEquals(showAttribute(Custom_Backgroud_Search_Btn, NAME_ATTRIBUTE),data.get("TestData_4"));
	click(Custom_Backgroud_Search_Btn);
	
	WebElement Custom_Backgroud_Tools_Btn = waitForElement(element.getElementByXpath("Custom_Background_Tools_Button_xpath"));
	Assert.assertEquals(showAttribute(Custom_Backgroud_Tools_Btn, NAME_ATTRIBUTE),data.get("TestData_5"));
	click(Custom_Backgroud_Tools_Btn);
	logger.log(LogStatus.PASS," Validate The Button Texts : CUSTOM BACKGROUND");

	logger.log(LogStatus.PASS,"Successfully Validated The Button Texts and Clicked on each of them ");
	takeScreenshot();
	
//Step 4 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 4 : Go Back to Home Screen ");
	goBack();
	}
	
	
	@DataProvider(name="dp_Test_07_UI_Catalog_SegmentedControls")
	public  Iterator<Object[]> getdata_Test_07_UI_Catalog_SegmentedControls() throws Exception
	{
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,EXCEL_SHEET_UI_CATALOG,"Test_07_UI_Catalog_SegmentedControls");
	
	
}
}

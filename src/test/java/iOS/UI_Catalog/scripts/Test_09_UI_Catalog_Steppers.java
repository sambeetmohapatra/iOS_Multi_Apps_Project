/**
 * 
 */
package iOS.UI_Catalog.scripts;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
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
public class Test_09_UI_Catalog_Steppers extends Base_Class {

	@Test(dataProvider="dp_Test_09_UI_Catalog_Steppers")
	public void test_09_UI_Catalog_Steppers(Map<String,String> data) throws Exception{
		
// Initialization
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	swipeDown_Vertical(1);
	
	WebElement Steppers_id = waitForElement(element.getElementByAccessibilityId("Steppers_id"));
	Assert.assertTrue(isElementDisplayed(Steppers_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Steppers_id));
	
//Step 2 : Click on Stepper label and Validate the Header Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Steppers label and Validate the Header Displayed");
	click(Steppers_id);
	Assert.assertTrue(isElementDisplayed(Steppers_id));
	logger.log(LogStatus.PASS," Header is Displayed : " + showAttribute(Steppers_id, "name"));

//Step 3 : Validate the Labels for the Steppers displayed
	logger.log(LogStatus.INFO, "Step 3 : Validate the Labels for the Steppers displayed");
	
	WebElement Default_label = waitForElement(element.getElementByXpath("Default_label_xpath"));
	assertTrue(isElementDisplayed(Default_label));
	Assert.assertEquals(showText(Default_label), data.get("TestData_1"),"Data Mismatch");
	
	WebElement Tinted_label = waitForElement(element.getElementByXpath("Tinted_label_xpath"));
	assertTrue(isElementDisplayed(Tinted_label));
	Assert.assertEquals(showText(Tinted_label), data.get("TestData_2"),"Data Mismatch");

	WebElement Custom_label = waitForElement(element.getElementByXpath("Custom_label_xpath"));
	assertTrue(isElementDisplayed(Custom_label));
	Assert.assertEquals(showText(Custom_label), data.get("TestData_3"),"Data Mismatch");
	logger.log(LogStatus.PASS, " Labels for the Steppers displayed : " + showText(Default_label) + " ; "+ showText(Tinted_label)
								+" ; "+ showText(Custom_label));

//Step 4 : Validate the Increment , Decrement and Number values on the screen
	logger.log(LogStatus.INFO, "Step 4 : Validate the Increment, Decrement and Number values on the screen");
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Default_Decrement_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Default_Increment_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Default_Number_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Tinted_Decrement_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Tinted_Increment_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Tinted_Number_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Custom_Decrement_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Custom_Increment_xpath"))));
	Assert.assertTrue(isElementDisplayed(waitForElement(element.getElementByXpath("Custom_Number_xpath"))));
	
	WebElement Decrement = element.getElementByXpath("Default_Decrement_xpath");
	Assert.assertEquals(showAttribute(Decrement, NAME_ATTRIBUTE), data.get("TestData_4"),"Data Mismatch");
	
	WebElement Increment = element.getElementByXpath("Custom_Increment_xpath");
	Assert.assertEquals(showAttribute(Increment, NAME_ATTRIBUTE), data.get("TestData_5"),"Data Mismatch");
	
	logger.log(LogStatus.PASS, "Step 4 : Validated the Increment, Decrement and Number values on the screen ; "
			+ " Actual : " + showAttribute(Decrement, NAME_ATTRIBUTE) + " ; " + showAttribute(Increment, NAME_ATTRIBUTE));


//Step 5 : Increase and Decrease Value and validate the change in values for Default Label 
	logger.log(LogStatus.INFO, "Step 5 : Increase and Decrease Value and validate the change in values for Default Label ");
	int maxTap = Integer.parseInt(data.get("TestData_6"));
	int Count_Increment = verify_Count_Increment_Decrement(maxTap, element.getElementByXpath("Default_Increment_xpath"));
	
	Assert.assertEquals(Count_Increment+"", showAttribute(waitForElement(element.getElementByXpath("Default_Number_xpath")), VALUE_ATTRIBUTE));
	takeScreenshot();

	int Count_Decrement = verify_Count_Increment_Decrement((maxTap-1), element.getElementByXpath("Default_Decrement_xpath"));
	Assert.assertEquals((maxTap-Count_Decrement)+"", showAttribute(waitForElement(element.getElementByXpath("Default_Number_xpath")), VALUE_ATTRIBUTE));
	logger.log(LogStatus.PASS, "Increased and Decreased Values and validated the change in values for Default Label ");

//Step 6 : Increase and Decrease Value and validate the change in values for Tinted Label 
	logger.log(LogStatus.INFO, "Step 6 : Increase and Decrease Value and validate the change in values for Tinted Label ");
	int Count_Increment2 = verify_Count_Increment_Decrement(maxTap, element.getElementByXpath("Tinted_Increment_xpath"));
	
	Assert.assertEquals(Count_Increment2+"", showAttribute(waitForElement(element.getElementByXpath("Tinted_Number_xpath")), VALUE_ATTRIBUTE));
	takeScreenshot();
	
	int Count_Decrement2 = verify_Count_Increment_Decrement((maxTap-1), element.getElementByXpath("Tinted_Decrement_xpath"));
	Assert.assertEquals((maxTap-Count_Decrement2)+"", showAttribute(waitForElement(element.getElementByXpath("Tinted_Number_xpath")), VALUE_ATTRIBUTE));
	logger.log(LogStatus.PASS, "Increased and Decreased Values and validated the change in values for Tinted Label ");

//Step 7 : Increase and Decrease Value and validate the change in values for Custom Label 
	logger.log(LogStatus.INFO, "Step 7 : Increase and Decrease Value and validate the change in values for Custom Label ");
	int Count_Increment3 = verify_Count_Increment_Decrement(maxTap, element.getElementByXpath("Custom_Increment_xpath"));
	
	Assert.assertEquals(Count_Increment3+"", showAttribute(waitForElement(element.getElementByXpath("Custom_Number_xpath")), VALUE_ATTRIBUTE));
	takeScreenshot();

	int Count_Decrement3 = verify_Count_Increment_Decrement((maxTap-2), element.getElementByXpath("Custom_Decrement_xpath"));
	Assert.assertEquals((maxTap-Count_Decrement3)+"", showAttribute(waitForElement(element.getElementByXpath("Custom_Number_xpath")), VALUE_ATTRIBUTE));
	logger.log(LogStatus.PASS, "Increased and Decreased Values and validated the change in values for Custom Label ");

	
//Step 8 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 8 : Go Back to Home Screen ");
	goBack();

	}
	
	//Common Method for Reusablitlity 
	private int verify_Count_Increment_Decrement(int maxTap,WebElement wb) {
		int count =0;
		for(int i = 0 ; i<maxTap;i++) {
		Tap_on_element(wb);
		count++;
	}
		Reporter.log("Total Tap : " +showAttribute(wb, "name") +" = "+ count,true);
	return count;
}

	@DataProvider(name="dp_Test_09_UI_Catalog_Steppers")
	public  Iterator<Object[]> getdata_Test_07_UI_Catalog_SegmentedControls() throws Exception
	{
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,EXCEL_SHEET_UI_CATALOG,"Test_09_UI_Catalog_Steppers");
	
	}
}

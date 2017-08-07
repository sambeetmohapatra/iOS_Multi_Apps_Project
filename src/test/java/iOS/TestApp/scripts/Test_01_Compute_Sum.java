/**
 * 
 */
package iOS.TestApp.scripts;

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
 * @author sambeetmohapatra
 *
 */
public class Test_01_Compute_Sum extends Base_Class {

	
	@Test (dataProvider="dp_Test_01_Compute_Sum" ,enabled=true)
	public void test_01_Compute_Sum (Map<String,String> data) throws Exception {
		
// Initialization
		Get_WebElement_XML object = new Get_WebElement_XML(PageObjects_File)	;

//Step 1 : Verify the Test App Home Page is displayed with Compute Sum Button
		logger.log(LogStatus.INFO,"Step 1 : Verify the Test App Home Page is displayed with Compute Sum Button");
		WebElement Compute_Sum_btn = waitForElement(object.getElementByXpath("Test_HomePage/Compute_Sum_btn"));
		Assert.assertTrue(isElementDisplayed(Compute_Sum_btn));
		logger.log(LogStatus.PASS,"Step 1 : Verify the Test App Home Page is displayed with Compute Sum Button : "+showAttribute(Compute_Sum_btn, NAME_ATTRIBUTE));

//Step 2 : Enter Integer A and Integer B 
		logger.log(LogStatus.INFO,"Step 2 : Enter Integer A and Integer B ");
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("Test_HomePage/IntegerA_txtbox"))));
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("Test_HomePage/IntegerB_txtbox"))));
		type(object.getElementByXpath("Test_HomePage/IntegerA_txtbox"),data.get("TestData_1"));
		type(object.getElementByXpath("Test_HomePage/IntegerB_txtbox"),data.get("TestData_2"));
		takeScreenshot();
		logger.log(LogStatus.PASS,"Step 2 : Enter Integer A and Integer B ");
		
//Step 3 : Compute the Sum and validate it matches the test data
		logger.log(LogStatus.INFO,"Step 3 : Compute the Sum and validate it matches the test data");
		Tap_on_element(Compute_Sum_btn);
		Wait(1);
		WebElement Answer_label = waitForElement(object.getElementByXpath("Test_HomePage/Answer_label"));
		String Answer_Value = showAttribute(Answer_label, VALUE_ATTRIBUTE);
		Assert.assertEquals(Answer_Value, data.get("TestData_3"));
		takeScreenshot();
		driver.hideKeyboard();
		logger.log(LogStatus.PASS,"Step 3 : Compute the Sum and validate it matches the test data");

	}
	
	
	
	@DataProvider(name="dp_Test_01_Compute_Sum")
	public  Iterator<Object[]> getdata_Test_01_Compute_Sum() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,TEST_DATA_SHEETNAME,"Test_01_Compute_Sum");
	
	}
}

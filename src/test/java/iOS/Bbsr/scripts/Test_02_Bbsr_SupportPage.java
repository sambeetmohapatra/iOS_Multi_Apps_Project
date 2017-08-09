/**
 * 
 */
package iOS.Bbsr.scripts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
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
public class Test_02_Bbsr_SupportPage extends Base_Class {

	
	private HashMap<String, String> testdata;

	@Test (dataProvider="dp_Test_02_Bbsr_SupportPage" ,enabled=true)
	public void test_02_Bbsr_SupportPage (Map<String,String> data) throws Exception {
		
// Initialization
		Get_WebElement_XML object = new Get_WebElement_XML(PageObjects_File);

//Step 1 : Validate the Bhubaneswar Header is displayed
	logger.log(LogStatus.INFO,"Step 1 : Validate the Bhubaneswar Header is displayed ");
	WebElement bbsr_header =waitForElement(object.getElementByXpath("bhubaneswar_mainPage/bhubaneswar_header"));
	Validate_Is_Displayed(bbsr_header);
	
	Assert.assertEquals(showAttribute(bbsr_header, NAME_ATTRIBUTE), data.get("TestData_1"));
	takeScreenshot();
	logger.log(LogStatus.PASS,"Step 1 : Validate the Bhubaneswar Header is displayed ");
	
//Step 2 : Click on Images button in Nav bar
	logger.log(LogStatus.INFO,"Step 2 : Click on Images button in Nav bar");
	
	Validate_Is_Displayed(object.getElementByXpath("common_elements/nav_bar_images"));
	click(object.getElementByXpath("common_elements/nav_bar_images"));
	WebElement bbsr_images_header =waitForElement(object.getElementByXpath("bhubaneswar_imagesPage/bhubaneswar_images_header"));
	Validate_Is_Displayed(bbsr_images_header);
	
	Assert.assertEquals(showAttribute(bbsr_images_header, NAME_ATTRIBUTE), data.get("TestData_2"));
	List<WebElement> bbsr_images = waitForElements(object.getElementsByXpath("bhubaneswar_imagesPage/bhubaneswar_images"));
	for(WebElement i:bbsr_images) {
		Validate_Is_Displayed(i);
	}
	takeScreenshot();
	logger.log(LogStatus.PASS,"Step 2 : Click on Images button in Nav bar ");
	
//Step 3 : Click on More button in Nav bar
	logger.log(LogStatus.INFO,"Step 3 : Click on More button in Nav bar");
	Validate_Is_Displayed(object.getElementByXpath("common_elements/nav_bar_more"));
	click(object.getElementByXpath("common_elements/nav_bar_more"));
	Validate_Is_Displayed(object.getElementByXpath("bhubaneswar_supportpage/support_header"));
	takeScreenshot();
	logger.log(LogStatus.PASS,"Step 3 : Click on More button in Nav bar");
	
	
//Step 4 : Return To Main Page
	logger.log(LogStatus.INFO,"Step 4 : Return To Main Page");
	Tap_on_element(object.getElementByXpath("common_elements/nav_bar_featured"));
	logger.log(LogStatus.PASS,"Step 4 : Return To Main Page");

//Step 5 : Navigate to Support Page Again 
	logger.log(LogStatus.INFO,"Step 5 : Navigate to Support Page Again ");
	click(object.getElementByXpath("common_elements/nav_bar_more"));
	logger.log(LogStatus.PASS,"Step 5 : Navigate to Support Page Again ");

//Step 6 : Validate the Elements displayed in Support Section 
	logger.log(LogStatus.INFO,"Step 6 : Validate the Elements displayed in Support Section");
	Validate_Is_Displayed(object.getElementByXpath("bhubaneswar_supportpage/bhubaneswar_enquiry"));
	Validate_Is_Displayed(object.getElementByXpath("bhubaneswar_supportpage/name"));
	Validate_Is_Displayed(object.getElementByXpath("bhubaneswar_supportpage/phone"));
	Validate_Is_Displayed(object.getElementByXpath("bhubaneswar_supportpage/email"));
	Validate_Is_Displayed(object.getElementByXpath("bhubaneswar_supportpage/address"));
	Validate_Is_Displayed(object.getElementByXpath("bhubaneswar_supportpage/submitBtn"));
	Validate_Is_Displayed(object.getElementByXpath("bhubaneswar_supportpage/querytxtbox"));
	logger.log(LogStatus.PASS,"Step 6 : Validate the Elements displayed in Support Section");
//Step 7 : Enter Data and Click on Submit Button
	logger.log(LogStatus.INFO,"Step 7 : Enter Data and Click on Submit Button");
	type(object.getElementByXpath("bhubaneswar_supportpage/name"), testdata.get("name"));
	type(object.getElementByXpath("bhubaneswar_supportpage/phone"), testdata.get("phone"));
	type(object.getElementByXpath("bhubaneswar_supportpage/email"), testdata.get("email"));
	type(object.getElementByXpath("bhubaneswar_supportpage/address"), testdata.get("address"));
		
	driver.hideKeyboard();
	type(object.getElementByXpath("bhubaneswar_supportpage/querytxtbox"), testdata.get("query"));
	
	//Tap Outside to close keyboard
	logger.log(LogStatus.INFO,"Tap Outside to close keyboard");

		Tap_on_element(object.getElementByXpath("bhubaneswar_supportpage/bhubaneswar_enquiry"));
		click(object.getElementByXpath("bhubaneswar_supportpage/submitBtn"));
	logger.log(LogStatus.PASS,"Step 7 : Enter Data and Click on Submit Button");

//Step 8 : Wait for and Verify the alert is displayed
	logger.log(LogStatus.INFO,"Step 8 : Wait for and verify the alert is displayed");
	waitForAlert();
	WebElement alert_Message = waitForElement(object.getElementByXpath("bhubaneswar_supportpage/alertMessage"));
	Assert.assertEquals(showAttribute(alert_Message, NAME_ATTRIBUTE), data.get("TestData_4"));
	takeScreenshot();
	acceptAlert();
	logger.log(LogStatus.PASS,"Step 8 : Wait for and verify the alert is displayed");
	
	}	
	@BeforeTest
	private void beforeTest_Config() {
		testdata = new HashMap<String, String>();
		testdata.put("name", "Sambeet M");
		testdata.put("phone", "9438455599");
		testdata.put("email", "sambeetabc2@icloud.com");
		testdata.put("address", "Plot-295/2312, Jayadev Vihar, Odisha");
		testdata.put("query", "Which is the best place to Visit from Dec - March ");
	}
	
	@DataProvider(name="dp_Test_02_Bbsr_SupportPage")
	public  Iterator<Object[]> getdata_Test_02_Bbsr_SupportPage() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,TEST_DATA_SHEETNAME,"Test_02_Bbsr_SupportPage");
	
	}
}

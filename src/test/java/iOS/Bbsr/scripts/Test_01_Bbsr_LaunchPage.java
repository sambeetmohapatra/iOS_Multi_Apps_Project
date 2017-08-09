/**
 * 
 */
package iOS.Bbsr.scripts;


import java.util.Iterator;
import java.util.List;
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
public class Test_01_Bbsr_LaunchPage extends Base_Class {

	
	@Test (dataProvider="dp_Test_01_Bbsr_LaunchPage" ,enabled=true)
	public void test_01_Bbsr_LaunchPage (Map<String,String> data) throws Exception {
		
// Initialization
		Get_WebElement_XML object = new Get_WebElement_XML(PageObjects_File)	;

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

	}
	
	
	
	@DataProvider(name="dp_Test_01_Bbsr_LaunchPage")
	public  Iterator<Object[]> getdata_Test_01_Bbsr_LaunchPage() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,TEST_DATA_SHEETNAME,"Test_01_Bbsr_LaunchPage");
	
	}
}

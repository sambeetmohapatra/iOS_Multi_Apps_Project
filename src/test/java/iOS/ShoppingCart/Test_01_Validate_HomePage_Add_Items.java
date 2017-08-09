/**
 * 
 */
package iOS.ShoppingCart;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;
import iOS.DataProvider.Dataprovider_testdata;
import iOS.POMLibrary.Get_WebElement_XML;

/**
 * @author sambeetmohapatra
 *
 */
public class Test_01_Validate_HomePage_Add_Items extends Base_Class{

	@Test(dataProvider="dp_Test_01_Validate_HomePage_Add_Items",enabled=true)
	public void test_01_Validate_HomePage_Add_Items(Map<String,String> data) throws Exception {
		
// Initialization
		Get_WebElement_XML object = new Get_WebElement_XML(PageObjects_File);
		
//Step 1 : Validate the cart header is displayed 
		logger.log(LogStatus.INFO,"Step 1 : Validate the cart header is displayed ");
		WebElement cart_header = waitForElement(object.getElementByXpath("cart_homepage/cart_header"));
		Assert.assertTrue(isElementDisplayed(cart_header));
		Assert.assertEquals(showAttribute(cart_header, NAME_ATTRIBUTE), data.get("TestData_1"));
		takeScreenshot();
		logger.log(LogStatus.PASS,"Step 1 : Validate the cart header is displayed ");

//Step 2 : Validate the Apple Watch is displayed with the name,image and price 
		logger.log(LogStatus.INFO,"Step 2 : Validate the Apple Watch is displayed with the name,image and price");
		
		WebElement apple_watch_img = waitForElement(object.getElementByXpath("cart_homepage/apple_watch_img"));
		Assert.assertTrue(isElementDisplayed(apple_watch_img));
		
		WebElement apple_watch_txt = waitForElement(object.getElementByXpath("cart_homepage/apple_watch_txt"));
		Assert.assertTrue(isElementDisplayed(apple_watch_txt));
		Assert.assertEquals(showAttribute(apple_watch_txt, NAME_ATTRIBUTE), data.get("TestData_2"));
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_watch_price"))));
		logger.log(LogStatus.PASS,"Step 2 : Validate the Apple Watch is displayed with the name,image and price");

//Step 3 : Validate the iPad Mini is displayed with the name,image and price 
		logger.log(LogStatus.INFO,"Step 3 : Validate the iPad Mini is displayed with the name,image and price");
		WebElement apple_ipad_img = waitForElement(object.getElementByXpath("cart_homepage/apple_ipad_img"));
		Assert.assertTrue(isElementDisplayed(apple_ipad_img));
		
		WebElement apple_ipad_txt = waitForElement(object.getElementByXpath("cart_homepage/apple_ipad_txt"));
		Assert.assertTrue(isElementDisplayed(apple_ipad_txt));
		Assert.assertEquals(showAttribute(apple_ipad_txt, NAME_ATTRIBUTE), data.get("TestData_3"));
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_ipad_price"))));
		logger.log(LogStatus.PASS,"Step 3 : Validate the iPad Mini is displayed with the name,image and price");
		
//Step 4 : Validate the Apple TV is displayed with the name,image and price
		logger.log(LogStatus.INFO,"Step 4 : Validate the Apple TV is displayed with the name,image and price");
		WebElement apple_tv_img = waitForElement(object.getElementByXpath("cart_homepage/apple_tv_img"));
		Assert.assertTrue(isElementDisplayed(apple_tv_img));
		
		WebElement apple_tv_txt = waitForElement(object.getElementByXpath("cart_homepage/apple_tv_txt"));
		Assert.assertTrue(isElementDisplayed(apple_tv_txt));
		Assert.assertEquals(showAttribute(apple_tv_txt, NAME_ATTRIBUTE), data.get("TestData_4"));
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_tv_price"))));
		logger.log(LogStatus.PASS,"Step 4 : Validate the Apple TV is displayed with the name,image and price");
		
//Step 5 : Validate the Place Order Button is displayed but inactive 
		logger.log(LogStatus.INFO,"Step 5 : Validate the Place Order Button is displayed but inactive ");
		WebElement cart_place_order_btn = waitForElement(object.getElementByXpath("cart_homepage/cart_place_order_btn"));
		Assert.assertTrue(isElementDisplayed(cart_place_order_btn));
		Assert.assertFalse(isButtonEnabled(cart_place_order_btn));
		logger.log(LogStatus.PASS,"Step 5 : Validate the Place Order Button is displayed but inactive ");
		
//Step 6 : Validate the Stepper is displayed. Perform Increment and decrement on every stepper and validate the value is increased
		logger.log(LogStatus.INFO,"Step 6 : Validate the Stepper is displayed. Perform Increment and decrement on every stepper and validate the value is increased");
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_watch_increment"))));
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_ipad_increment"))));
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_tv_increment"))));
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_watch_decrement"))));
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_ipad_decrement"))));
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/apple_tv_decrement"))));

		click(object.getElementByXpath("cart_homepage/apple_watch_increment"));
		click(object.getElementByXpath("cart_homepage/apple_ipad_increment"));
		click(object.getElementByXpath("cart_homepage/apple_tv_increment"));

		click(object.getElementByXpath("cart_homepage/apple_watch_decrement"));
		click(object.getElementByXpath("cart_homepage/apple_ipad_decrement"));
		click(object.getElementByXpath("cart_homepage/apple_tv_decrement"));
		
		logger.log(LogStatus.PASS,"Step 6 : Validate the Stepper is displayed. Perform Increment and decrement on every stepper and validate the value is increased");

//Step 7 : Validate the Total label, Amount is displayed
		logger.log(LogStatus.INFO,"Step 7 : Validate the Total label, Amount is displayed");
		WebElement cart_total_label = waitForElement(object.getElementByXpath("cart_homepage/cart_total_txt"));
		Assert.assertTrue(isElementDisplayed(cart_total_label));
		Assert.assertEquals(showAttribute(cart_total_label, LABEL_ATTRIBUTE), data.get("TestData_5"));
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/cart_total_amt"))));
		logger.log(LogStatus.PASS,"Step 7 : Validate the Total label, Amount is displayed");
		
//Step 8 : Validate the Disclaimer is displayed
		logger.log(LogStatus.INFO,"Step 8 : Validate the Disclaimer is displayed");
		WebElement cart_disclaimer = waitForElement(object.getElementByXpath("cart_homepage/cart_disclaimer"));
		Assert.assertTrue(isElementDisplayed(cart_disclaimer));
		
		logger.log(LogStatus.PASS,"Step 8 : Validate the Disclaimer is displayed : " + showAttribute(cart_disclaimer, VALUE_ATTRIBUTE));
		
//Step 9 : Validate the Place Order Button is enabled and is active when Items are added
		logger.log(LogStatus.INFO,"Step 9 : Validate the Place Order Button is enabled and is active when Items are added");
		for(int loop =0 ;loop<3;loop++) {
		click(object.getElementByXpath("cart_homepage/apple_watch_increment"));
		}
		takeScreenshot();
		// Validate if enabled
		Assert.assertTrue(isButtonEnabled(cart_place_order_btn));
		Assert.assertEquals(showAttribute(cart_place_order_btn, NAME_ATTRIBUTE),data.get("TestData_6"));
		logger.log(LogStatus.PASS,"Step 9 : Validate the Place Order Button is displayed and is active when Items are added");
	
//Step 10 : 	Validate the Place Order Button is disabled and is active when Items are removed
	logger.log(LogStatus.INFO,"Step 10 Validate the Place Order Button is disabled and is active when Items are removed");
	for(int loop =0 ;loop<3;loop++) {
		click(object.getElementByXpath("cart_homepage/apple_watch_decrement"));
		}
		takeScreenshot();
		// Validate if enabled
		Assert.assertFalse(isButtonEnabled(cart_place_order_btn));
	logger.log(LogStatus.PASS,"Step 10 : Validate the Place Order Button is disabled and is active when Items are removed");

	
	}
	@DataProvider(name="dp_Test_01_Validate_HomePage_Add_Items")
	public  Iterator<Object[]> getdata_Test_01_Validate_HomePage_Add_Items() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,TEST_DATA_SHEETNAME,"Test_01_Validate_HomePage_Add_Items");
	
	}
}

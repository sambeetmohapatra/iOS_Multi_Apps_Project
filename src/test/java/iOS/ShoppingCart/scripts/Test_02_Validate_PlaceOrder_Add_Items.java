/**
 * 
 */
package iOS.ShoppingCart.scripts;

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
public class Test_02_Validate_PlaceOrder_Add_Items extends Base_Class {

	
	@Test(dataProvider="dp_Test_02_Validate_PlaceOrder_Add_Items",enabled=true)
	public void test_02_Validate_PlaceOrder_Add_Items(Map<String,String> data) throws Exception {
		
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
		
		logger.log(LogStatus.PASS,"Step 2 : Validate the Apple Watch is displayed with the name,image and price");

//Step 3 : Validate the iPad Mini is displayed with the name,image and price 
		logger.log(LogStatus.INFO,"Step 3 : Validate the iPad Mini is displayed with the name,image and price");
		WebElement apple_ipad_img = waitForElement(object.getElementByXpath("cart_homepage/apple_ipad_img"));
		Assert.assertTrue(isElementDisplayed(apple_ipad_img));
		
		logger.log(LogStatus.PASS,"Step 3 : Validate the iPad Mini is displayed with the name,image and price");
		
//Step 4 : Validate the Apple TV is displayed with the name,image and price
		logger.log(LogStatus.INFO,"Step 4 : Validate the Apple TV is displayed with the name,image and price");
		WebElement apple_tv_img = waitForElement(object.getElementByXpath("cart_homepage/apple_tv_img"));
		Assert.assertTrue(isElementDisplayed(apple_tv_img));
		logger.log(LogStatus.PASS,"Step 4 : Validate the Apple TV is displayed with the name,image and price");

//Step 5 : Add Items from every Category and Validate the Place Order Button is enabled upon addition 
		logger.log(LogStatus.INFO,"Step 5 : Add Items from every Category and Validate the Place Order Button is enabled upon addition");
		click(object.getElementByXpath("cart_homepage/apple_watch_increment"));
		//Save the Values of Items Added
		
		WebElement apple_watch_price = waitForElement(object.getElementByXpath("cart_homepage/apple_watch_price"));
		double apple_watch_cost = Double.parseDouble(showAttribute(apple_watch_price, VALUE_ATTRIBUTE));
		
		click(object.getElementByXpath("cart_homepage/apple_ipad_increment"));
		WebElement apple_ipad_price = waitForElement(object.getElementByXpath("cart_homepage/apple_ipad_price"));
		double apple_ipad_cost = Double.parseDouble(showAttribute(apple_ipad_price, VALUE_ATTRIBUTE));

		click(object.getElementByXpath("cart_homepage/apple_tv_increment"));
		WebElement apple_tv_price = waitForElement(object.getElementByXpath("cart_homepage/apple_tv_price"));
		double apple_tv_cost = Double.parseDouble(showAttribute(apple_tv_price, VALUE_ATTRIBUTE));

		double sum = apple_watch_cost+apple_ipad_cost+apple_tv_cost;
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_homepage/cart_total_txt"))));
		WebElement cart_total_amt= waitForElement(object.getElementByXpath("cart_homepage/cart_total_amt_value"));
		
		double total_amount_value = Double.parseDouble(showAttribute(cart_total_amt, VALUE_ATTRIBUTE));
		Assert.assertEquals(total_amount_value, sum,"Total Mismatch");
		
		logger.log(LogStatus.INFO,"Expected : " + sum + " | " + "Actual : " + total_amount_value);
		
		//To Check whether the Place Order Button is enabled 
		WebElement cart_place_order_btn = waitForElement(object.getElementByXpath("cart_homepage/cart_place_order_btn"));
		Assert.assertTrue(isButtonEnabled(cart_place_order_btn));
		logger.log(LogStatus.INFO,"Place Order Button is enabled upon addition : " + showAttribute(cart_place_order_btn, NAME_ATTRIBUTE));
		takeScreenshot();
		logger.log(LogStatus.PASS,"Step 5 : Add Items from every Category and Validate the Place Order Button is enabled upon addition");
		
//Step 6 : Click on Place Order Button and Validate the Checkout Page is displayed
		logger.log(LogStatus.INFO,"Step 6 : Click on Place Order Button and Validate the Checkout Page is displayed");
		Tap_on_element(cart_place_order_btn);
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_checkoutpage/checkout_header"))));
		logger.log(LogStatus.PASS,"Step 6 : Click on Place Order Button and Validate the Checkout Page is displayed");

//Step 7 : Validate the Total Amount in the checkout page matches the total amount 
		logger.log(LogStatus.INFO, "Step 7 : Validate the Total Amount in the checkout page matches the total amount ");
		WebElement checkout_total_txt = waitForElement(object.getElementByXpath("cart_checkoutpage/checkout_total_txt"));
		Assert.assertTrue(isElementDisplayed(checkout_total_txt));
		Assert.assertEquals(showAttribute(checkout_total_txt, NAME_ATTRIBUTE), data.get("TestData_2"));

		WebElement checkout_total_amount = waitForElement(object.getElementByXpath("cart_checkoutpage/checkout_total_amount"));
		double checkout_total_amount_value = Double.parseDouble(showAttribute(checkout_total_amount, VALUE_ATTRIBUTE).replace("$", ""));
		
		Assert.assertEquals(total_amount_value, checkout_total_amount_value,"Total Amount Mismatch");
		logger.log(LogStatus.INFO,"Expected : " + checkout_total_amount_value + " | " + "Actual : " + total_amount_value);

		
		logger.log(LogStatus.PASS, "Step 7 : Validate the Total Amount in the checkout page matches the total amount ");

//Step 8 : Validate the Standard Option and Express Options are displayed 
		logger.log(LogStatus.INFO, "Step 8 : Validate the Standard Option and Express Options are displayed ");
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_checkoutpage/checkout_standard_option"))));
		
		WebElement checkout_standard_option_txt = waitForElement(object.getElementByXpath("cart_checkoutpage/checkout_standard_option_txt"));
		Assert.assertTrue(isElementDisplayed(checkout_standard_option_txt));
		String Actual_checkout_standard_option_txt = showAttribute(checkout_standard_option_txt, NAME_ATTRIBUTE);
		Assert.assertEquals(Actual_checkout_standard_option_txt, data.get("TestData_3"));
		
		Assert.assertTrue(isElementDisplayed(waitForElement(object.getElementByXpath("cart_checkoutpage/checkout_express_option"))));
		WebElement checkout_express_option_txt = waitForElement(object.getElementByXpath("cart_checkoutpage/checkout_express_option_txt"));
		Assert.assertTrue(isElementDisplayed(checkout_express_option_txt));
		
		String Actual_checkout_express_option_txt = showAttribute(checkout_express_option_txt, NAME_ATTRIBUTE);
		Assert.assertEquals(Actual_checkout_express_option_txt, data.get("TestData_4"));
		
		Tap_on_element(checkout_express_option_txt);
		takeScreenshot();
		Tap_on_element(checkout_standard_option_txt);

		logger.log(LogStatus.PASS, "Step 8 : Validate the Standard Option and Express Options are displayed ");
//Step 9 : Validate the Place Order Button is displayed
		logger.log(LogStatus.INFO, "Step 9 : Validate the Place Order Button is displayed");
		
		WebElement checkout_place_order_btn = waitForElement(object.getElementByXpath("cart_homepage/cart_place_order_btn"));
		Assert.assertTrue(isElementDisplayed(checkout_place_order_btn));
		Assert.assertEquals(showAttribute(checkout_place_order_btn, NAME_ATTRIBUTE), data.get("TestData_5"));
		
		logger.log(LogStatus.PASS, "Step 9 : Validate the Place Order Button is displayed : "+showText(checkout_place_order_btn));
//Step 10 : Navigate Back to Cart Page 
		logger.log(LogStatus.INFO, "Step 10 : Navigate Back to Cart Page");
		goBack();
		logger.log(LogStatus.PASS, "Step 10 : Navigate Back to Cart Page");
	}
	
	
	@DataProvider(name="dp_Test_02_Validate_PlaceOrder_Add_Items")
	public  Iterator<Object[]> getdata_Test_02_Validate_PlaceOrder_Add_Items() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,TEST_DATA_SHEETNAME,"Test_02_Validate_PlaceOrder_Add_Items");
	
	}
}

/**
 * 
 */
package iOS.UI_Catalog.scripts;


import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;
import iOS.DataProvider.Dataprovider_testdata;
import iOS.POMLibrary.Get_WebElement_JSON;
import iOS.POMLibrary.WebView_MyStore_POM;


/**
 * @author sambeetmohapatra
 *
 */
public class Test_15_UI_Catalog_WebView extends Base_Class {

	@Test(dataProvider="dp_Test_15_UI_Catalog_WebView")
	public void test_15_UI_Catalog_WebView(Map<String,String> data) throws Exception{
		
// Initialization
		
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	swipeDown_Vertical(1);
	WebElement Web_View_id = waitForElement(element.getElementByAccessibilityId("Web_View_id"));
	Assert.assertTrue(isElementDisplayed(Web_View_id));
	logger.log(LogStatus.PASS, "Actual : " + showText(Web_View_id));
		
//Step 2 : Click on WebView label and Validate the Header Displayed
	logger.log(LogStatus.INFO,"Step 2 : Click on Search Bars label and Validate the Header Displayed ");
	click(Web_View_id);
	Assert.assertTrue(isElementDisplayed(Web_View_id));
	logger.log(LogStatus.PASS," Header is Displayed : " + showAttribute(Web_View_id, NAME_ATTRIBUTE));

	
//Step 3 : Enter the new URL and wait till the page is displayed 
	logger.log(LogStatus.INFO,"Step 3 : Enter the new URL and wait till the page is displayed ");
	
	WebElement URL = waitForElement(element.getElementByXpath("WebView_Url_input_xpath"));
	System.out.println(showAttribute(URL, VALUE_ATTRIBUTE));
	
	//Opening the web page in web view
	URL.clear();
	URL.sendKeys(WebUrl+"\n");
	Wait(1);
	logger.log(LogStatus.PASS,"Step 4 : Entered the new URL and the page is displayed ");

//Step 4 : Switch to the Web View and Run a Test Script for Web View 
	logger.log(LogStatus.INFO, "Step 4 : Switch to the Web View and Run a Test Script for Web View ");
	//GET The App Context Handles 
	Reporter.log(getFormatedDateTime()+" - Fetch The App Context Handles - Hybrid App",true);
	Set<String> context = driver.getContextHandles();	
	
	//Switching to Web View for Hybrid App 
	Reporter.log(getFormatedDateTime()+" - Switching to Web View for Hybrid App ",true);

	for(String i:context) {
		System.out.println(i);
		if(i.contains(Web_App_View))
			driver.context(i);
	}
	takeScreenshot();
	logger.log(LogStatus.PASS, "Step 4 : Switched to the Web View URL is displayed as - "+WebUrl);
	
	try {
	// WEB VIEW ---- 
	
	WebView_MyStore_POM mystore = new WebView_MyStore_POM(driver);
	
//Step 5 : Search for a Printed Dress in the Online My Store
	logger.log(LogStatus.INFO, "Step 5 : Search for a Printed Dress in the Online My Store");
	type(mystore.Search_txtbox,data.get("TestData_1")+"\n");
	logger.log(LogStatus.PASS, "Step 5 : Search for a Printed Dress in the Online My Store");

//Step 6 : Swipe down vertically and Add Chiffon Dress to cart and Validate 
	logger.log(LogStatus.INFO, "Step 6 : Swipe down vertically and Add Chiffon Dress to cart");
	swipe_Down_VerticalToElement(mystore.Chiffon_Dress_Result_label);
	Assert.assertTrue(isElementDisplayed(mystore.Chiffon_Dress_Result_label));
	String Actual_Dress_Value = showText(mystore.Chiffon_Dress_Result_label);
	String Exp_Dress_Value = data.get("TestData_2");
	
	Assert.assertEquals(Actual_Dress_Value, Exp_Dress_Value,"Data Mismatch");
	click(mystore.Chiffon_Dress_Result_AddToCart_Btn);
	waitForElement(mystore.Added_Cart_Msg_Window_CloseBtn);
	logger.log(LogStatus.PASS, "Step 6 : Swiped down vertically and Added Chiffon Dress to cart");
	
//Step 7 :Go To Shopping Cart Checkout Screen
	logger.log(LogStatus.INFO, "Step 7 :Go To Shopping Cart Checkout Screen");
	click(mystore.Added_Cart_Msg_Window_CloseBtn);
	takeScreenshot();
	Assert.assertTrue(isElementDisplayed(waitForElement(mystore.View_Cart_Items_Btn)));
	click(mystore.View_Cart_Items_Btn);
	click(mystore.Checkout_Cart_Items_Btn);
	
	Assert.assertTrue(isElementDisplayed(waitForElement(mystore.Shopping_Screen_Header_label)));
	WebView_ScrollDown(2);
	Wait(1);
	takeScreenshot();
	/*WebView_ScrollToBottom();
	Wait(1);*/
	logger.log(LogStatus.PASS, "Step 7 :Go To Shopping Cart Checkout Screen");
	}
	catch (Exception e) {
		//Change the Context back to Native View 
		
		driver.context(Native_App_View)	;
	}
//Step 8 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 8 : Go Back to Home Screen ");
	goBack();
	

	}
	@DataProvider(name="dp_Test_15_UI_Catalog_WebView")
	public Iterator<Object[]> getdata_Test_15_UI_Catalog_WebView() throws Exception
	{
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,EXCEL_SHEET_UI_CATALOG,"Test_15_UI_Catalog_WebView");
	
	}
}

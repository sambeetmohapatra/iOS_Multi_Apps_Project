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
 * 
 *	TEMPLATE FOR TEST SCRIPTS
 *@author sambeetmohapatra
 */
public class Test_"%test case class name% "extends Base_Class {

	@Test(dataProvider="dp_%test case class name%")
	public void test_%test case class name%(Map<String,String> data) throws Exception{
		
// Initialization
		Get_WebElement_JSON element = new Get_WebElement_JSON(PageObjects_File);
			
//Step 1 : Verify App is launched Successfully and HomePage is displayed  
	logger.log(LogStatus.INFO,"Step 1 : Verify App is launched Successfully an HomePage is displayed ");
	logger.log(LogStatus.INFO,"");
	logger.log(LogStatus.PASS,"");
	
//Step 2 : Click on Switches label and Validate the Header Displayed
	
//Step 3 : Validate the Labels for the Switches displayed
	
	driver.hideKeyboard();
	takeScreenshot();

//Step 10 : Go Back to Home Screen 
	logger.log(LogStatus.INFO, "Step 10 : Go Back to Home Screen ");
	goBack();

	}
	/*
	 *  Add Data Provider method here . Pass the arguments to common testdata method in iOS.Dataprovider class
	 */
	
	@DataProvider(name="dp_%test case class name%")
	public  Iterator<Object[]> getdata_Test_07_UI_Catalog_SegmentedControls() throws Exception
	{
		//Sheet location , Sheet Name, Script Name
		return Dataprovider_testdata.commonmethod_for_testdata(TestData_Sheet,EXCEL_SHEET_UI_CATALOG,"%test case class name%");
	
	}
}

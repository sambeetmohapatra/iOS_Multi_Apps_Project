/**
 * 
 */
package iOS.BaseClass;

import java.io.File;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import iOS.GenericFunctions.Screenshot;
import iOS.LaunchApps.Launch_Apps;

/**
 * BASE CLASS 
 * Methods - @BeforeSuite(start server, launch app) @AfterSuite (quit app, stop server)@BeforeMethod and @AfterMethod( failure Screenshots) , @Parameters for @BeforeSuite ( bundleId, app)
 * Capture Screenshots method. 
 * Extent reports initialization and configuration 
 * @author sambeetmohapatra
 */
public class Base_Class extends Launch_Apps {


	public static String TestData_Sheet;
	public static String PageObjects_File;
	
	@Override
	@BeforeSuite
	@Parameters({"bundleId","TestData_Sheet","PageObjects_File"})
	public void before_Suite(String bundleId,String TestData_Sheet,String PageObjects_File){ //No @Optional Values are present
		Base_Class.TestData_Sheet =WORKSPACE_PATH+TestData_Sheet;
		Base_Class.PageObjects_File = WORKSPACE_PATH+PageObjects_File;

		Reporter.log("Worksheet for TestData :  " + Base_Class.TestData_Sheet ,true);
		Reporter.log("Page Objects for Test :  " + Base_Class.PageObjects_File ,true);
		Reporter.log(getFormatedDateTime()+"    ****** Suite Execution Started ****** ",true);
		
		report = new ExtentReports(REPORT_PATH+getFormatedDateTime()+".html");
		report.loadConfig(new File(EXTENT_CONFIG_FILE));
		startServer();
		Launch_iOS_Application(bundleId); // Launch the App on iPhone 7 with the Bundle ID since the app is already installed on the phone
	}
	@Override
	@BeforeMethod
	public void before_Method() {
			logger=report.startTest(this.getClass().getSimpleName());
			Reporter.log(getFormatedDateTime()+"    ***************** Execution Started : "+this.getClass().getName().trim().toUpperCase()+" *********************",true);
			
	}
	@Override
	@AfterMethod
	public void after_Method(ITestResult result) {
		try{
		 if(result.getStatus() == ITestResult.FAILURE)
	        {
	            String screenShotPath = Screenshot.getErrorCapture(" Failed_TC_"+result.getMethod().getMethodName());
	            logger.log(LogStatus.FAIL, result.getThrowable());
	            logger.log(LogStatus.FAIL, " Snapshot below: " + logger.addScreenCapture(screenShotPath));
	            goBack();
	        }
		}
		catch(Exception e){
			System.out.println(e);
		}
		//Close App
		
		
		logger.log(LogStatus.PASS, " End of Test Case :  Device Used : " +iOSDevice+" ; " +result.getMethod().getMethodName().toUpperCase()+" ; Closed Application");
		Reporter.log(getFormatedDateTime()+"    ***************** Execution Complete : " +result.getMethod().getMethodName().toUpperCase()+" ******************",true);
		//End of Test Case - Method - Extent Reports
		report.endTest(logger);
	}
	@Override
	@AfterSuite
	public void after_Suite(){
		driver.quit(); // Closes the App
		Reporter.log(getFormatedDateTime()+" - App Closed ",true);
		
		stopServer();
		
		// Add to the Extent Reports
		report.flush();
		report.close();
		Reporter.log(getFormatedDateTime()+"  *** "+iOSDevice+" | " +" ***** Suite Execution Completed *****",true);
	}
	
						/*
						 * ********************************************************
						 * ****************  REUSABLE METHODS  ********************
						 */
	
	//Take Screenshot and add it to Extent Reports
	@Override
	public void takeScreenshot(){
		Wait(1); // Wait for a second and take screenshot
		Reporter.log(getFormatedDateTime()+" -  Capturing Screenshot and Adding to Extent Reports",true);
        logger.log(LogStatus.INFO, logger.addScreenCapture( new Screenshot().capture(this.getClass().getPackage().getName().toUpperCase()+"/"+this.getClass().getName())));
	}
	
	
}

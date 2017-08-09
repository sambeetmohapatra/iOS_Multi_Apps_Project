/**
 * 
 */
package iOS.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import iOS.Constants.Constants;
import iOS.Listeners.*;
import io.appium.java_client.ios.IOSDriver;

/**
 * Contains All Reusable Methods like ( Click , Clear , Type , Swipe , Alerts , Explicit Wait , Show Attribute , Text, JavaScript Scroll
 * @author sambeetmohapatra
 *
 */
@Listeners({org.uncommons.reportng.HTMLReporter.class,org.uncommons.reportng.JUnitXMLReporter.class,TestNG_Report_CustomListener.class,MyListener.class})
public class Utility implements iOSUtility,Constants{

	public static IOSDriver<WebElement> driver;

	public static String getFormatedDateTime(){
		SimpleDateFormat sd = new SimpleDateFormat("MM_dd_yyyy_hh_mm_ss_SSS");
		return sd.format(new Date());
	}
	
	public static String getProperty(String Skey,String File) throws IOException
	{
		FileInputStream fis= new FileInputStream(File);
		Properties prop= new Properties();
		prop.load(fis);
		return prop.getProperty(Skey);
	}
	
	public void Wait(int seconds){
		try {
			Reporter.log(getFormatedDateTime()+" - "+" Waiting for : " + seconds + " second(s)",true);
			Thread.sleep(seconds*1000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement waitForElement(WebElement wb){
		Reporter.log(getFormatedDateTime()+" - "+" Waiting For Element : "+wb,true);
		WebDriverWait wait = new WebDriverWait(driver, TimeOut);
		return wait.until(ExpectedConditions.visibilityOf(wb));
	}
	public List<WebElement> waitForElements(List<WebElement> wb){
		Reporter.log(getFormatedDateTime()+" - "+" Waiting For Elements : "+wb,true);
		WebDriverWait wait = new WebDriverWait(driver, TimeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElements(wb));
	}
	
	public Alert waitForAlert(){
		Reporter.log(getFormatedDateTime()+" - "+" Waiting For alert to be displayed ",true);

		WebDriverWait wait = new WebDriverWait(driver, TimeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public boolean isElementDisplayed(WebElement wb){
		Reporter.log(getFormatedDateTime()+" - "+" Is the Element Displayed on Screen : "+wb,true);
		if(wb.isDisplayed())
			return true;
		else 
			return false;
	}
	public boolean isButtonEnabled(WebElement wb){
		Reporter.log(getFormatedDateTime()+" - "+" Is the Button Enabled on Screen : "+wb,true);
		if(wb.isEnabled())
			return true;
		else 
			return false;
	}

	public void click(WebElement wb){
		
			waitForElement(wb);
			wb.click();
			Reporter.log(getFormatedDateTime()+" - "+" Clicked :  "+wb,true);
		}	
	//Clear the fields 
		public  void clearTextField(WebElement element) {
			waitForElement(element);
			element.clear();
		}
		
	public void type(WebElement wb,String values){
		while(true) {
			try {
		waitForElement(wb);
		wb.clear();
		wb.sendKeys(values);
		Reporter.log(getFormatedDateTime()+" - "+" Send Keys :  "+wb,true);
		break;
			}
			catch(Exception e) {
				driver.hideKeyboard();
			}
			
			}
	}
	
	public String showText(WebElement wb){
		waitForElement(wb);
		Reporter.log(getFormatedDateTime()+" - "+" Fetching the text : "+wb);
		return wb.getText().trim();
	}
	
	public String showAttribute(WebElement wb,String attribute){
		waitForElement(wb);
		Reporter.log(getFormatedDateTime()+" - "+" Fetching the Attribute : "+ attribute + " - Element : "+wb,true);
		return wb.getAttribute(attribute);
		
	}
	public Alert switchToAlert(){
		Reporter.log(getFormatedDateTime()+" - "+" Switched To Alert",true);
		return driver.switchTo().alert();

	}
	public Alert acceptAlert(){
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Reporter.log(getFormatedDateTime()+" - "+" Accepted Alert",true);
		return alert;
	}
	public Alert dismissAlert(){
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		Reporter.log(getFormatedDateTime()+" - "+" Dismissed Alert",true);
		return alert;
	}
	public void swipeDown_Vertical(int noOfTimes){
		//Get the size of screen.
		  Dimension size = driver.manage().window().getSize();
		  int starty = (int) (size.height * 0.80);
		  int endy = (int) (size.height * 0.20);
		  //int startx = size.width / 2;
		  int startx = (int) (size.width * 0.70);

		  if(iOSDevice.equalsIgnoreCase("iPad")) {
			  startx = (int) (size.width * 0.10);
		  }
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		Reporter.log(getFormatedDateTime()+" - "+" Swiping Vertically Down ",true);
		for(int i = 0 ;i<noOfTimes;i++){
		driver.swipe(startx, starty, startx, endy, 1000);
		}
	}
	
	public void swipeUp_Vertical(int noOfTimes){
		//Get the size of screen.
		  Dimension size = driver.manage().window().getSize();
		  int starty = (int) (size.height * 0.80);
		  int endy = (int) (size.height * 0.20);
		  int startx = (int) (size.width * 0.70);
		  if(iOSDevice.equalsIgnoreCase("iPad")) {
			  startx = (int) (size.width * 0.10);
		  }
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

		Reporter.log(getFormatedDateTime()+" - "+" Swiping Vertically Up",true);
		for(int i = 0 ;i<noOfTimes;i++){
		driver.swipe(startx, endy, startx, starty, 1000);
		}
	}
	
	public void swipe(int startx , int starty, int endx , int endy ,int duration, int noOfTimes){
		Reporter.log(getFormatedDateTime()+" - "+"Swiping ",true);
		for(int i = 0 ;i<noOfTimes;i++){
		driver.swipe(startx, starty, endx, endy, 1000);
		}
	}
	
	public void swipe_Down_VerticalAndTap(WebElement wb){
		do{
			try{
				Assert.assertTrue(wb.isDisplayed());
				Tap_on_element(wb);
				break;
			}
			catch (AssertionError e) {
				Dimension size = driver.manage().window().getSize();
				  int starty = (int) (size.height * 0.80);
				  int endy = (int) (size.height * 0.20);
				  int startx = (int) (size.width *0.70);
				  if(iOSDevice.equalsIgnoreCase("iPad")) {
					  startx = (int) (size.width *0.10);
				  }
					Reporter.log(getFormatedDateTime()+" - "+" Swiping Down to Element"+wb,true);
					driver.swipe(startx, starty, startx, endy, 1000);
				}
			}while(true);
	}
	
	public void swipe_Up_VerticalAndTap(WebElement wb){
		do{
			try{
				Assert.assertTrue(wb.isDisplayed());
				Tap_on_element(wb);
				break;
			}
			catch (AssertionError e) {
				Dimension size = driver.manage().window().getSize();
				  int starty = (int) (size.height * 0.20);
				  int endy = (int) (size.height * 0.80);
				  int startx = (int) (size.width *0.70);
				  if(iOSDevice.equalsIgnoreCase("iPad")) {
					  startx = (int) (size.width *0.10);
				  }
					Reporter.log(getFormatedDateTime()+" - "+" Swiping Up to Element "+wb,true);
					driver.swipe(startx, starty, startx, endy, 1000);
				}
			}while(true);
	}
	
	public void swipe_Down_VerticalToElement(WebElement wb){
		do{
			try{
				Assert.assertTrue(wb.isDisplayed());
				break;
			}
			catch (AssertionError e) {
				Dimension size = driver.manage().window().getSize();
				  int starty = (int) (size.height * 0.80);
				  int endy = (int) (size.height * 0.20);
				  int startx = (int) (size.width *0.70);
				  if(iOSDevice.equalsIgnoreCase("iPad")) {
					  startx = (int) (size.width *0.10);
				  }
					Reporter.log(getFormatedDateTime()+" - "+" Swiping Down to Element"+wb,true);
					driver.swipe(startx, starty, startx, endy, 1000);
				}
			}while(true);
	}
	
	public void swipe_Up_VerticalToElement(WebElement wb){
		do{
			try{
				Assert.assertTrue(wb.isDisplayed());
				break;
			}
			catch (AssertionError e) {
				Dimension size = driver.manage().window().getSize();
				  int starty = (int) (size.height * 0.20);
				  int endy = (int) (size.height * 0.80);
				  int startx = (int) (size.width *0.70);
				  if(iOSDevice.equalsIgnoreCase("iPad")) {
					  startx = (int) (size.width *0.10);
				  }
					Reporter.log(getFormatedDateTime()+" - "+" Swiping Down to Element"+wb,true);
					driver.swipe(startx, starty, startx, endy, 1000);
				}
			}while(true);
	}		
	
	public void goBack(){
		if(iOSDevice.equalsIgnoreCase("iPhone")) {
		driver.navigate().back();
		Reporter.log(getFormatedDateTime()+" - "+" Go Back",true);
		}
		else 	if(iOSDevice.equalsIgnoreCase("iPad")) {
		
			do {
			try {
				driver.findElementByAccessibilityId("Back").click();
				break;
			}
			catch (Exception e) {
				break;
			}
			}while(true);
		}

	}
		
	
	public void Validate_Is_Displayed(WebElement wb) {
		Reporter.log(getFormatedDateTime()+" -  Validating Element by Displayed " + wb,true);
		Assert.assertTrue(isElementDisplayed(wb),wb+ "  : Element Not Displayed");		
	}
	
	public void RotateApp(String Orientation){
		
		if(Orientation.equalsIgnoreCase("Potrait"))
			driver.rotate(ScreenOrientation.PORTRAIT);
		else if(Orientation.equalsIgnoreCase("Landscape"))
			driver.rotate(ScreenOrientation.LANDSCAPE);
		
		Reporter.log(getFormatedDateTime()+ " - " +" Changed Orientation : " +Orientation,true);
	}
	
	public void Tap_on_element(WebElement wb){
		driver.tap(1, wb, 1000);
		Reporter.log(getFormatedDateTime()+" - "+" Single Tap On Element : " +wb,true);

	}

/*Extra Reusable methods*/
	
	public  void passThisStep(String reasonForPass) {
		Assert.assertTrue(true, reasonForPass);
		}

	public  void failThisStep(String reasonForFailing) {
		Assert.fail(reasonForFailing);
		}
	
	
	
			/************************** WEB VIEW METHODS *********************************/
	
	public void WebView_ScrollDown(int noOfTimes) {
		Reporter.log(getFormatedDateTime()+ " - " +" Web View : Scrolling Down : " ,true);

		for(int i=0;i<noOfTimes;i++) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,200)", "");
		}
	}
	
	public void WebView_ScrollDown_ToElement(WebElement wb) {
		Reporter.log(getFormatedDateTime()+ " - " +" Web View : Scrolling Down to element : "+wb ,true);

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView()",wb);
		}
	
	public void WebView_ScrollToBottom() {
		Reporter.log(getFormatedDateTime()+ " - " +" Web View : Scrolling To Bottom of Screen : " ,true);

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");		
			
		}
	}
	
	

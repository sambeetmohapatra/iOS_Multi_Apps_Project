/**
 * 
 */
package iOS.POMLibrary;

import java.util.List;

import org.openqa.selenium.WebElement;

import iOS.GenericFunctions.JSON_ReadWrite;
import iOS.Utilities.Utility;


/**
 * @author sambeetmohapatra
 *
 */
public class Get_WebElement_JSON extends Utility {
	
	public String filename;
	
	public Get_WebElement_JSON(String filename) {
		this.filename=filename;
	}
	
	 //To find element using accessibility id
	public WebElement getElementByAccessibilityId(String key) throws Exception{
		return driver.findElementByAccessibilityId(JSON_ReadWrite.Read_Json_Data(key,filename));
	}
	 //To find element using name
	public WebElement getElementByName(String key) throws Exception{
		return driver.findElementByName(JSON_ReadWrite.Read_Json_Data(key,filename));
	}
	
	//To find element using XPATH
	public WebElement getElementByXpath(String key) throws Exception{
		return driver.findElementByXPath(JSON_ReadWrite.Read_Json_Data(key,filename));
	}
	
	//To find multiple elements using XPATH
	public List<WebElement> getElementsByXpath(String key) throws Exception{
		return driver.findElementsByXPath(JSON_ReadWrite.Read_Json_Data(key,filename));
	}
	
	

}

/**
 * 
 */
package iOS.POMLibrary;

import java.util.List;

import org.openqa.selenium.WebElement;

import iOS.GenericFunctions.XML_ReadWrite;
import iOS.Utilities.Utility;

/**
 * @author sambeetmohapatra
 * FORMAT FOR FETCHING VALUES FROM XML  : PageName/ElementName .. Remember to use " / " !! 
 */
public class Get_WebElement_XML extends Utility {
	
	public String filename;
	
	public Get_WebElement_XML(String filename) {
		this.filename=filename;
	}
	
	//To find element using XPATH
	public WebElement getElementByXpath(String PageName_ElementName) throws Exception{
		XML_ReadWrite xml_parse = new XML_ReadWrite(filename);
		return driver.findElementByXPath(xml_parse.read_XML(PageName_ElementName));
	}
	//To find multiple elements using XPATH
	public List<WebElement> getElementsByXpath(String PageName_ElementName) throws Exception{
		XML_ReadWrite xml_parse = new XML_ReadWrite(filename);
		return driver.findElementsByXPath(xml_parse.read_XML(PageName_ElementName));
	}
	
	

}

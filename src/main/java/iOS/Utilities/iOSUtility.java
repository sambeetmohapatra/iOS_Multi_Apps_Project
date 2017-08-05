package iOS.Utilities;
/**
 * @author sambeetmohapatra
 *
 */

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public interface iOSUtility {
	
	public void Wait(int seconds);
	public WebElement waitForElement(WebElement wb);
	public List<WebElement> waitForElements(List<WebElement> wb);
	public Alert waitForAlert();
	public boolean isElementDisplayed(WebElement wb);
	public void click(WebElement wb);
	public  void clearTextField(WebElement element);
	public void type(WebElement wb,String values);
	public String showText(WebElement wb);
	public String showAttribute(WebElement wb,String attribute);
	public Alert switchToAlert();
	public Alert acceptAlert();
	public Alert dismissAlert();
	public void swipeDown_Vertical(int noOfTimes);
	public void swipeUp_Vertical(int noOfTimes);
	public void swipe(int startx , int starty, int endx , int endy ,int duration, int noOfTimes);
	public void swipe_Down_VerticalAndTap(WebElement wb);
	public void swipe_Up_VerticalAndTap(WebElement wb);
	public void swipe_Down_VerticalToElement(WebElement wb);
	public void swipe_Up_VerticalToElement(WebElement wb);
	public void goBack();
	public void RotateApp(String Orientation);
	public void Tap_on_element(WebElement wb);
	public void WebView_ScrollDown(int noOfTimes); 
	public void WebView_ScrollDown_ToElement(WebElement wb); 
	public void WebView_ScrollToBottom(); 
	}

/**
 * 
 */
package iOS.POMLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import iOS.Utilities.Utility;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author sambeetmohapatra
 *
 */
public class WebView_MyStore_POM extends Utility {

	
	public WebView_MyStore_POM(IOSDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_query_top")
	public WebElement Search_txtbox;
	
	@FindBy(css="button[name='submit_search']")
	public WebElement Submit_Btn;
	
	@FindBy(xpath="//h5[@itemprop='name']//a[normalize-space()='Printed Chiffon Dress'][@class='product-name']")
	public WebElement Chiffon_Dress_Result_label;
	
	@FindBy(xpath="//h5[@itemprop='name']//a[normalize-space()='Printed Chiffon Dress']/../following-sibling::div/a[@title='Add to cart']")
	public WebElement Chiffon_Dress_Result_AddToCart_Btn;
	
	@FindBy(xpath="//div[@id='layer_cart']//span[@title='Close window']")
	public WebElement Added_Cart_Msg_Window_CloseBtn;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	public WebElement View_Cart_Items_Btn;
	
	@FindBy(xpath="//a[@id='button_order_cart']")
	public WebElement Checkout_Cart_Items_Btn;

	@FindBy(xpath="//h1[@id='cart_title']")
	public WebElement Shopping_Screen_Header_label;
}

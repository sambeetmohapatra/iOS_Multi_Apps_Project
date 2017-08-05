package iOS.GenericFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import iOS.Utilities.Utility;

public class Screenshot extends Utility{

	public String capture(String screenShotName)
    {
    TakesScreenshot ts = (TakesScreenshot)driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String dest =  SCREENSHOT_PATH+screenShotName+"/"+screenShotName+getFormatedDateTime()+".png";
    File destination = new File(dest);
    try {
		FileUtils.copyFile(source, destination);
	} catch (IOException e) {
		e.printStackTrace();
	}        
        return dest;
    }
	
	 public static String getErrorCapture(String screenShotName) throws IOException
	    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = ERROR_SCREENSHOT_PATH+screenShotName+"/"+screenShotName+getFormatedDateTime()+".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
	    return dest;
	    }
}

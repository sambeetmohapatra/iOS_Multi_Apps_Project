/**
 * 
 */
package iOS.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import iOS.BaseClass.Base_Class;

/** Retry The Failed Test Cases
 * @author mohaps3
 *
 */
public class Retry implements IRetryAnalyzer {

	  private int retryCount = 0;
	    private int maxRetryCount = 1;

	    
	/* (non-Javadoc)
	 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
	 */
	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
           
            
            Object currentClass = result.getInstance();
            ExtentTest logger = ((Base_Class)currentClass).logger;
            logger.log(LogStatus.SKIP, "Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
           
            
            retryCount++;
            return true;
        }
        return false;

	}


	public String getResultStatusName(int status) {
		String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
	}
}

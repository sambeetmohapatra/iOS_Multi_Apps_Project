package iOS.BaseClass;

import org.testng.ITestResult;

public interface iOSBase_Class {
	public void Launch_iOS_Application(String BundleId);
	public void startServer();
	public void stopServer();
	public void takeScreenshot();
	public void before_Suite(String BundleId,String TestData_Sheet,String PageObjects_File);
	public void before_Method();
	public void after_Method(ITestResult result);
	public void after_Suite();
}

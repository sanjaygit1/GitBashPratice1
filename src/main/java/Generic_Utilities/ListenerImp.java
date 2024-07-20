package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenerImp implements ITestListener
{

	 ExtentReports report;
	 ExtentTest test;
	
public void onTestFailure(ITestResult result){
	
//        test.log(Status.FAIL, result.getMethod().getMethodName());
//		test.log(Status.FAIL, result.getThrowable());
		
		System.out.println("<--------I am Listening----------->");
		 
//		String screenShot=null;
//		
//			try {
//screenShot = WebDriver_Utility.takeScreenShot(BaseClass.sDriver, result.getMethod().getMethodName());
//			} catch (Throwable e) {
//				
//				e.printStackTrace();
//			}
//	
//		test.addScreenCaptureFromPath(screenShot);
		TakesScreenshot takesSceenShot = (TakesScreenshot)BaseClass.sDriver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/image.png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	return dst.getAbsolutePath();
}
}
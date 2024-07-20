package Generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernerImplementations implements ITestListener{

	public void onTestFailure(ITestResult result)
	{
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("./Screenshots/failedss"+ranNum+".png");
	    try {
	    	FileUtils.copyFile(src, dest);
	    }catch (Exception e) {
			e.printStackTrace();
		}
	}

}

package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {

	/**
	 * This method is used to maximize the window
	 * @param driver
	 */
	public void maximizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This methos is used to wait elements to get loaded in webpage
	 * @param driver
	 */
	public void  implicity_Wait(WebDriver driver)
	{
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method is used for WindowSwitching
	 * @param driver
	 * @param particalTitle
	 */
	public  void windowHandling(WebDriver driver,String particalTitle)

{
		 Set<String> wins = driver.getWindowHandles();
		    Iterator<String> it = wins.iterator();
			 while(it.hasNext())
		    {
		    	String win = it.next();
		    	driver.switchTo().window(win);
		    	String currentTitle = driver.getTitle();
		    if(currentTitle.contains(particalTitle))
		    {
		    	break;
		    }
		   }
		}
	
	/**
	 * This method is used to accept Alert popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 *  This method is used to dismiss Alert popup
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();;
	}
	
	public void moveToElement(WebDriver driver,WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable {
		
		TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
		File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/" + screenShotName +".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
}
}

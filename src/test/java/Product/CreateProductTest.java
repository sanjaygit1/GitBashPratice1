package Product;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;

//@Listeners(Generic_Utilities.ListenerImplementation.class)
public class CreateProductTest extends BaseClass {

	@Test
	public void createProductTest() throws Throwable {
	
         VtigerHomePage home = new VtigerHomePage(driver);
         home.clickProductLink();
		
        CreateProductPage page = new CreateProductPage(driver);
        page.clickOnPlusSign();
        int ranNum = jlib.getRandomNum();
       String prdData = elib.getExcelData("Product", 0, 0)+ranNum;
   //    Assert.assertEquals(false, true);
		
       page.enterProductName(prdData);
       page.clickOnSaveButton();
		Thread.sleep(3000);
		
	}

}

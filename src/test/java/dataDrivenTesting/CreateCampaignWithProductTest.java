package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CampWithPrdWindowSwitching;
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateProductPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateCampaignWithProductTest extends BaseClass{

	@Test(groups = "regressionTest")
	public void createCampaignWithProductTest() throws Throwable {
		
       
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
	      
	    int ranNum = jlib.getRandomNum();
	     
	    String prdData = elib.getExcelData("Product", 0, 0)+ ranNum;  
			         
	    prdPage.enterProductName(prdData);
	    prdPage.clickOnSaveButton();
	        
	    home.clickMoreLink();
	    home.clickCampaignsLink();
		
		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.clickOnPlusSign();
	
		String campData = elib.getExcelData("Campaigns", 0, 0)+ranNum;
		campPage.enterCampaignName(prdData);

		CampWithPrdWindowSwitching Switching = new CampWithPrdWindowSwitching(driver);
		Switching.clickOnPrdPlusSign();
		
        wlib.windowHandling(driver, "Products&action");
	    
        Switching.enterPrdName(prdData);
        Switching.searchPrdName();
        
	//  driver.findElement(By.xpath("//a[text()='Bluetooth202']")).click();
	    
	 //   driver.findElement(By.xpath("//a[text()='"+prdData+"']")).click();
        Switching.prdDynamicElement(driver, prdData);
	
	    wlib.windowHandling(driver, "Campaigns&action");
	    
	    campPage.clickOnSaveButton();
			
		Thread.sleep(2000);
	
		}

}

package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import Object_Repository.CreateCampaignPage;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

public class CreateCampaignsTest extends BaseClass {
@Test(groups = "smokeTest")
	public void CreateCampaignsTest() throws Throwable {
       
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampaignsLink();

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
        campPage.clickOnPlusSign();
		
		int ranNum = jlib.getRandomNum();
		
        String campData = elib.getExcelDataUsingDataFormatter("Campaigns", 0, 0)+ranNum;
	     campPage.enterCampaignName(campData);
	     campPage.clickOnSaveButton();
	
	     Thread.sleep(2000);

        }
}

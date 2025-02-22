package Organization;

import java.io.FileInputStream;
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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import Object_Repository.CreateOrganizationPage;
import Object_Repository.ValidationAndVerificationPage;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;
//@Listeners(Generic_Utilities.ListenerImp.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = {"smokeTest","regressionTest"})
	public void createOrganizationTest() throws Throwable {
	
        VtigerHomePage home = new VtigerHomePage(driver);
		home.clickOrganizationLink();
	
		CreateOrganizationPage orgPage = new CreateOrganizationPage(driver);
		orgPage.clickPlusImg();
	
		int ranNum = jlib.getRandomNum();
        String orgData = elib.getExcelDataUsingDataFormatter("Organization", 0, 0)+ranNum;
        String phoneNum = elib.getExcelDataUsingDataFormatter("Organization", 1, 0);
        String emailId = elib.getExcelDataUsingDataFormatter("Organization", 2, 0);
	    orgPage.enterOrganizationData(orgData, phoneNum, emailId);
		orgPage.clickOnSaveButton();
	//	Assert.assertEquals(true, false);
		ValidationAndVerificationPage orgValid = new ValidationAndVerificationPage(driver);
	    orgValid.orgValidation(driver, orgData);
		
}
}

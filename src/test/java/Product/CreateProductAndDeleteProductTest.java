package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import Object_Repository.DeletePrd;
import Object_Repository.VtigerHomePage;
import Object_Repository.VtigerLoginPage;

//@Listeners(Generic_Utilities.ListernerImplementations.class)
public class CreateProductAndDeleteProductTest extends BaseClass {

	@Test
	public void createProductAndDeleteProductTest() throws Throwable {
	    VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProductLink();
		
		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.clickOnPlusSign();
     
        int ranNum = jlib.getRandomNum();
		
        String prdData = elib.getExcelData("Product", 0, 0)+ranNum;
        prdPage.enterProductName(prdData);
        prdPage.clickOnSaveButton();
		      
        home.clickProductLink();
    
      //  Assert.assertEquals(true, false);
        DeletePrd delete = new DeletePrd(driver);
        delete.selectPrdCheckBox(driver, prdData);
        //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='Product Name']/../preceding-sibling::td/input[@type='checkbox']")).click();
        //driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr//td//a[text()='"+prdData+"']/../preceding-sibling::td/input[@type='checkbox']")).click();
        
        delete.clickOnDeleteButton();
        wlib.alertAccept(driver);

        delete.ValidatePrdName(driver, prdData);
        Thread.sleep(1000);
}

}

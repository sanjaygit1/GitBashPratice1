package pratice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKartPhoneEx {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("phone",Keys.ENTER);
        
		List<WebElement> phnName = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
	    List<WebElement> phnPrice = driver.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
	
	   for (int i = 0; i <phnName.size(); i++)
	   {
		System.out.println(phnName.get(i).getText()+"----------"+phnPrice.get(i).getText());
	}
	}

}

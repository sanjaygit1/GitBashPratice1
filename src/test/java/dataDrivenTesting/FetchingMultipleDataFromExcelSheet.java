package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleDataFromExcelSheet {

	public static void main(String[] args) throws Throwable {

	      //Step1:- Path Connection of the physical File
			FileInputStream fis = new FileInputStream("./src/test/resources/ExcelTestData7pm.xlsx");

			        //step2:- keep Excel_File in Read mode
			         Workbook book = WorkbookFactory.create(fis);
				
			         //step3:- get control of the sheet
			         Sheet sheet = book.getSheet("Sheet1");
			         
			         int rowNum = sheet.getLastRowNum();
			         System.out.println(rowNum);
			         
			         for (int i = 0; i < rowNum; i++) 
			         {
			        	Row row = sheet.getRow(i);
			        	for (int j = 0; j <row.getLastCellNum(); j++) 
			        	{
			        		Cell cell = row.getCell(j);
			        	//	String link = cell.getStringCellValue();
			        	//	System.out.println(link);
			        		
			       	DataFormatter format = new DataFormatter();
			       	String link = format.formatCellValue(cell);
			        	System.out.println(link);
			        	}
			        	
					}
			         
			         
	}

}

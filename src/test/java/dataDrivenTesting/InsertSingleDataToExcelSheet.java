package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertSingleDataToExcelSheet {

	public static void main(String[] args) throws Throwable {
		
		//Step1:- Path Connection of the physical File
		FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Documents\\ExcelTestData7pm.xlsx");

		        //step2:- keep Excel_File in Read mode
		         Workbook book = WorkbookFactory.create(fis);
			
		         //step3:- get control of the sheet
		         Sheet sheet = book.getSheet("Sheet1");
		         
		         //step4:- set Row Number
		         Row row = sheet.createRow(3);
		         
		         //step5:- set Cell Number
		         Cell cell = row.createCell(3);
		         
		         //step6:- set cell value
		         cell.setCellValue("Bluetooth");
		         
                 //step7:- Excel sheet in a Write Mode
		         FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\Shobha\\\\Documents\\\\ExcelTestData7pm.xlsx");
		         book.write(fos);
		         book.close();
	}

}

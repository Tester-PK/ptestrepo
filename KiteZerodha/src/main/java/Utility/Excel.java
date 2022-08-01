package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getTestData(int row, int cell, String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("F:\\Automation\\KiteZerodha\\src\\test\\resources\\TestData.xlsx");
		String value=WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue(); // it will read excel sheet as (0 row, 0 column) //getStringCellValue() it will read the value from that perticular field
		return value; 
	}
}

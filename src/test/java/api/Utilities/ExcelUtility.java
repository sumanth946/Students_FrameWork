package api.Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public static void excel() throws EncryptedDocumentException, IOException {
		
	String filePath ="C:\\Users\\suman\\OneDrive\\Desktop\\API TESTING\\Students.xlsx";
	String sheetName ="Sheet1";
	FileInputStream file = new FileInputStream(filePath);
	Workbook workbook = WorkbookFactory.create(file);
	workbook.getSheet(sheetName).getRow(1).getCell(0).getNumericCellValue();

}
}

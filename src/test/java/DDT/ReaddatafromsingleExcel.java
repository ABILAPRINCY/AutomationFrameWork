package DDT;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddatafromsingleExcel 
{

	public static void main(String[] args) throws Throwable 
	{
	
		//step1: Path setting of Excel File
		FileInputStream fis=new FileInputStream("D:\\PRINCY\\SeleniumFiles\\ReadData1.xlsx");
		
		//step2: Keep the file in read mode
		Workbook book= WorkbookFactory.create(fis);
		
		//step3: Navigate to the sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//step4: Navigate to the row
		Row row = sheet.getRow(0);
		
		//step5: Navigate to the column
		Cell cell=row.getCell(0);
		
		String ExcelData=cell.getStringCellValue();
		System.out.println(ExcelData);
	}
		}



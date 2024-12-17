package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InserSingledataintoExcel 
{
public static void main(String[] args)throws Throwable
{
	FileInputStream fis=new FileInputStream("D:\\PRINCY\\SeleniumFiles\\ReadData1.xlsx");
	
	Workbook book=WorkbookFactory.create(fis);
	
	Sheet sheet=book.getSheet("Sheet1");
	Row row=sheet.createRow(5);
	Cell cell=row.createCell(5);
	cell.setCellValue("QSPIDERS");
	
	//keep Excel File in Write mode
	
	FileOutputStream fos = new FileOutputStream("D:\\PRINCY\\SeleniumFiles\\ReadData1.xlsx");
	book.write(fos);
	book.close();
	
	
	
}
}

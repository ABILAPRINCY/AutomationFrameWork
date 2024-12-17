package DDT;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FetchmultiplelinksfromExcel 
{
	public static void main(String[] args) throws Throwable 
	{
		
		FileInputStream fis = new FileInputStream("D:\\PRINCY\\SeleniumFiles\\ReadData2.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet=book.getSheet("Sheet1");
        int rowNum = sheet.getLastRowNum()+1;
        System.out.println(rowNum);
        
        for(int i=0; i < rowNum; i++)
        {
        	Row row = sheet.getRow(i);
       	
        //for(int j=0; j < row.getLastCellNum(); j++)//in case of multiple column give
		//{
		Cell cell=row.getCell(0);
		String links=cell.getStringCellValue();
		System.out.println(links);
		//}
        }
	}
}

package LEAD;

import java.io.FileInputStream;
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

import Generic_Utilities.Java_Utility;

public class CreateLead {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver;
		FileInputStream fis = new FileInputStream("D:\\PRINCY\\SeleniumFiles\\CommonData.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}     

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Lead...\"]")).click();
		//-----------------------------------------------------------------------------------------------------------

				// step1:- Path setting of the Excel file
				FileInputStream fis1 = new FileInputStream("D:\\PRINCY\\SeleniumFiles\\ReadData1.xlsx");

				// step2:- keep the File in read mode
				Workbook book = WorkbookFactory.create(fis1);

				// step3:- Navigating to the sheet
				Sheet sheet = book.getSheet("Lead");

				Random ran1 = new Random();
				int ranNum1 = ran1.nextInt(1000);
			   Row row1 = sheet.getRow(0);			
			   Cell cell1 = row1.getCell(0);
			   String fName = cell1.getStringCellValue() + ranNum1;
			   System.out.println(fName);
			   				
			   Random ran2 = new Random();
			   int ranNum2 = ran2.nextInt(1000);
			   Row row2 = sheet.getRow(1);
			   Cell cell2 = row2.getCell(0);
               String lName = cell2.getStringCellValue() + ranNum2;
			   System.out.println(lName);
			   
			   Random ran3 = new Random();
			   int ranNum3 = ran3.nextInt(1000);
			   Row row3 = sheet.getRow(2);
			   Cell cell3 = row3.getCell(0);
               String CName = cell3.getStringCellValue() + ranNum3;
			   System.out.println(CName);
			   
			   driver.findElement(By.name("firstname")).sendKeys(fName);
			   driver.findElement(By.name("lastname")).sendKeys(lName);
			   driver.findElement(By.name("company")).sendKeys(CName);
			
			   
			   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			   
			   String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
			   String actData2 = driver.findElement(By.xpath("//span[@id='dtlview_Company']")).getText();
			   if ((actData1.contains(lName)) && (actData2.contains(CName)) )
			   {
					System.out.println("Lead is created");
					}
				else {
					System.out.println("Lead is not created");
				}

			 //----------------------------------------------------------------------------------------------------------
				driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
				driver.findElement(By.linkText("Sign Out")).click();
			}

}

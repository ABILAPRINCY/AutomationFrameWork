package CAMPAIGN;

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

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;

public class CreateCampaign {

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

		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
//-----------------------------------------------------------------------------------------------------------
		// RanDom Class----->generating unique values(Avoid Duplicate value)
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
	
	//-------------------------------------------------------------------------------------------------------
		
		// step1:- Path setting of the Excel file
		FileInputStream fis1 = new FileInputStream("D:\\PRINCY\\SeleniumFiles\\ReadData1.xlsx");

		// step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating to the sheet
		Sheet sheet = book.getSheet("Campaign");

		// Step4:- Navigating to the Row
	   Row row = sheet.getRow(0);

		// Step5:- Navigating to the Cell
		Cell cell = row.getCell(0);
		String CampName = cell.getStringCellValue() + ranNum;
		System.out.println(CampName);
		
		// ------------------------------------------------------------------------------------------------------
				
		driver.findElement(By.name("campaignname")).sendKeys(CampName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//------------------------------------------------------------------------------------
		Thread.sleep(2000);
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		if (actData.contains(CampName)) {
			System.out.println("Campaign name is created");
			}
			else {
			System.out.println("Campaign name is not created");
			}
		//---------------------------------------------------------------------------------------------
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
			
	}
}

package CAMPAIGN;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

public class AddProductToCampaign 
{
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

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();

		//RanDom Class----->generating unique values(Avoid Duplicate value)
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		
		
		// ----------------------------------------------------------------------------------------------------------
		// step1:- Path setting of the Excel file
		FileInputStream fis1 = new FileInputStream("D:\\PRINCY\\SeleniumFiles\\ReadData1.xlsx");

		// step2:- keep the File in read mode
		Workbook book = WorkbookFactory.create(fis1);

		// step3:- Navigating to the sheet
		Sheet sheet = book.getSheet("Product");

		// Step4:- Navigating to the Row
		Row row = sheet.getRow(0);

		// Step5:- Navigating to the Cell
		Cell cell = row.getCell(0);

		String PrdName = cell.getStringCellValue() + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//------------------------------------------------------------------------------------------------------
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();

		driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
//==========================================================================
		
		Random ran1 = new Random();
		int ranNum1 = ran1.nextInt(1000);
// ----------------------------------------------------------------------------------------------------------
		// step1:- Path setting of the Excel file
		FileInputStream fis2 = new FileInputStream("D:\\PRINCY\\SeleniumFiles\\ReadData1.xlsx");

		// step2:- keep the File in read mode
		Workbook book1 = WorkbookFactory.create(fis2);

		// step3:- Navigating to the sheet
		Sheet sheet1 = book1.getSheet("Campaign");

		// Step4:- Navigating to the Row
		Row row1 = sheet1.getRow(0);

		// Step5:- Navigating to the Cell
		Cell cell1 = row1.getCell(0);

		String CampName = cell1.getStringCellValue() + ranNum1;
		System.out.println(CampName);

		driver.findElement(By.name("campaignname")).sendKeys(CampName);

		driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();

		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();

		while (id.hasNext()) 
		{
			String win = id.next();
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if (title.contains("Products&action"))

			{
				break;
			}
		}
		driver.findElement(By.name("search_text")).sendKeys(PrdName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		
		//Dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
		
		Set<String> allWins1 = driver.getWindowHandles();
		Iterator<String> id1 = allWins1.iterator();

		while (id1.hasNext()) 
		{
			String win1 = id1.next();
			driver.switchTo().window(win1);
			String title1 = driver.getTitle();
			if (title1.contains("Campaigns&action"))

			{
				break;
			}
		}
driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
		String actData = driver.findElement(By.id("dtlview_Campaign Name")).getText();
	
	if(actData.contains(CampName))
	{
		System.out.println("Campaign Name is Created");
		}
	else
	{
		System.out.println("Campaign Name is not Created");
	}
	
	//-------------------------------------------------------------------------------------
	 String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
     
     if(actData1.contains(PrdName))
     {
     	System.out.println("Product Name is created");
     }
     else
     {
     	System.out.println("Product Name is not Created");
     }
	 driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
     driver.findElement(By.linkText("Sign Out")).click();
	}

}

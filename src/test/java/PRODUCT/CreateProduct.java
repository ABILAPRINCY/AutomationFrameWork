package PRODUCT;
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
public class CreateProduct 
{
	public static void main(String[] args)throws Throwable
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
	driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();
	
	
	//-----------------------------------------------------------------------------------------------------------
			//RanDom Class----->generating unique values(Avoid Duplicate value)
			Random ran = new Random();
			int ranNum = ran.nextInt(1000);
	//----------------------------------------------------------------------------------------------------------		
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

			String ProName = cell.getStringCellValue() + ranNum;
			System.out.println(ProName);
	// ------------------------------------------------------------------------------------------------------
			driver.findElement(By.name("productname")).sendKeys(ProName);
	//-----------------------------------------------------------------------------------
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//------------------------------------------------------------------------------------
			Thread.sleep(2000);
			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
			if (actData.contains(ProName)) {
				System.out.println("Product name is created");
				}
			else {
				System.out.println("Product name is not created");
			}
	//---------------------------------------------------------------------------------------------
			driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
			driver.findElement(By.linkText("Sign Out")).click();
	
	}
}

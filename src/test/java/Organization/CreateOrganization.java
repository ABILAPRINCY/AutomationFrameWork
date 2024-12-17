package Organization;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class CreateOrganization 
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
			
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.cssSelector("[alt=\"Create Organization...\"]")).click();
		//_____________________________________________________________________
			
			// RanDom Class----->generating unique values(Avoid Duplicate value)
			Random ran = new Random();
			int ranNum = ran.nextInt(1000);
			
			//---------------------------------------------------------------
			
			
			//step1: Path setting of Excel File
			FileInputStream fis1=new FileInputStream("D:\\PRINCY\\SeleniumFiles\\ReadData1.xlsx");
			
			//step2: Keep the file in read mode
			Workbook book= WorkbookFactory.create(fis1);
			
			//step3: Navigate to the sheet
			Sheet sheet = book.getSheet("Organization");
			
			
			Row row = sheet.getRow(0);
			Cell cell=row.getCell(0);
			String OrgName=cell.getStringCellValue() + ranNum;
			System.out.println(OrgName);
			//-----------------------------------------------------------------------------------
			
			Row row1 = sheet.getRow(1);
			Cell cell1 = row1.getCell(0);
			DataFormatter format1=new DataFormatter();
			String phnNum = format1.formatCellValue(cell1);
			System.out.println(phnNum);
			//----------------------------------------------------------------------------------------
			Row row2 = sheet.getRow(2);
			Cell cell2 = row2.getCell(0);
			DataFormatter format2=new DataFormatter();
			String emailId = format2.formatCellValue(cell2);
			System.out.println(emailId);
			
			//----------------------------------------------------------------------------------------
			driver.findElement(By.name("accountname")).sendKeys(OrgName);
			driver.findElement(By.id("phone")).sendKeys(phnNum);
			driver.findElement(By.id("email1")).sendKeys(emailId);

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//-------------------------------------------------------------------------------------------------------------
			Thread.sleep(2000);
			String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			if (actData.contains(OrgName)) {
				System.out.println("Organization name is created");
				}
			else {
				System.out.println("Organization name is not created");
			}
	//----------------------------------------------------------------------------------------------------------
			driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
			driver.findElement(By.linkText("Sign Out")).click();
		}

	}
			
			



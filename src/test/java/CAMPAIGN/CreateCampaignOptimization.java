package CAMPAIGN;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

public class CreateCampaignOptimization 
{

	public static void main(String[] args) throws Throwable
	{

		WebDriver driver;
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jiib=new Java_Utility();
		File_Utility flib=new File_Utility();
		Excel_Utility elib=new Excel_Utility();
		String BROWSER=flib.getKeyAndValuePair("browser");
		String URL=flib.getKeyAndValuePair("url");
		String USERNAME=flib.getKeyAndValuePair("username");
		String PASSWORD=flib.getKeyAndValuePair("password");

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
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();
//-----------------------------------------------------------------------------------------------------------
		
		int ranNum=jiib.getRandomNum();
//-------------------------------------------------------------------------------------------------------
				
		
		String CampName=elib.readExcelData("Campaign", 0, 0)+ranNum;
		
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



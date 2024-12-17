package CAMPAIGN;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;

public class AddProducttoCampainOptimization {

	public static void main(String[] args)throws Throwable 
	{
		WebDriver driver;
		WebDriver_Utility wlib = new WebDriver_Utility();
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();

		// RanDom Class----->generating unique values(Avoid Duplicate value)
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		// ----------------------------------------------------------------------------------------------------------
		Excel_Utility elib = new Excel_Utility();
		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		driver.findElement(By.name("productname")).sendKeys(PrdName);

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
//------------------------------------------------------------------------------------------------------
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();

		driver.findElement(By.cssSelector("[alt=\"Create Campaign...\"]")).click();		
		
// ----------------------------------------------------------------------------------------------------------

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;

		System.out.println(CampName);

		driver.findElement(By.name("campaignname")).sendKeys(CampName);

		driver.findElement(By.cssSelector("[alt=\"Select\"]")).click();

		wlib.swtichingWindow(driver, "Products&action");

		driver.findElement(By.name("search_text")).sendKeys(PrdName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);

		// Dynamic x path
		driver.findElement(By.xpath("//a[text()='" + PrdName + "']")).click();

		wlib.swtichingWindow(driver, "Campaigns&action");
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();

		String actData = driver.findElement(By.id("dtlview_Campaign Name")).getText();

		if (actData.contains(CampName)) {
			System.out.println("Campaign Name is Created");
		} else {
			System.out.println("Campaign Name is not Created");
		}

		// -------------------------------------------------------------------------------------
		String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();

		if (actData1.contains(PrdName)) {
			System.out.println("Product Name is created");
		} else {
			System.out.println("Product Name is not Created");
		}
		driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
	}
	}


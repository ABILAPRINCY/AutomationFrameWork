package PRODUCT;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;

public class CreateProductOptimization {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver;
		File_Utility flib=new File_Utility();
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
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Product...\"]")).click();		
		//-----------------------------------------------------------------------------------------------------------
		Java_Utility jiib=new Java_Utility();
		int ranNum=jiib.getRandomNum();		
		//----------------------------------------------------------------------------------------------------------		
		Excel_Utility elib=new Excel_Utility();
		String ProName=elib.readExcelData("Product", 0, 0)+ranNum;
		// ------------------------------------------------------------------------------------------------------
		driver.findElement(By.name("productname")).sendKeys(ProName);
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



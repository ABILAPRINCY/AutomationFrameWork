package LEAD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;

public class CreateLeadOptimized {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver;
		File_Utility flib=new File_Utility();
		Java_Utility jiib=new Java_Utility();
		Excel_Utility elib1=new Excel_Utility();
		
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
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.cssSelector("[alt=\"Create Lead...\"]")).click();
//-----------------------------------------------------------------------------------------------------------
				
		
		int ranNum=jiib.getRandomNum();
			
//-------------------------------------------------------------------------------------------------------
		
		String fName=elib1.readExcelData("Lead", 0, 0)+ ranNum;
		System.out.println(fName);
		
		Excel_Utility elib2=new Excel_Utility();
		String lName=elib2.readExcelData("Lead", 1, 0)+ ranNum;
		System.out.println(lName);			
		
		Excel_Utility elib3=new Excel_Utility();
		String CName=elib3.readExcelData("Lead", 2, 0)+ ranNum;
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



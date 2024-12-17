package LEAD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CreateLeadPage;
import ObjectRepo.LeadDetail;
import ObjectRepo.LeadValidation;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.VtigerHomePage;

public class CreateLeadPOM {

	public static void main(String[] args)throws Throwable
	{
		WebDriver driver;
		File_Utility flib=new File_Utility();
		Java_Utility jiib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		
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
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		
		LoginVtigerPage login=new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);
		
				
		VtigerHomePage home=new VtigerHomePage(driver);
		home.clickLeadLink();
		
		LeadDetail clickLead=new LeadDetail(driver);
		clickLead.clickLeadlookImg();
		
		int ranNum=jiib.getRandomNum();
			
		String fName=elib.readExcelData("Lead", 0, 0)+ ranNum;
		String lName=elib.readExcelData("Lead", 1, 0)+ ranNum;		
		String CName=elib.readExcelData("Lead", 2, 0)+ ranNum;
		System.out.println(fName);
		System.out.println(lName);
		System.out.println(CName);
		CreateLeadPage createPage = new CreateLeadPage(driver);
		createPage.firstname(fName);
		createPage.lastname(lName);
		createPage.companyname(CName);
		createPage.savebutton();
			   
	  	LeadValidation validate=new LeadValidation(driver);
	  	validate.validateLead(driver, lName, CName);
		
		home.logoutApp();
			}	

	}



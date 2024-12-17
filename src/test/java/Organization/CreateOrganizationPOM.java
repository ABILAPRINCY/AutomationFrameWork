package Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CreateOrganizationPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.OrganizationDetail;
import ObjectRepo.OrganizationValidationPage;
import ObjectRepo.VtigerHomePage;

public class CreateOrganizationPOM 
{
	public static void main(String[] args) throws Throwable
	{
		WebDriver driver;
		
		File_Utility flib=new File_Utility();
		Java_Utility jiib=new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
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
//using getter methods
//		LoginVtigerPage login = new LoginVtigerPage(driver);
//		login.getUserTextField().sendKeys(USERNAME);
//		login.getPassWordTextField().sendKeys(PASSWORD);
//		login.getLoginButton().click();
		
		LoginVtigerPage login=new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		
		VtigerHomePage home=new VtigerHomePage(driver);
		home.clickOrgLink();
				
		//Click create
		OrganizationDetail lookimg=new OrganizationDetail(driver);
		lookimg.clickOrgLookUpImg();
		
//-----------------------------------------------------------------------------------------------------------
		
		int ranNum=jiib.getRandomNum();
		String OrgName = elib.readExcelData("Organization",0,0)+ranNum;
		String phnNum = elib.readExcelDataFormatter("Organization", 1, 0);
		String emailId = elib.readExcelDataFormatter("Organization", 2, 0);
//----------------------------------------------------------------------------------------------------------
		CreateOrganizationPage createPage=new CreateOrganizationPage(driver);
		createPage.enterOrgName(OrgName);
		createPage.enterPhnNum(phnNum);
		createPage.enterMailId(emailId);
		createPage.clickSaveButton();
//-------------------------------------------------------------------------------------------------------------
		//validation
		OrganizationValidationPage validation=new OrganizationValidationPage(driver);
		validation.validateOrganization(driver, OrgName);
//----------------------------------------------------------------------------------------------------------
		
		home.logoutApp();
		
	}
	}



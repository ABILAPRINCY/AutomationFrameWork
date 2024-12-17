package CAMPAIGN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CampaignDetailPage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.VtigerHomePage;

public class CreatCampaignPOM {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver;
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
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
		
		//Using getter method
		//LoginVtigerPage login=new LoginVtigerPage(driver);
		//login.getUserTextField().sendKeys(USERNAME);
		//login.getPassWordTextField().sendKeys(PASSWORD);
		//login.getLoginButton().click();;
				
		//Login using Business Logic
		LoginVtigerPage login=new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		//Home Page
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();
		//create
		CampaignDetailPage img = new CampaignDetailPage(driver);
		img.clickCampLookUpImg();
		
		
		int ranNum=jlib.getRandomNum();
				
		String CampName=elib.readExcelData("Campaign", 0, 0)+ranNum;
		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(CampName);
		createPage.clickSaveButton();

		//validate
		CampValidatePage validate = new CampValidatePage(driver);
		validate.validateCampaign(driver, CampName);
		
		//logout
		home.logoutApp();
	}

	}



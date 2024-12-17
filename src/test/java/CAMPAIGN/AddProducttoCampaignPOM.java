package CAMPAIGN;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampaignCreateNavigationPage;
import ObjectRepo.CreateCampaignPage;
import ObjectRepo.CreateProductPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductLookUp;
import ObjectRepo.SwitchingProductPage;
import ObjectRepo.ValidateCampaignWithProduct;
import ObjectRepo.VtigerHomePage;

public class AddProducttoCampaignPOM 
{
	public static void main(String[] args) throws Throwable {

		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		String BROWSER = flib.getKeyAndValuePair("browser");
		String URL = flib.getKeyAndValuePair("url");
		String USERNAME = flib.getKeyAndValuePair("username");
		String PASSWORD = flib.getKeyAndValuePair("password");

		WebDriver driver;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new EdgeDriver();
		}
		driver.get(URL);
		LoginVtigerPage login = new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);

		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProLink();

		ProductLookUp prodImg = new ProductLookUp(driver);
		prodImg.clickOnPlusSign();
		

		int ranNum = jlib.getRandomNum();

		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;
		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterProductName(PrdName);
		prdPage.clickSaveButton();

//-----------------------------------------------------------------------------------------------------------
		// Navigating to campaign Module

		home.clickMoreLink();

		home.clickCampLink();

		CampaignCreateNavigationPage campImg = new CampaignCreateNavigationPage(driver);
		campImg.clickCampPlus();

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;
		System.out.println(CampName);

		CreateCampaignPage campPage = new CreateCampaignPage(driver);
		campPage.enterCampName(CampName);

		// Click on + sign To Navigate Product Table
		campPage.clickPrdPlusSign();

		wlib.swtichingWindow(driver, "Products&action");

		SwitchingProductPage switchWin = new SwitchingProductPage(driver);
		switchWin.enterPrdName(PrdName);
		switchWin.searchPrdName();

		// Dynamic X path
		switchWin.selectExpPrdName(driver, PrdName);

		wlib.swtichingWindow(driver, "Campaigns&action");

		
		campPage.clickSaveButton();

		ValidateCampaignWithProduct validate = new ValidateCampaignWithProduct(driver);
		validate.validateCampName(driver, CampName);

		validate.validatePrdName(driver, PrdName);

		home.logoutApp();
	}
}



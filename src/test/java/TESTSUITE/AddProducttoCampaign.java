package TESTSUITE;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampaignCreateNavigationPage;
import ObjectRepo.CreateCampaignPage;
import ObjectRepo.CreateProductPage;
import ObjectRepo.ProductLookUp;
import ObjectRepo.SwitchingProductPage;
import ObjectRepo.ValidateCampaignWithProduct;
import ObjectRepo.VtigerHomePage;

public class AddProducttoCampaign extends BaseClass
{
	@Test
	public void campaignTest() throws Throwable {

		
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

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

		
	}
}

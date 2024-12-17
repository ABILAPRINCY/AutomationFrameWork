package CROSSBROWSER;


import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.BaseClassCross;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CampaignDetailPage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.VtigerHomePage;

public class CreateCampaign1 extends BaseClassCross 
{	
	@Test
	public void createCampaignTest() throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();

		CampaignDetailPage img = new CampaignDetailPage(driver);
		img.clickCampLookUpImg();

		int ranNum = jlib.getRandomNum();
//----------------------------------------------------------------------------------------------------------		

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;

		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(CampName);;

		createPage.clickSaveButton();

		CampValidatePage validate = new CampValidatePage(driver);
		validate.validateCampaign(driver, CampName);

	}
	@Test
	public void m1()
	{
		System.out.println("hi");
	}
}

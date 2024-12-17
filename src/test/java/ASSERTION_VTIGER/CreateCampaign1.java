package ASSERTION_VTIGER;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CampaignDetailPage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.VtigerHomePage;
//@Listeners(Generic_Utilities.ListenerImp.class)
@Listeners(Generic_Utilities.ExtentReport.class)
public class CreateCampaign1 extends Base_Class
{	
	//@Test(retryAnalyzer = Generic_Utilities.RetryImp.class)
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
		
		System.out.println("Failing Script");

		int ranNum = jlib.getRandomNum();

		String CampName = elib.readExcelData("Campaign", 0, 0) + ranNum;

		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(CampName);;
		
		createPage.clickSaveButton();
		Assert.fail();
		

		CampValidatePage validate = new CampValidatePage(driver);
		String actData = validate.validateCampaign(driver, CampName);
		//Assert.assertEquals(actData,CampName);
		System.out.println("Campaign name is Created");

	}
	}

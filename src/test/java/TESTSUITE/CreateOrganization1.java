package TESTSUITE;


import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CreateOrganizationPage;
import ObjectRepo.OrganizationDetail;
import ObjectRepo.OrganizationValidationPage;
import ObjectRepo.VtigerHomePage;

public class CreateOrganization1 extends BaseClass
{
	@Test
	public void CreateOrganizationTest() throws Throwable
	{
	
		Java_Utility jiib=new Java_Utility();
		Excel_Utility elib = new Excel_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
			
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
		
	}
}

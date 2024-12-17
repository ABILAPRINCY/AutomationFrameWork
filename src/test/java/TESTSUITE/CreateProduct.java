package TESTSUITE;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import ObjectRepo.CreateProductPage;
import ObjectRepo.ProductDetailPage;
import ObjectRepo.ProductValidationPage;
import ObjectRepo.VtigerHomePage;

public class CreateProduct extends BaseClass
{
	@Test
	public void CreateProductTest() throws Throwable
	{
		
		Java_Utility jiib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		
		VtigerHomePage home=new VtigerHomePage(driver);
		home.clickProLink();
		
		ProductDetailPage lookimg=new ProductDetailPage(driver);
		lookimg.clickProductImage();
		//-----------------------------------------------------------------------------------------------------------
		
		int ranNum=jiib.getRandomNum();		
		//----------------------------------------------------------------------------------------------------------		
		
		String ProName=elib.readExcelData("Product", 0, 0)+ranNum;
		// ------------------------------------------------------------------------------------------------------
		CreateProductPage Createpage=new CreateProductPage(driver);
		Createpage.enterProductName(ProName);
		Createpage.clickSaveButton();
		//------------------------------------------------------------------------------------
		ProductValidationPage validate=new ProductValidationPage(driver);
		validate.validateProduct(driver, ProName);
		
		}	
}

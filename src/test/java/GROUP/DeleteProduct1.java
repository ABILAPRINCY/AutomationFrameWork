package GROUP;


import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CreateProductPage;
import ObjectRepo.DeleteProductName;
import ObjectRepo.ProductLookUp;
import ObjectRepo.ProductValidationPage;
import ObjectRepo.VtigerHomePage;

public class DeleteProduct1 extends Base_Class
{
	@Test(groups = "Sanity")
	public  void DeleteProductTest() throws Throwable {
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProLink();

		ProductLookUp prdImg = new ProductLookUp(driver);
		prdImg.clickOnPlusSign();

		int ranNum = jlib.getRandomNum();

		String PrdName = elib.readExcelData("Product", 0, 0) + ranNum;

		System.out.println(PrdName);

		CreateProductPage prdPage = new CreateProductPage(driver);
		prdPage.enterProductName(PrdName);
		prdPage.clickSaveButton();

		ProductValidationPage validate = new ProductValidationPage(driver);
		validate.validateProduct(driver, PrdName);

		// -------------------------------------------------------------------------------------------------------------------------
		// Navigating to product table
		home.clickProLink();

		DeleteProductName delete = new DeleteProductName(driver);
		delete.selectProdName(driver, PrdName);
		delete.selectDeletButton();

		wlib.alertAccept(driver);

		delete.validatePrdDeleted(driver, PrdName);

		
	}

}

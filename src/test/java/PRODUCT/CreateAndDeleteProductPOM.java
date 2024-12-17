package PRODUCT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CreateProductPage;
import ObjectRepo.DeleteProductName;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductDetailPage;
import ObjectRepo.ProductValidationPage;
import ObjectRepo.VtigerHomePage;

public class CreateAndDeleteProductPOM {

	public static void main(String[] args) throws Throwable
	{
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		Java_Utility jlib = new Java_Utility();
		Excel_Utility elib = new Excel_Utility();

		// Reading data from file_utility

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
			driver = new ChromeDriver();
		}
		driver.get(URL);

		LoginVtigerPage login = new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);

		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);

		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickProLink();

		ProductDetailPage prdImg = new ProductDetailPage(driver);
		prdImg.clickProductImage();

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

		home.logoutApp();
	}
	
	}



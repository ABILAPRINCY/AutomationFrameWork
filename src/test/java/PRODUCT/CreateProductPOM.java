package PRODUCT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import ObjectRepo.CreateProductPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProductDetailPage;
import ObjectRepo.ProductValidationPage;
import ObjectRepo.VtigerHomePage;

public class CreateProductPOM {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver;
		File_Utility flib=new File_Utility();
		Java_Utility jiib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		
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
		LoginVtigerPage login=new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);
		
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
		//---------------------------------------------------------------------------------------------
		home.logoutApp();
		}	

	}



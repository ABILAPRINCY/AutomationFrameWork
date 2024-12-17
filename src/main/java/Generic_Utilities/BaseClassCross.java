package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepo.LoginVtigerPage;
import ObjectRepo.VtigerHomePage;

public class BaseClassCross 
{
public WebDriver driver;
	
	@BeforeSuite
	public void bs() {
		System.out.println("DataBase connection");
	}

	@BeforeTest
	public void bt() {
		System.out.println("parallel execution");
	}
	
	@Parameters("BROWSER")
	@BeforeClass
	public void bc(String BROWSER) throws Throwable
	{
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		System.out.println("launching browser");
	}
	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod
	public void bm(String URL,String USERNAME,String PASSWORD) throws Throwable
	{
				driver.get(URL);

		// using business logics
		LoginVtigerPage login = new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME, PASSWORD);
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		System.out.println("login to application");
	}

	@AfterMethod
	public void am() {
		VtigerHomePage home = new VtigerHomePage(driver);
		home.logoutApp();
		System.out.println("logout from Application");
	}

	@AfterClass
	public void ac() {
		
		driver.close();
		System.out.println("close the browser");
	}

	@AfterTest
	public void at() {
		System.out.println("close parallel execution");
	}

	@AfterSuite
	public void as() {
		System.out.println("Data base close");
	}
}

package DDT;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class InsertDataIntoPropertiesFile 
{

	public static void main(String[] args) throws Throwable
	{
	//Insert data to properties file
	FileInputStream fis = new FileInputStream("D:\\PRINCY\\SeleniumFiles\\CommonData.properties.txt");
    Properties pro=new Properties();
    pro.setProperty("browser", "firefox");
    pro.setProperty("url", "localhost:8888");
    pro.setProperty("username", "admin");
    pro.setProperty("password", "admin");
   
    FileOutputStream fos=new FileOutputStream("D:\\PRINCY\\SeleniumFiles\\CommonProperties.properties");
    pro.store(fos,"CommanData");
    System.out.println("successfully inserted into properties file");
    /*
    //Fetching Data from properties File
    
    WebDriver driver;
    FileInputStream fis=new FileInputStream("D:\\PRINCY\\SeleniumFiles\\CommonProperties.properties.txt");
    Properties pro=new Properties();
    pro.load(fis);
    String BROWSER=pro.getProperty("browser");
    String URL =pro.getProperty("url");
    String USERNAME =pro.getProperty("username");
    String PASSWORD =pro.getProperty("password");
	
    if(BROWSER.equalsIgnoreCase("chrome"))
	{
	driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
	driver=new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
	driver=new EdgeDriver();	
	}
	else
	{
		driver=new ChromeDriver();
	}
	
   driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.name("submitButton")).click();
	*/
	}
}
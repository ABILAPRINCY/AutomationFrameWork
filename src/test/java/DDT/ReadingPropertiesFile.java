package DDT;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ReadingPropertiesFile {
	public static void main(String[] args) throws Exception 
	{
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		//Step 1: Giving physical representation of file path
		FileInputStream fis = new FileInputStream("C:\\Users\\josep\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\DATA\\PropertiesData1.properties");
		//FileInputStream fis = new FileInputStream("D:\PRINCY\SeleniumFiles\CommonData.properties");
		//step 2: Load all keys  in properties class
		Properties pro=new Properties();
		pro.load(fis);
		//Step 3: Reading keys from properties file
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		driver.get(URL);
		driver.findElement(By.name("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		driver.close();
	}
	}


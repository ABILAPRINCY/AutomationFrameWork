package DEBUG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class DEBUGEX1 
{
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http:www.flipkart.com");
		driver.manage().window().maximize();
	}
}

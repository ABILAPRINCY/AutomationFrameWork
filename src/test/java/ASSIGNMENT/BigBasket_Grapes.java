package ASSIGNMENT;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasket_Grapes 
{
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bigbasket.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebElement searchBar = driver.findElement(By.xpath("//div[@class='search-bar-container']//input[@placeholder='Search for Products...']"));
		searchBar.sendKeys("grapes", Keys.ENTER);
}
}

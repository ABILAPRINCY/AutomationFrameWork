package ASSIGNMENT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestion {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.bigbasket.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[class=\"QuickSearch___StyledMenuButton-sc-rtz2vl-1 dpuSIx\"]")).sendKeys("apple");
		
		
		driver.findElement(By.cssSelector("[placeholder=\"Search for Products...\"]")).sendKeys("apples");
		Thread.sleep(1000);
		//driver.findElement(By.xpath("//input[@placeholder=\"Search for Products...\"]")).sendKeys("apples");
		driver.findElement(By.xpath("//a[@text()=\"View all search results\"]")).click();
	}

}

package ASSIGNMENT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ProkabbadiSchedule {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/search?q=pro+kabaddi+schedule&oq");
		driver.manage().window().maximize();
		
		
		Actions a=new Actions(driver);
		a.scrollByAmount(0,700).perform();
		driver.findElement(By.xpath("//*[name()='svg' and @viewBox=\"0 0 24 24\"]")).click();
		driver.findElement(By.cssSelector("[d='M12 8l-6 6 1.41 1.41L12 10.83l4.59 4.58L18 14z']")).click();
	
	
	
	}

}

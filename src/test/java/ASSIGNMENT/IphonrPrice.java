package ASSIGNMENT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IphonrPrice {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.findElement(By.name("field-keywords")).sendKeys("iphone15",Keys.ENTER);
		List<WebElement> productTitles = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
        List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        Thread.sleep(2000);
        for (int i = 0;  i < productPrices.size(); i++) 
        {
            String title = productTitles.get(i).getText();
            String priceText = productPrices.get(i).getText().replace(",", "");
                int price = Integer.parseInt(priceText);
                if (price > 60000)
                {
                    System.out.println("Model: " + title + " | Price: ₹" + price);
                }
        
	}
driver.close();
}
}

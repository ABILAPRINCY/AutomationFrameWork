package ASSIGNMENT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KabbadiStatus
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.cssSelector("[aria-label=\"Close\"])")).click();

		driver.findElement(By.cssSelector("[class=\"close-btn\")")).click();
		 //Thread.sleep(5000);
		 /*
		// Locate the standings table (Update the locator based on the actual table on the site)
        WebElement table = driver.findElement(By.xpath("//div[contains(@class, 'table standings-table')]"));

        // Extract table rows (teams and their points)
        List<WebElement> rows = table.findElements(By.cssSelector("div.standing-table__row"));

        // Print the table header (Team, Matches, Points, etc.)
        WebElement headerRow = rows.get(0);
        List<WebElement> headers = headerRow.findElements(By.cssSelector("div"));
        for (WebElement header : headers) {
            System.out.print(header.getText() + "\t");
        }
        System.out.println();

        // Loop through the remaining rows (skip the header row)
        for (int i = 1; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.cssSelector("div"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }
        */
    }
}


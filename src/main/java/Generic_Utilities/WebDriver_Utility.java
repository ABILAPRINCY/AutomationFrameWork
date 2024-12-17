package Generic_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility 
{
/**
	 * This method is used to maximize the window
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 * This method is used to wait for page to load
 * @param driver
 */
public void waitForPageToLoad(WebDriver driver) 
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

 /**
 * @param driver
 * @param partialTitle
 */
public void swtichingWindow(WebDriver driver, String partialTitle) {
	Set<String> allWins = driver.getWindowHandles();
	Iterator<String> id = allWins.iterator();

	while (id.hasNext()) {
		String win = id.next();
		driver.switchTo().window(win);
		String title = driver.getTitle();
		if (title.contains(partialTitle))

		{
			break;
		}
	}
	}
/**
 * this method is used to accept the alert popup
 * @param driver
 */
public void alertAccept(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/** this method is used to dismiss the alert popup
 * 
 * @param driver
 */
public void alertDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

/**
 * used to Switch to Frame Window based on index
 * @param driver
 * @param index
 */
public void swithToFrame(WebDriver driver , int index) {
	driver.switchTo().frame(index);
}
/**
 * used to Switch to Frame Window based on id or name attribute
 * @param driver
 * @param id_name_attribute
 */
public void swithToFrame(WebDriver driver , String id_name_attribute) {
	driver.switchTo().frame(id_name_attribute);
}

/**
 * used to select the value from the dropDwon  based on index
 * @param driver
 * @param index
 */
public void select(WebElement element , int index) {
	Select sel = new Select(element);
	sel.selectByIndex(index);
}
/**
 * used to select the value from the dropDwon  based on value / option avlaible in GUI
 * @param element
 * @param value
 */
public void select(WebElement element , String text) {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * used to place mouse cursor on specified element
 * @param driver
 * @param element
 */
public void mouseOverOnElement(WebDriver driver , WebElement elemnet)
{
	Actions act = new Actions(driver);
	act.moveToElement(elemnet).perform();
}

/**
 * 	 used to right click  on specified element

 * @param driver
 * @param element
 */

public void rightClickOnElement(WebDriver driver , WebElement elemnet)
{
	Actions act = new Actions(driver);
	act.contextClick(elemnet).perform();
}


  	   
/**
     * pass enter Key appertain in to Browser
     * @param driver
     */
   public void passEnterKey(WebDriver driver) {
	   Actions act = new Actions(driver);
	   act.sendKeys(Keys.ENTER).perform();
   } 


/**
 * This method is used to move the cursor to a particular element
 * @param driver
 * @param element
 */
public void moveToElement(WebDriver driver,WebElement ele)
{
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
}
public static String takeScreenShot(WebDriver driver,String screenShotName) throws Throwable
{
	TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
	File src=takesScreenShot.getScreenshotAs(OutputType.FILE);
	File dsc = new File("./ScreenShots/"+ screenShotName + ".png");
	FileUtils.copyFile(src, dsc);
	return dsc.getAbsolutePath();

}
}

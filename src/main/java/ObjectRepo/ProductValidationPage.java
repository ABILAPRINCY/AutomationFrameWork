package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductValidationPage 
{
public  ProductValidationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
/**
 * 
 * @param driver
 * @param PrdName
 * @return
 */
public String validateProduct(WebDriver driver,String PrdName)
{
String actData = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
if (actData.contains(PrdName)) {
	System.out.println("Product name is created");
	}
else {
	System.out.println("Product name is not created");
}
return PrdName;
}

}

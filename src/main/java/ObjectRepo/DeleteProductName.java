package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductName 
{
	public DeleteProductName(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@value=\"Delete\"]")
	private WebElement DeleteButton;
	
	public void selectProdName(WebDriver driver,String PrdName )
	{
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName
				+ "']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	public void selectDeletButton()
	{
		DeleteButton.click();
	}
	
	public void validatePrdDeleted(WebDriver driver,String PrdName)
	{
		WebElement prd = driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='" + PrdName + "']"));
		if (prd.equals(PrdName)) {
			System.out.println("Product Name is Present");
		} else {
			System.out.println("Product name is not Present");
		}


}
}

package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage 
{
public CreateProductPage(WebDriver driver)

{
PageFactory.initElements(driver,this);	
}

@FindBy(name = "productname")
private WebElement prdName;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveButton;

//getter method
public WebElement getPrdName() {
	return prdName;
}
public WebElement getSaveButton() {
	return saveButton;
}

public void enterProductName(String name) 
{
	prdName.sendKeys(name);
}

public void clickSaveButton() {
	saveButton.click();
}

}

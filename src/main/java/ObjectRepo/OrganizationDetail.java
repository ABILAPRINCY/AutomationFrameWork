package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationDetail 
{
public OrganizationDetail(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

@FindBy(css = "[alt=\"Create Organization...\"]")
private WebElement lookUpImg;


public WebElement getLookUpImg() {
	return lookUpImg;
}


public void clickOrgLookUpImg()
{
	lookUpImg.click();
}

}

package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage 
{
public CreateLeadPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

@FindBy(name= "firstname")
private WebElement enterfirstname;

@FindBy(name= "lastname")
private WebElement enterlastname;

@FindBy(name= "company")
private WebElement entercompanyname;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveButton;

//getter method
public WebElement getEnterfirstname() {
	return enterfirstname;
}
public WebElement getEnterlastname() {
	return enterlastname;
}
public WebElement getEntercompanyname() {
	return entercompanyname;
}
public WebElement getSaveButton() {
	return saveButton;
}

public void firstname(String fname)
{
	enterfirstname.sendKeys(fname);
}

public void lastname(String lname)
{
	enterlastname.sendKeys(lname);
}

public void companyname(String cname)
{
	entercompanyname.sendKeys(cname);
}

public void savebutton() {
	saveButton.click();
}
}

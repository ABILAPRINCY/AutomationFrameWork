package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrganizationValidationPage
{
public OrganizationValidationPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}
/**
 * 
 * @param driver
 * @param OrgName
 * @return
 */
public String validateOrganization(WebDriver driver,String OrgName)
{
String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
if (actData.contains(OrgName))
{
	System.out.println("Organization name is created");
}
else {
	System.out.println("Organization name is not created");
}
return OrgName;
}
}


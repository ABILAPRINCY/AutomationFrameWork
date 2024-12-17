package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeadValidation 
{
	public LeadValidation(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * 
	 * @param driver
	 * @param lName
	 * @param CName
	 * @return
	 */
	public String validateLead(WebDriver driver,String lName,String CName)
	{
		String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		 String actData2 = driver.findElement(By.xpath("//span[@id='dtlview_Company']")).getText();
		 if ((actData1.contains(lName)) && (actData2.contains(CName)) )
				   {
						System.out.println("Lead is created");
						}
					else {
						System.out.println("Lead is not created");
					}
		return actData1;
	}
	}

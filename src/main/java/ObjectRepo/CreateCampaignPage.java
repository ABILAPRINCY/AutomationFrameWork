package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage
{
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignname")
	private WebElement campName;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@alt=\"Select\"]")
	private WebElement PrdPlusSign;

	public WebElement getCampName() {
		return campName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void enterCampName(String Name) {
		campName.sendKeys(Name);

	}

	public void clickPrdPlusSign() {
		PrdPlusSign.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}


}

package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;
public class LoginVtigerPage 
{
	//Initialization
	public LoginVtigerPage(WebDriver driver) 
	{
	PageFactory.initElements(driver,this);
	}
	
	//Element Declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindAll({@FindBy(css="[type='password']"),@FindBy(name="user_password")})
	private WebElement PassWordTextField;
	
	@FindAll({@FindBy(xpath="//input[@type=\'submit\']"),@FindBy(id="submitButton")})
	private WebElement LoginButton;
	
	
	//Getter methods
	
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPassWordTextField() {
		return PassWordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	//Business logics
	/**
	 * This method is used to login into Vtiger Aoolication
	 * @author Abila
	 */
	 public void loginIntoVtiger(String username,String password)
	 {
		 UserTextField.sendKeys(username);
		 PassWordTextField.sendKeys(password);
		 LoginButton.click();		 
	 }

	
	
}

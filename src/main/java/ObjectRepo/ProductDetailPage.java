package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage 
{
	// initialization
		public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(css = "[alt=\"Create Product...\"]")
		private WebElement lookUpImg;

		public WebElement getLookUpImg() {
			return lookUpImg;
		}
		
		public void clickProductImage()
		{
			lookUpImg.click();
		}
	
}

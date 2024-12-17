package TestNG;

import org.testng.annotations.Test;

public class Script3Test 
{
	@Test
	public void createProduct()
	{
	//error(If method fails its dependent methods will be skipped)
	System.out.println("Product Created");
	}
@Test(dependsOnMethods = "createProduct")
	public void modifyProduct()
	{
	System.out.println("Product Modified");
	}
@Test(dependsOnMethods = "createProduct")
	public void deleteProduct()
	{
	System.out.println("Product deleted");
	}
}

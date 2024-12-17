package TestNG;

import org.testng.annotations.Test;

public class Script2Test 
{
	@Test(priority=1)
		public void createProduct()
		{
		System.out.println("Product Created");
		}
	@Test(priority=2)
		public void modifyProduct()
		{
		System.out.println("Product Modified");
		}
	@Test(priority=0)
		public void deleteProduct()
		{
		System.out.println("Product deleted");
		}

}

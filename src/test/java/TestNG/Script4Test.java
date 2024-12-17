package TestNG;

import org.testng.annotations.Test;

public class Script4Test 
{@Test
		public void createProduct()
	{
		System.out.println("Product Created");
	}
@Test(enabled=false)
	public void modifyProduct()
	{
	System.out.println("Product Modified");
	}
@Test()
	public void deleteProduct()
	{
	System.out.println("Product deleted");
	}
}

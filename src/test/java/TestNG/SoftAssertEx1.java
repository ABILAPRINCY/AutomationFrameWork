package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx1 
{
	@Test
		public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(true, false);
				
		System.out.println("Step3");
		System.out.println("Step4");
		soft.assertAll();
	}
}

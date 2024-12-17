package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx 
{
	@Test(enabled=true)
public void m1()
{
	System.out.println("Step1");
	System.out.println("Step2");
	
	Assert.assertEquals(true, false);
	
	System.out.println("Step3");
	System.out.println("Step4");
}
	@Test(enabled=true)
	public void m2()
	{
	String expData="qspiders";	
	String actData="qspiders";	
	Assert.assertEquals(actData, expData);
	}
	
	@Test(enabled=true)
	public void m3()
	{
		int a=1;
		int b=10;
		Assert.assertEquals(a, b, "Not Equals=");
		System.out.println("It is equal");
		}
	@Test
	public void m4()
	{
		int a=10;
		int b=1;
		Assert.assertNotEquals(a, b, "It is equal");
		System.out.println("It is not equal");
	}
	@Test
	public void m5()
	{
		String s1="Rufin";
		String s2="Rufina";
		Assert.assertTrue(s1.equalsIgnoreCase(s2), "False=");
		System.out.println("True=");
	}
	@Test
	public void m6()
	{
		String s1="Rufin";
		String s2="Rufina";
		Assert.assertFalse(s1.equalsIgnoreCase(s2), "Equal");
		System.out.println("Data not equal");
	}
	@Test
	public void m7()
	{
		String s="Book";
		Assert.assertNull(s, "It is not Null");
		System.out.println("It is Null") ;
	}
	@Test
	public void m8()
	{
		String s=null;
		Assert.assertNull(s, "It is not Null");
		System.out.println("It is Null") ;
	}
	
	@Test
	public void m9()
	{
		String s="hello";
		Assert.assertNotNull(s, "it is  Null");
		System.out.println("it is not null");
	}
	@Test
	public void m10()
	{
		String s="hell";
		String s1="hello";
		Assert.assertSame(s, s1, "not same");
		System.out.println("it is same");
	}
	
	@Test
	public void m11()
	{
		String s="hell";
		String s1="hello";
		Assert.assertNotSame(s, s1, " same");
		System.out.println("it is not same");
	}
	
	@Test
	public void m12()
	{
		Assert.fail("Im failing the TestSCript");
	}
}


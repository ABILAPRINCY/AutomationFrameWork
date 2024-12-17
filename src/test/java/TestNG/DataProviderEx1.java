package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 
{
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest, int num)
	{
		System.out.println("Book tickets From "+ src +" to " + dest +"Number of People " + num);
	}
	@DataProvider
	public Object[][] getData()
	{
	Object[][] obj = new Object[3][3];

	obj[0][0]="Banglore";
	obj[0][1]="Goa";
	obj[0][2]=1;

	obj[1][0]="Bamglore";
	obj[1][1]="Mysore";
	obj[1][2]=3;


	obj[2][0]="Banglore";
	obj[2][1]="Chennai";
	obj[2][2]=2;

	return obj;

	}
}

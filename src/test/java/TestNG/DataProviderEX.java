package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEX
{
@Test(dataProvider = "getData")
public void bookTickets(String src, String dest)
{
	System.out.println("Book tickets From"+ src +"to" + dest);
}
@DataProvider
public Object[][] getData()
{
Object[][] obj = new Object[3][2];

obj[0][0]="Banglore";
obj[0][1]="Goa";

obj[1][0]="Bamglore";
obj[1][1]="Mysore";

obj[2][0]="Banglore";
obj[2][1]="Chennai";
return obj;

}
}

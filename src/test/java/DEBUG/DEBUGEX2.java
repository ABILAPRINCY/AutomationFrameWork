package DEBUG;

public class DEBUGEX2 {

	public static void main(String[] args) 
	{
		int a=100;
		int b=200;
		System.out.println(a);
		System.out.println(b);
		
		int temp;
		temp=a;
		a=b;
		b=temp;
		
		System.out.println(a);
		System.out.println(b);		
	}

}

import java.rmi.Naming;
import java.util.Scanner;

public class MyRmiClient 
{
	public static void main(String[] args) 
	throws Exception
	{
		// hit the url and get object of the
		// class that implements baby of remote
		BabyOfRemote br = (BabyOfRemote) Naming.lookup
		("rmi://47.30.179.75:56837/src");
		
		System.out.print("Enter a text: ");
		String text = new Scanner(System.in).nextLine();
		
		// call remote method
		System.out.println
		("Data from server is "+br.getMessage(text));
		
		
		
		
		
		
		
		
		
		
		
	}
}
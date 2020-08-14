import java.util.Scanner;

// change given data in bits, reverse them and display new Number
public class FailureFirstNaukri {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	int i=s.nextInt();
	String b="";
	
	while (i>=1)
	{
		if(i%2==0)
		{
			b=b+"0";
		}
		else
			b=b+"1";
		i=i/2;
	}
	
	int j=Integer.parseInt(b,2);
	System.out.print(j);
			}
}

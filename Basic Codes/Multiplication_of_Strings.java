import java.util.Scanner;

public class Multiplication_of_Strings
{
  public static void main(String[] args)
  {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter a number:");
    String str=s.nextLine();
    System.out.println("Enter second number:");
    String str1=s.nextLine();
    int m=0,n=0;


int []v=new int[str.length()+str1.length()];
    for(int i=0;i<str.length();i++)
    {
          for (int j =0; j <str1.length(); j++)
    {
      m=str.charAt(i)-48;
      n=str1.charAt(j)-48;
      v[i+j] = v[i+j]+m*n;
    }
    }
    for (int i=v.length-1;i>=0;i--)
    {
      System.out.println(v[i]);
    }
    }
}

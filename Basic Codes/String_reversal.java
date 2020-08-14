import java.util.Scanner;

public class String_reversal
{
  public static void main(String[] args)
  {
    Scanner s= new Scanner(System.in);
    System.out.println("Enter a String: ");
    String str=s.nextLine();
    String []str3=str.split(" ");
    String []str1=str.split("");

    for(int i=str1.length-1;i>=0;i--)
    {
      System.out.print(str1[i]);
    }
    int[]str2=new int[str.length()];
    System.out.println("\n");
    for(int i=0;i<=str3.length-1;i++)
    {
    String m=str3[i];
    for(int j=m.length()-1;j>=0;j--)
    {
      System.out.print(m.charAt(j));
    }
      System.out.print(" ");
    }


  }

}

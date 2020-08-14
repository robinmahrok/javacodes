import java.util.Scanner;

public class Conversion
{
  public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n=s.nextInt();
    System.out.println("#Menu");
    System.out.println("1. To Binary\n2. To Octal\n3. To Hexadecimal");
    int v=s.nextInt();
    // declare an empty string
    String b="\0";
    //for binary
    if(v==1)
    {
       while (n>0)
       { //put values in empty string
         b =b + n % 2;
         n = n / 2;
       }
       b=b+n%2;
       //show the new string in reverse direction
for(int i=b.length()-1;i>=0;i--)
      System.out.print(b.charAt(i));
    }
    //for octal
    else if(v==2)
    { while (n>0)
    {
      b = b+n % 8;
      n = n / 8;
    }
      b=b+n%8;
      for(int i=b.length()-1;i>=0;i--)
        System.out.print(b.charAt(i));
    }
    //for hexadecimal
    else if(v==3)
    {
       while (n>0)
       {
         int l = n % 16;
         n = n / 16;
         if (l >= 1 && l <= 9)
         {
           b = b + l;
         } else if (l <= 0)
           b = b + "0";
         else if (l > 9 && l < 16)
         {
           int u = l - 10;
           u = u + 65;
           char c = (char) u;
           b = b + c;
         }
       }  for (int i=(b.length()-1);i>=0;i--)
         {
           System.out.print(b.charAt(i));
         }

    }
    else if(v<1 || v>3)
    {
      System.out.println("invalid input!");
    }
  }
}

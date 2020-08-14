import java.util.Random;
import java.util.Scanner;

public class Otpgeneration
{
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = s.nextInt();
    int []arr=new int[n];
    //condition for n<6 and n>10
    if (n < 6 || n > 10)
    {
      System.out.println("invalid number! ");
      System.exit(0);
    } else
      {
      int j;
      Random r = new Random();
      System.out.println("OTP is: ");
        j = r.nextInt();
        if(j>=0)
        {
          for (int k = 0; k < n; k++)
          {  //get 4 remainders from given variable
            arr[k] = j % 10;
            j = j / 10;
          }
        }
        for (int i=0;i<n;i++)
      System.out.print(arr[i]);
    }
  }
}
